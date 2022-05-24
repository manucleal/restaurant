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
public class ControlClientes {
    
    private ArrayList<Cliente> clientes = new ArrayList();
    
    protected ControlClientes() {}
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public boolean agregar(Cliente cliente) {
        if (cliente.validar() && !this.existeCliente(cliente.getId())){
            clientes.add(cliente);
            return true;
        }
        return false;
    }
    
    public boolean existeCliente(int id) {
        for(Cliente cliente : getClientes()) {
            return cliente.getId() == id;
        }
        return false;
    }    
    
}
