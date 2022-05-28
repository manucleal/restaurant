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
    
}
