package modelo;

import java.util.ArrayList;
import logica.Gestor;
import logica.Usuario;

public class SistemaUsuarios {
    
    private ArrayList<Mozo> usuariosMozos = new ArrayList();
    private ArrayList<Gestor> usuariosGestores = new ArrayList();
    private ArrayList<Conexion> conexiones = new ArrayList();
    
    public Conexion loginMozo(String nombreUsuario, String password) {
        Mozo mozo = (Mozo)login(nombreUsuario, password,(ArrayList)usuariosMozos);
        return obtenerConexion(mozo);
    }
    
    public Conexion loginGestor(String nombreUsuario, String password) {
        Gestor gestor = (Gestor)login(nombreUsuario, password,(ArrayList)usuariosGestores);
        return obtenerConexion(gestor);
    }
    
    private Usuario login(String usuario, String password, ArrayList<Usuario> lista){       
        for(Usuario u: lista) {
            if(u.getNombreUsuario().equals(usuario) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }
    
    private Conexion obtenerConexion(Usuario usuario) {
        if(usuario != null) {
            Conexion conexion = new Conexion(usuario);
            if(!conexiones.contains(conexion)) {
                conexiones.add(conexion);
                return conexion;
            }          
        }
        return null;
    }
    
    public Mozo crearUsuarioMozo(String telefono, String nombreUsuario, String contrasena, String nombreCompleto) {
        Mozo mozo = new Mozo(telefono, nombreUsuario, contrasena, nombreCompleto);
        if(usuariosMozos.add(mozo)){
            return mozo;
        }
        return null;
    }
    
}
