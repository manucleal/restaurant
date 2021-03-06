package modelo;

public class Producto {
    
    private String codigo;
    private String nombre;
    private float precio;
    private int cantidadDisponible;
    private UnidadProcesadora unidadProcesadora;

    public Producto(String codigo, String nombre, float precio, int cantidadDisponible, UnidadProcesadora unidadProcesadora) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.unidadProcesadora = unidadProcesadora;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }
    
    public boolean tieneStock() {    
        return cantidadDisponible > 0;
    }
    
    public void bajarStock(int cantidad) {
        cantidadDisponible = cantidadDisponible - cantidad;
    }
    
    @Override
    public String toString() {
        return  "("+codigo+") " + nombre;
    }
    
}
