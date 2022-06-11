/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import modelo.ItemServicio;

/**
 *
 * @author ecoitino
 */
public class StringUtils {
    
    public static String formatEstadosPedidos(ItemServicio item) {
        String estadoPedido = item.getEstado().toString().replace("_", " ");
        if("procesado".equals(estadoPedido)) {
            estadoPedido += " (" + item.getGestor().getNombreCompleto() + ")";
        }
        return estadoPedido;      
    }    
}
