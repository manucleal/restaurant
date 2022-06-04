/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Conexion;
import Exceptions.RestaurantException;
import vistaEscritorio.VistaLogin;

/**
 *
 * @author ecoitino
 */
public abstract class ControladorLogin {
    
    protected VistaLogin vista;

    public ControladorLogin(VistaLogin vista) {
        this.vista = vista;
    }
    
    public void login(String nombreUsuario, String password) {
        try {
            Conexion conexion = (Conexion)llamarLogin(nombreUsuario, password);
            vista.cerrar();
            vista.llamarProximoCasoUso(conexion);
        } catch (RestaurantException e) {
            vista.mostrarError(e.getMessage());
        }
    }
        
    public abstract Object llamarLogin(String nombreUsuario, String password) throws RestaurantException;

}
