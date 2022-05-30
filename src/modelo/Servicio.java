package modelo;

import java.util.ArrayList;
import observador.Observable;

public class Servicio extends Observable {
    
    private ArrayList<ItemServicio> itemsServicio = new ArrayList<>();

    public Servicio() {}   

    public ArrayList<ItemServicio> getItemsServicio() {
        return itemsServicio;
    }
    
    public void agregarItemServicio(Producto producto, int cantidad, String descripcion) {
        itemsServicio.add(new ItemServicio(producto, cantidad, descripcion) );
        //avisar(producto.getUnidadProcesadora());
    }

}
