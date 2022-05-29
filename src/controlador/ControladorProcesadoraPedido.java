/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Fachada;
import modelo.Gestor;
import modelo.LoginException;
import vistaEscritorio.VistaProcesadoraPedido;

/**
 *
 * @author diecu
 */
public class ControladorProcesadoraPedido {

    private Conexion conexionGestor;
    private VistaProcesadoraPedido vistaProcesadora;
    Fachada logica = Fachada.getInstancia();

    public ControladorProcesadoraPedido(Conexion conexionGestor) {
        this.conexionGestor = conexionGestor;
        vistaProcesadora = new VistaProcesadoraPedido(null,false,"Gestor - "+conexionGestor.getUsuario().getNombreCompleto(),this);
        vistaProcesadora.setLocationRelativeTo(null);
        vistaProcesadora.setVisible(true);
    }

    public void logout(){
        try {
            logica.logoutConexionGestor(conexionGestor);
            ((Gestor)(conexionGestor.getUsuario())).quitarProcesadora();
        } catch (LoginException ex) {
            vistaProcesadora.mostrarError(ex.getMessage());
        }
    }
    
    
}
