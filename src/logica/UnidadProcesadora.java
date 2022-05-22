/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author ecoitino
 */
public abstract class UnidadProcesadora {
    
    private String nombre;

    public UnidadProcesadora(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }        

    public abstract void agregarGestor(Gestor gestor);
    
    public abstract void agregarPedido(ItemServicio item);
    
}
