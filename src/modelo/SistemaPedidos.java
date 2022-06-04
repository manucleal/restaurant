package modelo;

import Exceptions.RestaurantException;
import java.util.ArrayList;

public class SistemaPedidos {
    
    ArrayList<UnidadProcesadora> procesadoras = new ArrayList();
    ArrayList<Servicio> servicios = new ArrayList();
    ArrayList<Producto> productos = new ArrayList();

    protected SistemaPedidos() {}        
    
    public ArrayList<UnidadProcesadora> getProcesadoras() {
        return procesadoras;        
    }
    
    public UnidadProcesadora crearUnidadProcesadora(String nombre) throws RestaurantException{
        if(nombre.isBlank())throw new RestaurantException("El nombre de la unidad vacía");
        if(buscarProcesadora(nombre) != null) throw new RestaurantException("La unidad procesadora ya existe");
        UnidadProcesadora unidad = new UnidadProcesadora(nombre);
        procesadoras.add(unidad);
        return unidad;
    }
    
    public UnidadProcesadora buscarConExceptionProcesadora(String nombre) throws RestaurantException {
        UnidadProcesadora unidad = buscarProcesadora(nombre);
        if(unidad == null)throw new RestaurantException("No se encontró unidad");
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
    
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    
    public ArrayList<Producto> obtenerProductosConStock() {
        ArrayList<Producto> lista = new ArrayList<>();
        for(Producto producto : productos) {
            if(producto.tieneStock()) {
                lista.add(producto);
            }
        }
        return lista;
    }
}
