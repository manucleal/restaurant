/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
    Fachada logica = Fachada.getInstancia();

    public ControladorProcesadoraPedido(VistaProcesadoraPedido vista,Conexion conexionGestor) {
        this.conexion = conexionGestor;
        this.procesadora = ((Gestor)conexionGestor.getUsuario()).getProcesadora();
        this.vistaProcesadora = vista;
        this.vistaProcesadora.setLocationRelativeTo(null);
        this.procesadora.agregarObservador(this);
        iniciarItems();
        procesadora.agregarObservador(this);
    }    

    public void logout() {
        try {
            logica.logoutConexion(conexion);     
        } catch (RestaurantException ex) {
            vistaProcesadora.mostrarError(ex.getMessage());
        }
    }
    
    public void iniciarItems(){
        mostrarItemsSinProcesar();
        mostrarPedidosTomados();
    }
    
    public void mostrarItemsSinProcesar(){
        vistaProcesadora.mostrarItemsSinProcesar(procesadora.getItemsSinSerTomados());
    }
    
    public void mostrarPedidosTomados(){
        vistaProcesadora.mostrarPedidosTomados(((Gestor)conexion.getUsuario()).getItemsProcesando());
    }

    public void pedidoTomado(ItemServicio item){
        Gestor gestor = (Gestor)conexion.getUsuario();
        try {
            if(item == null)throw  new RestaurantException("No seleccionó ningun item");
            gestor.agregarItem(item);
            item.agregarGestor(gestor);
            procesadora.itemTomado(item);
        } catch (RestaurantException ex) {
            vistaProcesadora.mostrarError(ex.getMessage());
        }
        iniciarItems();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(UnidadProcesadora.eventos.nuevoItem)){
            mostrarItemsSinProcesar();
        }else if (evento.equals(UnidadProcesadora.eventos.itemTomado)){
            iniciarItems();
        }
    }    

}