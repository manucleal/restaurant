/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaEscritorio;

import controlador.ControladorLogin;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Fachada;

/**
 *
 * @author ecoitino
 */
public class VistaLoginGestor extends VistaLogin {

    public VistaLoginGestor(Frame parent, boolean modal) {
        super(parent, modal, "Login Gestor");
        controladorLogin = new ControladorLogin(null, this);
        setLocationRelativeTo(null);
    }        

    @Override
    public void login(String nombreUsuario, String password) {
        ArrayList<String> unidades = new ArrayList<String>();
        Fachada.getInstancia().getProcesadoras().forEach(u -> unidades.add(u.getNombre()));
        Object unidad = JOptionPane.showInputDialog(this,"Seleccione unidad a trabajar: ",
   "UNIDADES PROCESADORAS", JOptionPane.DEFAULT_OPTION, null,
                unidades.toArray(),"Seleccione");
        System.out.println(unidad+" "+ nombreUsuario+" " + password);
        if(unidad != null)
        controladorLogin.loginGestor(nombreUsuario, password, ""+unidad);
    }

    
}
