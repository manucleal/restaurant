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
public class Cocina extends UnidadProcesadora {
    
    private ArrayList<ItemServicio> itemsServicio = new ArrayList<>();
    private ArrayList<Gestor> gestores = new ArrayList();

    public Cocina(String nombre) {
        super(nombre);
    }

    @Override
    public void agregarGestor(Gestor gestor) {
        gestores.add(gestor);
    }

    @Override
    public void agregarPedido(ItemServicio item) {
        itemsServicio.add(item);
    }
    
}
