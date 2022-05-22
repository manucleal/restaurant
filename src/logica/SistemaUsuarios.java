/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author ecoitino
 */
public class SistemaUsuarios {
    
    private ArrayList<Mozo> usuariosMozo = new ArrayList();
    private ArrayList<Conexion> conexiones = new ArrayList();
    
    public Conexion loginMozo(String nombreUsuario,String password) {
        Mozo moso = (Mozo)login(nombreUsuario, password,(ArrayList)usuariosMozo);
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
        usuariosMozo.add(new Mozo(telefono, nombreUsuario, contrasena, nombreCompleto));
        return true;
    }
    
}
