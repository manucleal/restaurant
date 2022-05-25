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
public abstract class UnidadProcesadora {
    
    protected String nombre;
    protected ArrayList<ItemServicio> itemsServicio = new ArrayList<>();
    protected ArrayList<Gestor> gestores = new ArrayList();

    public UnidadProcesadora(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }        

    public abstract void agregarGestor(Gestor gestor);
    
    public abstract void agregarPedido(ItemServicio item);
    
}
