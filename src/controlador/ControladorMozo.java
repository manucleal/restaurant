/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Conexion;
import modelo.Fachada;
import modelo.ItemServicio;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Producto;
import modelo.RestaurantException;
import modelo.Transferencia;
import modelo.UnidadProcesadora;
import observador.Observable;
import observador.Observador;
import vistaEscritorio.VistaMozo;

/**
 *
 * @author ecoitino
 */
public class ControladorMozo implements Observador {

    private VistaMozo vistaMozo;
    private Conexion conexion;
    private Mozo modeloMozo;
    private Mesa mesaSeleccionada;

    public ControladorMozo(VistaMozo vista, Conexion conexion) {
        this.vistaMozo = vista;
        this.conexion = conexion;
        this.modeloMozo = (Mozo)conexion.getUsuario();
        this.modeloMozo.agregarObservador(this);
        this.inicializarVista();
    }

    private void inicializarVista() {
        vistaMozo.setLocationRelativeTo(null);
        vistaMozo.mostrarNombreUsuario(conexion.getUsuario().getNombreCompleto());
        vistaMozo.mostrarMesas(modeloMozo.getMesas());
        vistaMozo.mostrarProductosConStock(Fachada.getInstancia().obtenerProductosConStock());
        cargarDatosMesaSeleccionada(modeloMozo.getMesas().get(0));
    }
    
    public void cargarDatosMesaSeleccionada(Mesa mesa) {
        this.mesaSeleccionada = mesa;
        vistaMozo.mostrarLabelMesa(mesa.getNumero());
        vistaMozo.mostrarDatosServicio(mesa.getServicio().getItemsServicio());
        vistaMozo.mostrarTotalServicio(mesaSeleccionada.getServicio().obtenerMontoTotalServicio());
    }
    
    public void abrirMesa() {
        try{
            if(mesaSeleccionada == null) throw new RestaurantException("No seleccionaste una mesa");
            vistaMozo.mostrarMensaje(mesaSeleccionada.abrirMesa());
        }catch(RestaurantException e){
            vistaMozo.mostrarMensaje(e.getMessage());
        }
    }
    
    public void llamarVentanaCerrarMesa() {
        try{
            if(mesaSeleccionada == null) throw new RestaurantException("No seleccionaste una mesa");
            if(!mesaSeleccionada.estaCerrada("La mesa no está abierta") && !mesaSeleccionada.tienePedidosPendientes()){
                vistaMozo.llamarVentanaCerrarMesa(mesaSeleccionada.getServicio());
            }
        }catch(RestaurantException e){
            vistaMozo.mostrarMensaje(e.getMessage());
        }        
    }

    public void agregarProducto(Producto producto, String descripcion, String cantidad) {
        try {
            if(mesaSeleccionada == null) throw new RestaurantException("No seleccionaste una mesa");
            if(!mesaSeleccionada.estaCerrada("La mesa está cerrada")) {
                mesaSeleccionada.getServicio().agregarItemServicio(producto, descripcion, cantidad);
                accionesItemAgregado();
            }
        } catch (RestaurantException e) {
            vistaMozo.mostrarMensaje(e.getMessage());
        }
    }
    
    private void accionesItemAgregado() {
        vistaMozo.mostrarDatosServicio(mesaSeleccionada.getServicio().getItemsServicio());
        vistaMozo.mostrarProductosConStock(Fachada.getInstancia().obtenerProductosConStock());
        vistaMozo.limpiarInputProducto();
        vistaMozo.mostrarTotalServicio(mesaSeleccionada.getServicio().obtenerMontoTotalServicio());
    }

    public void logout() {
        try {
            if(this.modeloMozo.tienePedidoPendiente()) throw new RestaurantException("Debe cerrar las mesas abiertas antes de salir");
            Fachada.getInstancia().logoutConexionMozo(conexion);
            this.modeloMozo.quitarObservador(this);
            vistaMozo.dispose();
        } catch (RestaurantException e) {
            vistaMozo.mostrarMensaje(e.getMessage());
        }
    }

    public void transferirMesa() {
        try {
            if(mesaSeleccionada == null) throw new RestaurantException("No seleccionaste una mesa");
            vistaMozo.llamarVentanaTransferencia(mesaSeleccionada);
        } catch(RestaurantException e) {
            vistaMozo.mostrarMensaje(e.getMessage());        
        }
    }    
    
    public void procesarRespuestaMozoDestino(int respuestaMozoDestino, Transferencia transferencia) {
        //0=si, 1=no, 2=cancelar
        switch (respuestaMozoDestino) {
            case 0:
                // le agrega la mesa al mozo destino y se la quita al mozo origen
                transferencia.getMozoDestino().reasingnarMesa(transferencia);                                
                transferencia.getMesa().getServicio().avisarUnidadesProcesadoras();
                vistaMozo.mostrarMesas(transferencia.getMozoDestino().getMesas());
                transferencia.getMozoOrigen().avisar(Transferencia.eventos.transferenciaAceptada);
                break;
            case 1:
            case 2:
                transferencia.getMozoOrigen().avisar(Transferencia.eventos.transferenciaRechazada);
                break;                           
            default:
                transferencia.getMozoOrigen().avisar(Transferencia.eventos.transferenciaRechazada);
        }
    }
    
    @Override
    public void actualizar(Object evento, Observable origenEvento) {
        if(evento.equals(Transferencia.eventos.nuevaTranferencia)) {
            Mozo mozoDestino = (Mozo)origenEvento;
            Transferencia transferencia = mozoDestino.getTransferenciaRecibida();
            if(transferencia != null) {
                vistaMozo.mostrarNotificaciónTransferencia(transferencia);                                      
            }            
        }else if(evento.equals(Mozo.eventos.mesaCerrada)) {
            vistaMozo.mostrarDatosServicio(mesaSeleccionada.getServicio().getItemsServicio());
            vistaMozo.mostrarTotalServicio(mesaSeleccionada.getServicio().obtenerMontoTotalServicio());
        }else if(evento.equals(UnidadProcesadora.eventos.hubo_cambio)) {
            vistaMozo.mostrarDatosServicio(mesaSeleccionada.getServicio().getItemsServicio());
            ItemServicio item = modeloMozo.getItemFinalizado();
            if(item != null && item.getEstado().equals(ItemServicio.estados.finalizado)) {                
                vistaMozo.mostrarNotificacionPedidoFinalizado(item);
                modeloMozo.setItemFinalizado(null);
            }
        } else if(evento.equals(Transferencia.eventos.transferenciaAceptada)) {
            vistaMozo.mostrarLabelMesa(-1);
            mesaSeleccionada = null;            
            vistaMozo.mostrarMensaje("La Transferencia fue aceptada !!");
            vistaMozo.mostrarMesas(modeloMozo.getMesas());
            vistaMozo.mostrarDatosServicio(new ArrayList<>());
        } else if(evento.equals(Transferencia.eventos.transferenciaRechazada)) {
            vistaMozo.mostrarMensaje("La Transferencia fue rechazada !!");
        }
    }

}
