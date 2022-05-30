/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.ItemServicio;
import modelo.Mesa;
import modelo.Servicio;

/**
 *
 * @author ecoitino
 */
public interface VistaMozoInterface {
    
    public void mostrarNombreUsuario(String nombreCompleto);
    
    public void mostrarMesas(ArrayList<Mesa> mesas);
    
    public void mostrarLabelMesa(String nombreMesa);
    
    public void mostrarDatosServicio(ArrayList<ItemServicio> items);
    
}
