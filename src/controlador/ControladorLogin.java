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
        if (!nombreUsuario.isEmpty() && !password.isEmpty()) {
            try {
                Conexion conexion = Fachada.getInstancia().loginMozo(nombreUsuario, password);
                vistaMozo.dispose();
                vistaMozo.llamarProximoCasoUso(conexion);
            } catch (LoginException lEx) {
                vistaMozo.mostrarError(lEx.getMessage());
            } catch (UnidadProcesadoraException uEx) {
                vistaMozo.mostrarError(uEx.getMessage());
            }
        } else {
            vistaMozo.mostrarError("Los campos no pueden ser vacíos.");
        }
    }

    public void loginGestor(String nombreUsuario, String password, UnidadProcesadora unidad) {
        if (!nombreUsuario.isEmpty() && !password.isEmpty() && unidad != null) {
            try {
                //UnidadProcesadora uProcesadora = Fachada.getInstancia().buscarConExceptionProcesadora(unidad);
                Conexion conexion = Fachada.getInstancia().loginGestor(nombreUsuario, password, unidad);
                vistaGestor.dispose();
                vistaGestor.llamarProximoCasoUso(conexion);
                //vistaGestor.llamarProximoCasoUso(obj);
            } catch (UnidadProcesadoraException uEx) {
                vistaGestor.mostrarError(uEx.getMessage());
            } catch (LoginException lEx) {
                vistaGestor.mostrarError(lEx.getMessage());
            }
        } else {
            vistaGestor.mostrarError("Los campos no pueden ser vacíos..");
        }
    }

    public void atencionMesas(Object o) {
        new VistaMozo(null, false, (Conexion) o).setVisible(true);
    }
    ////////////////////////// el profe lo tiene en la vista los new pero me parece logico que esten en el controlador como colocaron ustedes
    ////////////////////////// pero no se porque tendriamos el llamarProximo caso de uso en vista y no se hace directamente en controlador
    public void consolaPedidos(Object o){
        new VistaProcesadoraPedido(null, false,((Conexion) o)).setVisible(true);
    }

}
