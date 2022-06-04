/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Exceptions.RestaurantException;
import modelo.Conexion;
import modelo.Fachada;
import modelo.Mesa;
import modelo.Mozo;
import vistaEscritorio.VistaMozo;

/**
 *
 * @author ecoitino
 */
public class ControladorMozo {

    private VistaMozo vistaMozo;
    private Conexion conexion;
    private Mozo modelo;
    private Mesa mesaSeleccionada;

    public ControladorMozo(VistaMozo vista, Conexion conexion) {
        this.vistaMozo = vista;
        this.conexion = conexion;
        this.modelo = (Mozo) conexion.getUsuario();
        inicializarVista();
    }

    private void inicializarVista() {
        vistaMozo.setLocationRelativeTo(null);
        vistaMozo.mostrarNombreUsuario(conexion.getUsuario().getNombreCompleto());
        vistaMozo.mostrarMesas(modelo.getMesas());
        cargarDatosMesaSeleccionada(modelo.getMesas().get(0));
    }
    
    public void cargarDatosMesaSeleccionada(Mesa mesa) {
        this.mesaSeleccionada = mesa;
        vistaMozo.mostrarLabelMesa(mesa.getNumero());
        vistaMozo.mostrarDatosServicio(mesa.getServicio().getItemsServicio());     
    }
    
    public void abrirMesa(){
        try{
            String msg = mesaSeleccionada.abrirMesa();
            vistaMozo.mostrarMensaje(msg);
        }catch(RestaurantException e){
            vistaMozo.mostrarMensaje(e.getMessage());
        }
    }
    
    public void cerrarMesa(){
        try{
            if(!mesaSeleccionada.estaCerrada("La mesa no está abierta")){
                vistaMozo.llamarVentanaCerrarMesaCliente(mesaSeleccionada.getServicio());
            }
        }catch(RestaurantException e){
            vistaMozo.mostrarMensaje(e.getMessage());
        }        
    }

    public void agregarProducto() {
        try {
            if(!mesaSeleccionada.estaCerrada("La mesa está cerrada")) {
                vistaMozo.mostrarProductosConStock(Fachada.getInstancia().obtenerProductosConStock());
            }
        } catch (RestaurantException e) {
            vistaMozo.mostrarMensaje(e.getMessage());
        }
    }
    
    
}
