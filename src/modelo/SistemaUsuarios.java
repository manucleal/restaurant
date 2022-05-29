package modelo;

import java.util.ArrayList;
import java.util.Date;

public class SistemaUsuarios {

    private ArrayList<Mozo> usuariosMozos = new ArrayList();
    private ArrayList<Gestor> usuariosGestores = new ArrayList();
    private ArrayList<Conexion> conexionesMozo = new ArrayList();
    private ArrayList<Conexion> conexionesGestor = new ArrayList();

    public Conexion loginMozo(String nombreUsuario, String password)
            throws LoginException, UnidadProcesadoraException {

        Mozo mozo = (Mozo) login(nombreUsuario, password, (ArrayList) usuariosMozos);
        Conexion conexion = crearConexion(mozo, conexionesMozo);
        conexionesMozo.add(conexion);
        return conexion;
    }

    public Conexion loginGestor(String nombreUsuario, String password, UnidadProcesadora unidad)
            throws LoginException, UnidadProcesadoraException {
        if (nombreUsuario.isBlank() || password.isBlank() || unidad == null) {
            throw new LoginException("Los campos no pueden ser vacíos.");
        }
        Gestor gestor = (Gestor) login(nombreUsuario, password, (ArrayList) usuariosGestores);
        return agregarConexionGestor(gestor, unidad, conexionesGestor);
    }

    private Usuario login(String usuario, String password, ArrayList<Usuario> lista) throws LoginException {
        for (Usuario u : lista) {
            if (u.getNombreUsuario().equals(usuario) && u.getPassword().equals(password)) {
                return u;
            }
        }
        throw new LoginException("Nombre de usuario y/o contraseña incorrectos");
    }

    private Conexion agregarConexionGestor(Usuario usuario, UnidadProcesadora unidad, ArrayList<Conexion> lista)
            throws LoginException, UnidadProcesadoraException {
        Conexion c = crearConexion(usuario, lista);
        lista.add(c);
                System.out.println("Unidad " + unidad);
        ((Gestor) c.getUsuario()).agregarUltimaFechaConexion(new Date());
        ((Gestor) c.getUsuario()).agregarProcesadora(unidad);
        unidad.agregarGestor(((Gestor) c.getUsuario()));
        return c;
    }

    private Conexion crearConexion(Usuario usuario, ArrayList<Conexion> lista) throws LoginException {
        for (Conexion conexion : lista) {
            if (conexion.getUsuario().equals(usuario)) {
                throw new LoginException("Ud. ya está logueado");
            }
        }
        return new Conexion(usuario);
    }

    public void logoutConexionGestor(Conexion conexion) throws LoginException {
        if (!conexionesGestor.remove(conexion)) {
            throw new LoginException("No se encontro conexion");
        }
    }

    public Mozo crearUsuarioMozo(String telefono, String nombreUsuario, String contrasena, String nombreCompleto) {
        Mozo mozo = new Mozo(telefono, nombreUsuario, contrasena, nombreCompleto);
        if (usuariosMozos.add(mozo)) {
            return mozo;
        }
        return null;
    }

    public Gestor crearUsuarioGestor(String nombreUsuario, String contrasena, String nombreCompleto) throws UsuarioException {
        if (nombreUsuario.isBlank()
                || contrasena.isBlank()
                || nombreCompleto.isBlank()) {
            throw new UsuarioException("Nomre de usuario, contraseña y nombre completo son requeridos.");
        }
        Gestor gestor = new Gestor(null, nombreUsuario, contrasena, nombreCompleto);
        if (gestor == null) {
            throw new UsuarioException("No se pudo crear el usuario gestor.");
        }
        if (!usuariosGestores.add(gestor)) {
            throw new UsuarioException("El usuario no se pudo agregar al sistema.");
        }
        return gestor;
    }

}
