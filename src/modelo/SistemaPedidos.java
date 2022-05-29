package modelo;

import java.util.ArrayList;

public class SistemaPedidos {
    
    ArrayList<UnidadProcesadora> procesadoras = new ArrayList();
    ArrayList<Servicio> servicios = new ArrayList();

    protected SistemaPedidos() {}        
    
    public ArrayList<UnidadProcesadora> getProcesadoras() {
        return procesadoras;        
    }
    
    public UnidadProcesadora crearUnidadProcesadora(String nombre)throws UnidadProcesadoraException{
        if(nombre.isBlank())throw new UnidadProcesadoraException("El nombre de la unidad vacía");
        if(buscarProcesadora(nombre) != null) throw new UnidadProcesadoraException("La unidad procesadora ya existe");
        UnidadProcesadora unidad = new UnidadProcesadora(nombre);
        procesadoras.add(unidad);
        return unidad;
    }
    
    public UnidadProcesadora buscarConExceptionProcesadora(String nombre)throws UnidadProcesadoraException{
        UnidadProcesadora unidad = buscarProcesadora(nombre);
        if(unidad == null)throw new UnidadProcesadoraException("No se encontró unidad");
        return unidad;
    }
    
    private UnidadProcesadora buscarProcesadora(String nombre){
        for (UnidadProcesadora procesadora : procesadoras) {
            if(procesadora.getNombre().equals(nombre.toUpperCase())){
                return procesadora;
            }
        }
        return null;
    }
}
