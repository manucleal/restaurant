package modelo;

import java.util.Date;

public class Gestor extends Usuario {
    
    private Date fechaUltimoAcceso;
    private UnidadProcesadora procesadora;

    public Gestor(Date fechaUltimoAcceso, String nombreUsuario, String contrasena, String nombreCompleto) {
        super(nombreUsuario, contrasena, nombreCompleto);
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }

    public Date getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }
    
    public void agregarUltimaFechaConexion(Date fecha){
        this.fechaUltimoAcceso = fecha;
    }
    
    public void agregarProcesadora(UnidadProcesadora unidad) throws UnidadProcesadoraException{
        if(procesadora.equals(unidad))throw new UnidadProcesadoraException("La unidad -" + unidad.getNombre()+"- ya esta guardada en gestor");
        if(procesadora != null)throw new UnidadProcesadoraException("El gestor ya tiene otra unidad cargada");
        procesadora = unidad;
    }
    
    public void quitarProcesadora(){
        procesadora = null;
    }
    
}
