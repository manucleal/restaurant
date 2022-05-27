package logica;

import java.util.ArrayList;

public class SistemaUsuarios {
    
    private ArrayList<Mozo> usuariosMozos = new ArrayList();
    private ArrayList<Gestor> usuariosGestores = new ArrayList();
    private ArrayList<Conexion> conexiones = new ArrayList();
    
    public Conexion loginMozo(String nombreUsuario,String password) {
        Mozo moso = (Mozo)login(nombreUsuario, password,(ArrayList)usuariosMozos);
        Conexion conexion = null;
        if(moso != null) {
            conexion = new Conexion(moso);
            if(!conexiones.contains(conexion)) {
                conexiones.add(conexion);
            } else {
                return null;
            }           
        }
        return conexion;
    }
    
    private Usuario login(String usuario, String password, ArrayList<Usuario> lista){       
        for(Usuario u: lista) {
            if(u.getNombreUsuario().equals(usuario) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }
    
    public boolean crearUsuarioMozo(String telefono, String nombreUsuario, String contrasena, String nombreCompleto){
        usuariosMozos.add(new Mozo(telefono, nombreUsuario, contrasena, nombreCompleto));
        return true;
    }
    
}
