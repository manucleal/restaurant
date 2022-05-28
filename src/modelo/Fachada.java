/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ecoitino
 */
public class Fachada {
    
    private SistemaUsuarios sistemaUsuarios = new SistemaUsuarios();
    
    private static Fachada instancia = new Fachada();
    public static Fachada getInstancia() {
        return instancia;
    }
    private Fachada() {}   
    
    public Conexion loginMozo(String nombreUsuario, String password) {
        return sistemaUsuarios.loginMozo(nombreUsuario, password);
    }
    
    public Conexion loginGestor(String nombreUsuario, String password) {
        return sistemaUsuarios.loginGestor(nombreUsuario, password);
    }
    
    public Mozo crearUsuarioMozo(String telefono, String nombreUsuario, String contrasena, String nombreCompleto) {
        return sistemaUsuarios.crearUsuarioMozo(telefono, nombreUsuario, contrasena, nombreCompleto);
    }
}
