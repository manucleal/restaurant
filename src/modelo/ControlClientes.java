package modelo;

import java.util.ArrayList;

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