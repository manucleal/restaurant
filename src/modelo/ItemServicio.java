package modelo;

import exceptions.RestaurantException;

public class ItemServicio {
    
    private UnidadProcesadora procesadora;
    private Producto producto;
    private int cantidad;
    private String descripcion;
    private Servicio servicio;

    public ItemServicio(Producto producto, int cantidad, String descripcion, Servicio servicio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.procesadora = producto.getUnidadProcesadora();
        this.servicio = servicio;
    }

    public UnidadProcesadora getProcesadora() {
        return procesadora;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Servicio getServicio() {
        return servicio;
    }      
    
    public float getSubTotal() {
        return cantidad * producto.getPrecio();
    }
    
    public boolean validar() throws RestaurantException {
        if (cantidad < 1) throw new RestaurantException("Cantidad inválida");
        int cantidadDisponible = producto.getCantidadDisponible();
        if (cantidad > cantidadDisponible) throw new RestaurantException("Sin stock, solo quedan (" + cantidadDisponible + ")");
        return true;
    }    
}
