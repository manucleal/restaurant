/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author ecoitino
 */
public class Producto {
    
    private String codigo;
    private String nombre;
    private float precio;
    private int cantidadDisponible;
    private UnidadProcesadora unidadProcesadora;

    public Producto(String codigo, String nombre, float precio, int cantidadDisponible, UnidadProcesadora unidadProcesadora) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.unidadProcesadora = unidadProcesadora;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }
    
}
