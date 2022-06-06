package modelo;

import java.util.ArrayList;

public class SistemaClientes {
    
    private ArrayList<Cliente> clientes = new ArrayList();
    private int proximoId;
    
    protected SistemaClientes() {}
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public boolean agregar(Cliente cliente) {
        if (!this.existeCliente(cliente.getId())){
            cliente.setId(generarProximoId());
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
    
    public Cliente buscarCliente(String id) {
        for(Cliente cliente : getClientes()) {
            if(cliente.getId() == Integer.parseInt(id)){
                return cliente;
            }
        }        
        return null;
    }   
    
    private int generarProximoId(){
        proximoId++;
        return proximoId;
    }
    
}