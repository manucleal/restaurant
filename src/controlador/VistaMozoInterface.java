/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.ItemServicio;
import modelo.Mesa;
import modelo.Producto;
import modelo.Servicio;

/**
 *
 * @author ecoitino
 */
public interface VistaMozoInterface {
    
    public void mostrarNombreUsuario(String nombreCompleto);
    
    public void mostrarMesas(ArrayList<Mesa> mesas);
    
    public void mostrarLabelMesa(int nombreMesa);
    
    public void mostrarDatosServicio(ArrayList<ItemServicio> items);
    
    public void mostrarMensaje(String msg);
    
    public void llamarVentanaCerrarMesaCliente(Servicio servicio);
    
    public void mostrarProductosConStock(ArrayList<Producto> productos);
    
    public void limpiarInputProducto();
    
    public void mostrarTotalServicio(float total);
    
}
