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

    public TipoCliente(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract void obtenerBeneficio();
        
//    boolean validar() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    
}
