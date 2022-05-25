/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author ecoitino
 */
public class Bar extends UnidadProcesadora {

    public Bar(String nombre) {
        super(nombre);
    }
    
    //validar
    @Override
    public void agregarGestor(Gestor gestor) {
        gestores.add(gestor);
    }    
    
    //validar
    @Override
    public void agregarPedido(ItemServicio item) {
        itemsServicio.add(item);
    }
        
}
