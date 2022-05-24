/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import observador.Observable;

/**
 *
 * @author ecoitino
 */
public class Servicio extends Observable {
    
    private ArrayList<ItemServicio> itemsServicio = new ArrayList<>();

    public Servicio() {}
    
    
    public void agregarItemServicio(Producto producto, int cantidad, String descripcion) {
        itemsServicio.add(new ItemServicio(producto, cantidad, descripcion) );
        avisar(producto.getUnidadProcesadora());
    }

}
