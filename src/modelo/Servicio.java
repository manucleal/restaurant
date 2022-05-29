package modelo;

import java.util.ArrayList;
import observador.Observable;

public class Servicio extends Observable {
    
    private ArrayList<ItemServicio> itemsServicio = new ArrayList<>();
    private Mesa mesa;
    private Cliente cliente;

    public Servicio(Mesa mesa) {}
    
    
    public void agregarItemServicio(Producto producto, int cantidad, String descripcion) {
        itemsServicio.add(new ItemServicio(producto, cantidad, descripcion,this) );
        avisar(producto.getUnidadProcesadora());
    }

    public ArrayList<ItemServicio> getItemsServicio() {
        return itemsServicio;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

}
