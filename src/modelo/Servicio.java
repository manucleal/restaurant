package modelo;

import exceptions.RestaurantException;
import java.util.ArrayList;

public class Servicio {
    
    private ArrayList<ItemServicio> itemsServicio = new ArrayList<>();
    private Mesa mesa;
    private Cliente cliente;
    public enum eventos{nuevoItem};
    
    public Servicio() {}
    
    public Servicio(Mesa mesa) {}

    public ArrayList<ItemServicio> getItemsServicio() {
        return itemsServicio;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
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
    
    public float obtenerTotalServicio() {
        float total = 0;
        for(ItemServicio item : itemsServicio) {
            total += item.getSubTotal();
        }
        return total;
    }
    
    private boolean esNumero(String num) {
        try {
            Double.parseDouble(num);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    
    public float montoTotal(){
        float montoTotal = 0;
        for(ItemServicio item : this.getItemsServicio()){
            montoTotal += item.getSubTotal();
        }
        return montoTotal;
    }

}
