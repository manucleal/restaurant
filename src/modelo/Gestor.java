package modelo;

import exceptions.RestaurantException;
import java.util.ArrayList;
import java.util.Date;

public class Gestor extends Usuario{
    
    private Date fechaUltimoAcceso;
    private UnidadProcesadora procesadora;
    private ArrayList<ItemServicio> itemsProcesando = new ArrayList<ItemServicio>();

    public Gestor(Date fechaUltimoAcceso, String nombreUsuario, String contrasena, String nombreCompleto) {
        super(nombreUsuario, contrasena, nombreCompleto);
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }

    public ArrayList<ItemServicio> getItemsProcesando() {
        return itemsProcesando;
    }

    public Date getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }
    
    public void agregarUltimaFechaConexion(Date fecha){
        this.fechaUltimoAcceso = fecha;
    }

    public UnidadProcesadora getProcesadora() {
        return procesadora;
    }
    
    public void agregarProcesadora(UnidadProcesadora unidad) throws RestaurantException{
        if(procesadora != null && procesadora.equals(unidad)) throw new RestaurantException("La unidad -" + unidad.getNombre()+"- ya esta guardada en gestor");
        if(procesadora != null) throw new RestaurantException("El gestor ya tiene otra unidad cargada");
        procesadora = unidad;
    }
    
    public void quitarProcesadora() {
        procesadora = null;
    }
    
    public void agregarItem(ItemServicio item) throws RestaurantException{
        if(!itemsProcesando.contains(item)) itemsProcesando.add(item);
    }
}
