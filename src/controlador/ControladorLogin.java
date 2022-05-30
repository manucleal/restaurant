/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

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
        if (!nombreUsuario.isEmpty() && !password.isEmpty()) {
            try {
                Conexion conexion = Fachada.getInstancia().loginMozo(nombreUsuario, password);
                vistaMozo.cerrar();
                vistaMozo.llamarProximoCasoUso(conexion);
            } catch (LoginException | UnidadProcesadoraException e) {
                vistaMozo.mostrarError(e.getMessage());
            }
        } else {
            vistaMozo.mostrarError("Los campos no pueden ser vacíos.");
        }
    }

    public void loginGestor(String nombreUsuario, String password, UnidadProcesadora unidad) {
        if (!nombreUsuario.isEmpty() && !password.isEmpty() && unidad != null) {
            try {
                Conexion conexion = Fachada.getInstancia().loginGestor(nombreUsuario, password, unidad);
                vistaGestor.cerrar();
                vistaGestor.llamarProximoCasoUso(conexion);
            } catch (UnidadProcesadoraException | LoginException e) {
                vistaGestor.mostrarError(e.getMessage());
            }
        } else {
            vistaGestor.mostrarError("Los campos no pueden ser vacíos..");
        }
    }

}
