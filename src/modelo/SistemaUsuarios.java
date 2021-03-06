package modelo;

import java.util.ArrayList;
import java.util.Date;

public class SistemaUsuarios {

    private ArrayList<Mozo> usuariosMozos = new ArrayList();
    private ArrayList<Gestor> usuariosGestores = new ArrayList();
    private ArrayList<Conexion> conexionesMozo = new ArrayList();
    private ArrayList<Conexion> conexionesGestor = new ArrayList();
    
    protected SistemaUsuarios() {}

    public Conexion loginMozo(String nombreUsuario, String password) throws RestaurantException {
        Mozo mozo = (Mozo) login(nombreUsuario, password, (ArrayList) usuariosMozos);
        Conexion conexion = crearConexion(mozo, conexionesMozo);
        conexionesMozo.add(conexion);
        return conexion;
    }

    public Conexion loginGestor(String nombreUsuario, String password) throws RestaurantException {
        Gestor gestor = (Gestor) login(nombreUsuario, password, (ArrayList) usuariosGestores);
        Conexion conexion = crearConexion(gestor, conexionesGestor);
        conexionesGestor.add(conexion);
        gestor.agregarUltimaFechaConexion(new Date());
        return conexion;
    }

    private Usuario login(String nombreUsuario, String password, ArrayList<Usuario> lista) throws RestaurantException {
        if (nombreUsuario.isBlank() || password.isBlank()) throw new RestaurantException("Nombre de usuario y/o contraseña incorrectos");
        for (Usuario u : lista) {
            if (u.getNombreUsuario().equals(nombreUsuario) && u.getPassword().equals(password)) {
                return u;
            }
        }
        throw new RestaurantException("Nombre de usuario y/o contraseña incorrectos");
    }

    private Conexion crearConexion(Usuario usuario, ArrayList<Conexion> lista) throws RestaurantException {
        for (Conexion conexion : lista) {
            if (conexion.getUsuario().equals(usuario)) {
                throw new RestaurantException("Ud. ya está logueado");
            }
        }
        return new Conexion(usuario);
    }
    
    public void logoutConexionGestor(Conexion conexion) throws RestaurantException {
        if (conexionesGestor.remove(conexion)) {
            ((Gestor)conexion.getUsuario()).quitarProcesadora();
        } else {
            throw new RestaurantException("No se encontro conexion");
        }        
    }
    
    public void logoutConexionMozo(Conexion conexion) throws RestaurantException {
        if (!conexionesMozo.remove(conexion)) {
            throw new RestaurantException("No se encontro conexion");
        }
    }

    public Mozo crearUsuarioMozo(String telefono, String nombreUsuario, String contrasena, String nombreCompleto) throws RestaurantException {
        Mozo mozo = new Mozo(telefono, nombreUsuario, contrasena, nombreCompleto);
        if (!mozo.validar()) {
            throw new RestaurantException("Nomre de usuario, contraseña y nombre completo son requeridos.");
        }
        if (!usuariosMozos.add(mozo)) {
            throw new RestaurantException("El usuario no se pudo agregar al sistema.");
        }
        return mozo;
    }

    public Gestor crearUsuarioGestor(String nombreUsuario, String contrasena, String nombreCompleto) throws RestaurantException {        
        Gestor gestor = new Gestor(nombreUsuario, contrasena, nombreCompleto);
        if (!gestor.validar()) {
            throw new RestaurantException("Nomre de usuario, contraseña y nombre completo son requeridos.");
        }
        if (!usuariosGestores.add(gestor)) {
            throw new RestaurantException("El usuario no se pudo agregar al sistema.");
        }
        return gestor;
    }   

    public ArrayList<Mozo> obtenerMozosLogueadosConMenosDeCincoMesas(Mozo mozoActual) {
        ArrayList<Mozo> mozosLogueadosConMenosDeCincoMesas = new ArrayList<>();
        for(Conexion conexion : conexionesMozo) {
            Mozo mozo = (Mozo)conexion.getUsuario();
            if(mozo.validarCantidadMesasMozo() && !mozoActual.equals(mozo)) {
                mozosLogueadosConMenosDeCincoMesas.add(mozo);
            }
        }
        return mozosLogueadosConMenosDeCincoMesas;
    }

}
