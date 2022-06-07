/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author faustoperillo
 */
public abstract class TipoCliente {
    
    private String nombre;
    protected Cliente cliente;

    public TipoCliente(String nombre) {
        this.nombre = nombre;    
    }

    public String getNombre() {
        return nombre;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public abstract void obtenerMontoBeneficio();

}
