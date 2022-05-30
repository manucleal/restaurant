package modelo;

public class ItemServicio {
    
    private Producto producto;
    private int cantidad;
    private String descripcion;

    public ItemServicio(Producto producto, int cantidad, String descripcion) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
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
    
    public float getSubTotal() {
        return cantidad * producto.getPrecio();
    }
}
