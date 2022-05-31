/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Conexion;
import modelo.LoginException;
import modelo.UnidadProcesadoraException;
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
        if (!nombreUsuario.isEmpty() && !password.isEmpty()) {
            try {
                Conexion conexion = (Conexion)llamarLogin(nombreUsuario, password);
                vista.cerrar();
                vista.llamarProximoCasoUso(conexion);
            } catch (LoginException | UnidadProcesadoraException e) {
                vista.mostrarError(e.getMessage());
            }
        } else {
            vista.mostrarError("Los campos no pueden ser vacíos.");
        }
    }
        
    public abstract Object llamarLogin(String nombreUsuario, String password) throws LoginException, UnidadProcesadoraException;

}
