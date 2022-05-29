/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaEscritorio;

import controlador.ControladorLogin;
import java.awt.Frame;

/**
 *
 * @author ecoitino
 */
public class VistaLoginMozo extends VistaLogin {

    public VistaLoginMozo(Frame parent, boolean modal) {
        super(parent, modal, "Login Mozo");
        controladorLogin = new ControladorLogin(this, null);
    }    
    
    @Override
    public void login(String nombreUsuario, String password) {
        controladorLogin.loginMozo(nombreUsuario, password);
    }

    /*@Override
    public void llamarProximoCasoUso(Object obj) {
        controladorLogin.atencionMesas(obj);
    }*/

}
