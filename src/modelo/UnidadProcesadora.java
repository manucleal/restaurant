package modelo;

import java.util.ArrayList;
import observador.Observable;

public class UnidadProcesadora extends Observable{
    
    private String nombre;
    private ArrayList<ItemServicio> itemsServicio = new ArrayList<>();
    private ArrayList<Gestor> gestores = new ArrayList();
    private ArrayList<ItemServicio> itemsSinSerTomados = new ArrayList<>();
    
    public enum eventos{nuevoItem};

    public UnidadProcesadora(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }        

    public ArrayList<ItemServicio> getItemsServicio() {
        return itemsServicio;
    }

    public ArrayList<Gestor> getGestores() {
        return gestores;
    }

    public ArrayList<ItemServicio> getItemsSinSerTomados() {
        return itemsSinSerTomados;
    }

    public void agregarGestor(Gestor gestor)throws UnidadProcesadoraException{
        if(gestor == null) throw new UnidadProcesadoraException("No se puede agregar un gestor null a unidad procesadora");
        if(gestores.contains(gestor)) throw new UnidadProcesadoraException("El gestor ya se encuentra en la unidad -" + nombre+"-");
        gestores.add(gestor);
        //gestor.agregarProcesadora(this);
    };
    
    public void agregarItem(ItemServicio item) throws UnidadProcesadoraException {
        if(item == null) throw new UnidadProcesadoraException("No se puede agregar un item null a unidad procesadora");
        itemsServicio.add(item);
        itemsSinSerTomados.add(item);
        avisar(eventos.nuevoItem);
    };
    
    @Override
    public String toString(){
        return nombre;
    }
    
    
}
