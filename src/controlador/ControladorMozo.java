/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Conexion;
import modelo.Fachada;
import modelo.ItemServicio;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Producto;
import modelo.RestaurantException;
import modelo.Servicio;
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
        inicializarVista();
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
            String msg = mesaSeleccionada.abrirMesa();
            vistaMozo.mostrarMensaje(msg);
        }catch(RestaurantException e){
            vistaMozo.mostrarMensaje(e.getMessage());
        }
    }
    
    public void llamarVentanaCerrarMesa() {
        try{
            if(!mesaSeleccionada.estaCerrada("La mesa no está abierta") && !mesaSeleccionada.tienePedidosPendientes()){
                vistaMozo.llamarVentanaCerrarMesa(mesaSeleccionada.getServicio());
            }
        }catch(RestaurantException e){
            vistaMozo.mostrarMensaje(e.getMessage());
        }        
    }

    public void agregarProducto(Producto producto, String descripcion, String cantidad) {
        try {
            if(!mesaSeleccionada.estaCerrada("La mesa está cerrada")) {
                ItemServicio item = mesaSeleccionada.getServicio().agregarItemServicio(producto, descripcion, cantidad);
                item.agregarObservador(this);
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
            Fachada.getInstancia().logoutConexionMozo(conexion);
        } catch (RestaurantException e) {
            vistaMozo.mostrarMensaje(e.getMessage());
        }
    }

    @Override
    public void actualizar(Object evento, Observable origenEvento) {
        if(evento.equals(Transferencia.eventos.nuevaTranferencia)) {
            Mozo mozoDestino = (Mozo)origenEvento;
            Transferencia transferencia = mozoDestino.getTransferenciaRecibida();
            if(transferencia != null) {
                vistaMozo.mostrarNotificaciónTranferencia(transferencia);                                      
            }            

        }else if(evento.equals(Mozo.eventos.mesaCerrada)) {
            vistaMozo.mostrarDatosServicio(mesaSeleccionada.getServicio().getItemsServicio());
        }else if(evento.equals(ItemServicio.eventos.finalizado)){
            ItemServicio item = (ItemServicio)origenEvento;
            vistaMozo.mostrarDatosServicio(mesaSeleccionada.getServicio().getItemsServicio());
            vistaMozo.mostrarMensaje("El pedido de la mesa "+item.getServicio().getMesa().getNumero()+ " por "+
                    item.getCantidad()+" "+ item.getProducto().getNombre()+" está listo para ser retirado");
        }else if(evento.equals(ItemServicio.eventos.procesado)){
            ItemServicio item = (ItemServicio)origenEvento;
            if(mesaSeleccionada.equals(item.getServicio().getMesa())){
                vistaMozo.mostrarDatosServicio(mesaSeleccionada.getServicio().getItemsServicio());
            }
        }
    }

    public void transferirMesa() {
        vistaMozo.llamarVentanaTransferencia(mesaSeleccionada);
    }

}
