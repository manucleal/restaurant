/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.ItemServicio;

/**
 *
 * @author diecu
 */
public interface VistaProcesadoraPedidoInterface {
    
    public void mostrarError(String msg);
    
    public void mostrarItemsSinProcesar(ArrayList<ItemServicio> items);
    
    public void mostrarPedidosTomados(ArrayList<ItemServicio> items);
    
    public void mostrarTablaPedidos(ArrayList<ItemServicio> items, javax.swing.JTable tabla);
}
