package modelo;

public class ClientePreferencial extends TipoCliente {

    private Producto producto;
    
    public ClientePreferencial(Producto producto) {
        super("ClientePreferencial");
        this.producto = producto;
    }

    //Pagan $0 por todas las aguas minerales consumidas en el servicio y si el 
    //monto total del servicio supera los $2000 tienen un 5% de descuento sobre el total.
    @Override
    public void obtenerMontoBeneficio(Servicio servicio) {

        String beneficioAplicado = "Agua gratis + 5% según consumo";        
        float totalBeneficioProducto = servicio.getTotalPorProducto(producto.getCodigo());

        float totalServicio = servicio.obtenerMontoTotalServicio();
        float totalBeneficio = 0;
        float totalSinProducto = totalServicio - totalBeneficioProducto;
        if(totalSinProducto > 2000) {
            double total = totalSinProducto * 0.05;
            totalBeneficio = (float)total;
        }
        servicio.setBeneficioAplicado(beneficioAplicado);
        servicio.setMontoDescuento(totalBeneficioProducto + totalBeneficio);        
    }
    
}
