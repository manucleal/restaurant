package modelo;

public class ItemServicio{
    
    private UnidadProcesadora procesadora;
    private Producto producto;
    private int cantidad;
    private String descripcion;
    private Servicio servicio;
    private Gestor gestor;
    private estados estado;
            
    public enum estados{enEspera,procesando,finalizado};

    public ItemServicio(Producto producto, int cantidad, String descripcion, Servicio servicio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.procesadora = producto.getUnidadProcesadora();
        this.servicio = servicio;
        this.estado = estados.enEspera;
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

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
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
    
    public void agregarGestor (Gestor gestor)throws RestaurantException{
        if( this.gestor != null) throw new RestaurantException("El item ya tiene un gestor asignado");
        if(estado != estados.enEspera) throw new RestaurantException("El item no se encuentra disponible para ser tomado");
        this.gestor = gestor;
        this.estado = estados.procesando;
        procesadora.itemTomado(this);
    }
    
    public boolean pedidoFinalizado(){
        return this.estado.equals(estados.finalizado);
    }
 
    
    public void finalizado() {
        estado = estados.finalizado;
    }
}
