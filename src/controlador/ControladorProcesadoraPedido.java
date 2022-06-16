/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Conexion;
import modelo.Fachada;
import modelo.Gestor;
import modelo.RestaurantException;
import modelo.ItemServicio;
import modelo.UnidadProcesadora;
import observador.Observable;
import observador.Observador;
import vistaEscritorio.VistaProcesadoraPedido;

/**
 *
 * @author diecu
 */
public class ControladorProcesadoraPedido implements Observador {

    private Conexion conexion;
    private UnidadProcesadora procesadora;
    private VistaProcesadoraPedido vistaProcesadora;
    private ArrayList<ItemServicio> itemsSinProcesar;
    private ArrayList<ItemServicio> itemsTomados;
    Fachada logica = Fachada.getInstancia();

    public ControladorProcesadoraPedido(VistaProcesadoraPedido vista, Conexion conexionGestor) {
        this.conexion = conexionGestor;
        this.procesadora = ((Gestor) conexionGestor.getUsuario()).getProcesadora();
        this.vistaProcesadora = vista;
        this.vistaProcesadora.setLocationRelativeTo(null);
        this.procesadora.agregarObservador(this);
        iniciarItems();
    }

    public void logout() {
        try {
            logica.logoutConexionGestor(conexion);
            this.procesadora.quitarObservador(this);          
        } catch (RestaurantException ex) {
            vistaProcesadora.mostrarError(ex.getMessage());
        }
    }

    public void iniciarItems() {
        mostrarItemsSinProcesar();
        mostrarPedidosTomados();
    }

    public void mostrarItemsSinProcesar() {
        this.itemsSinProcesar = procesadora.getItemsSinSerTomados();
        vistaProcesadora.mostrarItemsSinProcesar(itemsSinProcesar);
    }

    public void mostrarPedidosTomados() {
        this.itemsTomados = ((Gestor) conexion.getUsuario()).getItemsProcesando();
        vistaProcesadora.mostrarPedidosTomados(itemsTomados);
    }

    public void pedidoTomado(int posicion) {
        try {            
            if (posicion != -1) {
                ItemServicio item = itemsSinProcesar.get(posicion);
                ((Gestor) conexion.getUsuario()).tomarItem(item);            
            }
            iniciarItems();
        } catch (RestaurantException ex) {
            vistaProcesadora.mostrarError(ex.getMessage());
        }
    }

    public void pedidoFinalizado(int posicion) {
        Gestor gestor = ((Gestor) conexion.getUsuario());
        try {            
            if (posicion != -1) {
                ItemServicio item = itemsTomados.get(posicion);
                gestor.finalizarItem(item);
            }
            iniciarItems();
        } catch (RestaurantException ex) {
            vistaProcesadora.mostrarError(ex.getMessage());
        }        
    }

    @Override
    public void actualizar(Object evento, Observable origen) {

        if (evento.equals(UnidadProcesadora.eventos.hubo_cambio)) {
            iniciarItems();
        }
        
    }

}
