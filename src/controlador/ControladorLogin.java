/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Fachada;
import modelo.LoginException;
import modelo.UnidadProcesadora;
import modelo.UnidadProcesadoraException;
import vistaEscritorio.VistaLoginGestor;
import vistaEscritorio.VistaLoginMozo;
import vistaEscritorio.VistaMozo;
import vistaEscritorio.VistaProcesadoraPedido;

/**
 *
 * @author ecoitino
 */
public class ControladorLogin {

    private VistaLoginMozo vistaMozo;
    private VistaLoginGestor vistaGestor;

    public ControladorLogin(VistaLoginMozo vistaMozo, VistaLoginGestor vistaGestor) {
        this.vistaMozo = vistaMozo;
        this.vistaGestor = vistaGestor;
    }

    public void loginMozo(String nombreUsuario, String password) {
        try {
            Conexion conexion = Fachada.getInstancia().loginMozo(nombreUsuario, password);
            vistaMozo.mostrarError("Acceso denegado");
            vistaMozo.dispose();
            //new ControladorMozo(conexion);
            //vistaMozo.llamarProximoCasoUso(obj);
        } catch (LoginException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loginGestor(String nombreUsuario, String password, String unidad) {
        if (!nombreUsuario.isEmpty() && !password.isEmpty() && !unidad.isEmpty()) {
            try {
                UnidadProcesadora uProcesadora = Fachada.getInstancia().buscarConExceptionProcesadora(unidad);
                Conexion conexion = Fachada.getInstancia().loginGestor(nombreUsuario, password,uProcesadora);
                vistaGestor.dispose();
                new ControladorProcesadoraPedido(conexion);
                //vistaGestor.llamarProximoCasoUso(obj);
            } catch (UnidadProcesadoraException uEx) {
                vistaGestor.mostrarError(uEx.getMessage());
            }catch (LoginException lEx) {
                vistaGestor.mostrarError(lEx.getMessage());
            } 
        } else {
            vistaGestor.mostrarError("Los campos no pueden ser vacíos.");
        }
    }

    public void atencionMesas(Object o) {
        new VistaMozo(null, false, (Conexion) o).setVisible(true);
    }

}
