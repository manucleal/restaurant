/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaEscritorio;

import controlador.ControladorLoginGestor;
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
        controladorLogin = new ControladorLoginGestor(this);
        setLocationRelativeTo(null);
    }

    @Override
    public void login(String nombreUsuario, String password) {
        unidades = Fachada.getInstancia().getProcesadoras();
        Object unidad = JOptionPane.showInputDialog(this, "Seleccione unidad a trabajar: ",
                "UNIDADES PROCESADORAS", JOptionPane.QUESTION_MESSAGE, null,
                unidades.toArray(), "");
        ////
        System.out.println(((UnidadProcesadora)unidad).agregarItem(null) + " " + nombreUsuario + " " + password);
        ////
        if (unidad != null) {
            controladorLogin.login(nombreUsuario, password);
        }
    }

    @Override
    public void llamarProximoCasoUso(Object o) {
        new VistaProcesadoraPedido(null, false,((Conexion) o)).setVisible(true);
    }

}
