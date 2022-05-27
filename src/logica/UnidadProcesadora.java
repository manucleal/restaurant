package logica;

import java.util.ArrayList;

public class UnidadProcesadora {
    
    protected String nombre;
    protected ArrayList<ItemServicio> itemsServicio = new ArrayList<>();
    protected ArrayList<Gestor> gestores = new ArrayList();

    public UnidadProcesadora(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }        

    public void agregarGestor(Gestor gestor){
    
    };
    
    public void agregarItem(ItemServicio item) {
    
    };
    
}
