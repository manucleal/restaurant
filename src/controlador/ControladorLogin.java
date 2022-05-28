/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Fachada;
import vistaEscritorio.LoginGestor;
import vistaEscritorio.LoginMozo;
import vistaEscritorio.VistaMozo;

/**
 *
 * @author ecoitino
 */
public class ControladorLogin {
    
    private LoginMozo vistaMozo;
    private LoginGestor vistaGestor;

    public ControladorLogin(LoginMozo vistaMozo, LoginGestor vistaGestor) {
        this.vistaMozo = vistaMozo;
        this.vistaGestor = vistaGestor;
    }        
    
    public void loginMozo(String nombreUsuario, String password) {
        Object obj = Fachada.getInstancia().loginMozo(nombreUsuario, password);        
        if(obj == null) {
            vistaMozo.mostrarError("Acceso denegado");
        } else {
            vistaMozo.dispose();
            vistaMozo.llamarProxmoCasoUso(obj);
        }
    }
    
    public void loginGestor(String nombreUsuario, String password) {
        Object obj = Fachada.getInstancia().loginGesgor(nombreUsuario, password);        
        if(obj == null) {
            vistaGestor.mostrarError("Acceso denegado");
        } else {
            vistaGestor.dispose();
            vistaGestor.llamarProxmoCasoUso(obj);
        }
    }
    
    public void atencionMesas(Object o) {
         new VistaMozo(null, false, (Conexion)o).setVisible(true);
    }
    
}
