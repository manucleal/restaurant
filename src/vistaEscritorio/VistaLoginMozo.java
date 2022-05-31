/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaEscritorio;

import controlador.ControladorLoginMozo;
import java.awt.Frame;
import modelo.Conexion;

/**
 *
 * @author ecoitino
 */
public class VistaLoginMozo extends VistaLogin {

    public VistaLoginMozo(Frame parent, boolean modal) {
        super(parent, modal, "Login Mozo");
        controladorLogin = new ControladorLoginMozo(this);
        setLocationRelativeTo(null);
    }    
    
    @Override
    public void login(String nombreUsuario, String password) {
        controladorLogin.login(nombreUsuario, password);
    }

    @Override
    public void llamarProximoCasoUso(Object obj) {
        new VistaMozo(null, false, (Conexion) obj).setVisible(true);
    }

}
