package modelo;

import java.util.ArrayList;

public class UnidadProcesadora {
    
    protected String nombre;
    protected ArrayList<ItemServicio> itemsServicio = new ArrayList<>();
    protected ArrayList<Gestor> gestores = new ArrayList();

    public UnidadProcesadora(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }        

    public void agregarGestor(Gestor gestor)throws UnidadProcesadoraException{
        if(gestores.contains(gestor)) throw new UnidadProcesadoraException("El gestor ya se encuentra en la unidad -" + nombre+"-");
        gestores.add(gestor);
        //gestor.agregarProcesadora(this);
    };
    
    public String agregarItem(ItemServicio item) {
        return "es una unidad";
    };
    
    @Override
    public String toString(){
        return nombre;
    }
}
