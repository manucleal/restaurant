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
public class LoginGestor extends Login {

    public LoginGestor(Frame parent, boolean modal) {
        super(parent, modal, "Login Gestor");
        controladorLogin = new ControladorLogin(null, this);
    }        

    @Override
    public void login(String nombreUsuario, String password) {
        controladorLogin.loginGestor(nombreUsuario, password);
    }

    @Override
    public void llamarProxmoCasoUso(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
