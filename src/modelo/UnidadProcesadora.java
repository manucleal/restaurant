package modelo;

import java.util.ArrayList;
import observador.Observable;

public class UnidadProcesadora extends Observable {
    
    private String nombre;
    private ArrayList<Gestor> gestores = new ArrayList();
    private ArrayList<ItemServicio> itemsSinSerTomados = new ArrayList<>();


    public enum eventos { hubo_cambio, finalizado };

    public UnidadProcesadora(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Gestor> getGestores() {
        return gestores;
    }

    public ArrayList<ItemServicio> getItemsSinSerTomados() {
        return itemsSinSerTomados;
    }

    public void agregarGestor(Gestor gestor)throws RestaurantException{
        if(gestor == null) throw new RestaurantException("No se puede agregar un gestor null a unidad procesadora");
        gestores.add(gestor);
    }
    
    public void quitarGestor(Gestor gestor)throws RestaurantException{
        if(gestor == null) throw new RestaurantException("No se puede quitar un gestor null a unidad procesadora");
        if(!gestores.contains(gestor)) throw new RestaurantException("El gestor no se encuentra en la unidad -" + nombre+"-");
        gestores.remove(gestor);
    }
    
    public void agregarItem(ItemServicio item) throws RestaurantException {
        if(item == null) throw new RestaurantException("No se puede agregar un item vacío a unidad procesadora");
        itemsSinSerTomados.add(item);
        avisar(eventos.hubo_cambio);
    }
    
    public void itemTomado(ItemServicio item) throws RestaurantException{
        if(item == null) throw new RestaurantException("No se puede tomar un item vacío");
        if(!itemsSinSerTomados.contains(item)) throw new RestaurantException("no se encuentra item sin ser tomado.");
        itemsSinSerTomados.remove(item);
        avisar(eventos.hubo_cambio);
    }   
    
    @Override
    public String toString(){
        return nombre;
    }    
}
