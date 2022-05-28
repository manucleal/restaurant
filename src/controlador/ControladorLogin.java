/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Fachada;
import vistaEscritorio.VistaLoginGestor;
import vistaEscritorio.VistaLoginMozo;
import vistaEscritorio.VistaMozo;

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
        Object obj = Fachada.getInstancia().loginMozo(nombreUsuario, password);
        if (obj == null) {
            vistaMozo.mostrarError("Acceso denegado");
        } else {
            vistaMozo.dispose();
            vistaMozo.llamarProxmoCasoUso(obj);
        }
    }

    public void loginGestor(String nombreUsuario, String password) {
        if (!nombreUsuario.isEmpty()&& !password.isEmpty()) {
            try {
                Object obj = Fachada.getInstancia().loginGestor(nombreUsuario, password);
                vistaGestor.dispose();
                vistaGestor.llamarProxmoCasoUso(obj);
            } catch(Exception ex ) {
                vistaGestor.mostrarError(ex.getMessage());
            }
        }else{
            vistaGestor.mostrarError("Los campos no pueden ser vacíos.");
        }
    }

    public void atencionMesas(Object o) {
        new VistaMozo(null, false, (Conexion) o).setVisible(true);
    }

}
