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
    
    public Cliente buscarCliente(String id) throws RestaurantException {
        if(id.isBlank()) throw new RestaurantException("Debe ingresar id de cliente");
        if(!esNumero(id.trim())) throw new RestaurantException("Debe ingresar un numero como id");
        int idNum = Integer.parseInt(id.trim());
        for(Cliente cliente : getClientes()) {
            if(cliente.getId() == idNum){
                return cliente;
            }
        }        
        throw new RestaurantException("No se encontró al cliente");
    }   
    
    private int generarProximoId(){
        proximoId++;
        return proximoId;
    }

    private boolean esNumero(String id) {
        try {
            Integer.parseInt(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
