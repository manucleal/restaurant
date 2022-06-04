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
import Exceptions.RestaurantException;
import modelo.UnidadProcesadora;
import observador.Observable;
import observador.Observador;
import vistaEscritorio.VistaProcesadoraPedido;

/**
 *
 * @author diecu
 */
public class ControladorProcesadoraPedido implements Observador{

    private Conexion conexionGestor;
    private UnidadProcesadora procesadora;
    private VistaProcesadoraPedido vistaProcesadora;
    Fachada logica = Fachada.getInstancia();

    public ControladorProcesadoraPedido(VistaProcesadoraPedido vista,Conexion conexionGestor) {
        this.conexionGestor = conexionGestor;
        vistaProcesadora = vista;
        vistaProcesadora.setLocationRelativeTo(null);
        procesadora = ((Gestor)conexionGestor.getUsuario()).getProcesadora();
        procesadora.agregarObservador(this);
    }

    public void logout(){
        try {
            logica.logoutConexionGestor(conexionGestor);
            ((Gestor)(conexionGestor.getUsuario())).quitarProcesadora();
        } catch (RestaurantException ex) {
            vistaProcesadora.mostrarError(ex.getMessage());
        }
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(UnidadProcesadora.eventos.nuevoItem)){
            vistaProcesadora.actualizarYMostrsarItemsSinProcesar(procesadora.getItemsSinSerTomados());
        }
    }
    
    
}
