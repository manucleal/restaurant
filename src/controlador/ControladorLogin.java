/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Conexion;
import exceptions.RestaurantException;
import modelo.Fachada;
import modelo.Gestor;
import modelo.UnidadProcesadora;
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
    
    public void mostrarUnidadesProcesadoras(Conexion conexion) {
        vista.mostrarElegirUnidadesProcesadoras(Fachada.getInstancia().getProcesadoras(), conexion);
    }
    
    public void agregarUnidadProcesadoraAGestor(Object unidad, Conexion c) {
        try {
            Gestor gestor = (Gestor)c.getUsuario();
            UnidadProcesadora unidadProcesadora = (UnidadProcesadora)unidad;
            gestor.agregarProcesadora(unidadProcesadora);
            unidadProcesadora.agregarGestor(gestor);
        } catch (RestaurantException e) {
            vista.mostrarError(e.getMessage());
        }        
    }
        
    public abstract Object llamarLogin(String nombreUsuario, String password) throws RestaurantException;

}
