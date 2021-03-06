package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Gestor extends Usuario {
    
    private Date fechaUltimoAcceso;
    private UnidadProcesadora procesadora;
    private ArrayList<ItemServicio> itemsProcesando = new ArrayList<>();

    public Gestor(String nombreUsuario, String contrasena, String nombreCompleto) {
        super(nombreUsuario, contrasena, nombreCompleto);
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
    
    public void quitarProcesadora() {
        procesadora = null;
    }
    
    public void agregarProcesadora(UnidadProcesadora unidad) throws RestaurantException {
        if(procesadora != null && procesadora.equals(unidad)) throw new RestaurantException("La unidad -" + unidad.getNombre()+"- ya esta guardada en gestor");
        if(procesadora != null) throw new RestaurantException("El gestor ya tiene otra unidad cargada");
        procesadora = unidad;
        unidad.agregarGestor(this);
    }
    
    public void tomarItem(ItemServicio item) throws RestaurantException {
        if(item == null) throw new RestaurantException("No se selecciono item");
        if(itemsProcesando.contains(item)) throw new RestaurantException("El item ya fue tomado por usted.");
        itemsProcesando.add(item);
        item.agregarGestor(this);
        item.tomarItem();
        procesadora.avisar(UnidadProcesadora.eventos.hubo_cambio);
    }

    public void finalizarItem(ItemServicio item) throws RestaurantException {
        if(item == null) throw new RestaurantException("No se selecciono item");
        if(!itemsProcesando.contains(item)) throw new RestaurantException("No se encuentra item en lista de pedidos tomados.");
        item.finalizar();
        itemsProcesando.remove(item);
    }
}
