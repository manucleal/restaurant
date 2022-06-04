package modelo;

import exceptions.RestaurantException;
import java.util.ArrayList;
import observador.Observable;

public class Servicio extends Observable {
    
    private ArrayList<ItemServicio> itemsServicio = new ArrayList<>();
    private Mesa mesa;
    private Cliente cliente;
    public enum eventos{nuevoItem};
    
    public Servicio() {}   
    
    public Servicio(Mesa mesa) {}

    public ArrayList<ItemServicio> getItemsServicio() {
        return itemsServicio;
    }
    
    public boolean agregarItemServicio(Producto producto, String descripcion, String cantidad) throws RestaurantException {
        if(esNumero(cantidad)) {
            int cant = Integer.parseInt(cantidad);
            ItemServicio itemServicio = new ItemServicio(producto, cant, descripcion,this);
            if(!itemServicio.validar()) {
                return false;
            }
            itemsServicio.add(itemServicio);
            producto.bajarStock(cant);
            producto.agregarPedidoAUnidadProcesadora(itemServicio);
            avisar(eventos.nuevoItem);
            return true;
        }
        return false;
    }
    
    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public boolean tieneCliente(){
        return cliente != null;
    }
    
    private boolean esNumero(String num) {
        try {
            Double.parseDouble(num);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
