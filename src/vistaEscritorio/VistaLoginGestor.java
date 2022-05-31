/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaEscritorio;

import controlador.ControladorLogin;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Fachada;
import modelo.UnidadProcesadora;

/**
 *
 * @author ecoitino
 */
public class VistaLoginGestor extends VistaLogin {

    private ArrayList<UnidadProcesadora> unidades;

    public VistaLoginGestor(Frame parent, boolean modal) {
        super(parent, modal, "Login Gestor");
        controladorLogin = new ControladorLogin(null, this);
        setLocationRelativeTo(null);
    }

    @Override
    protected void login(String nombreUsuario, String password) {
        unidades = Fachada.getInstancia().getProcesadoras();
        Object unidad = JOptionPane.showInputDialog(this, "Seleccione unidad a trabajar: ",
                "UNIDADES PROCESADORAS", JOptionPane.QUESTION_MESSAGE, null,
                unidades.toArray(), "");
        if (unidad != null) {
            controladorLogin.loginGestor(nombreUsuario, password, (UnidadProcesadora) unidad);
        }
    }

    @Override
    public void llamarProximoCasoUso(Object o) {
        controladorLogin.consolaPedidos(o);
    }

}
