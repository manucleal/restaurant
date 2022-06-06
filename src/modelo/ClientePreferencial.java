package modelo;

public class ClientePreferencial extends TipoCliente {

    public ClientePreferencial() {
        super("ClientePreferencial", "Agua gratis + 5% según consumo");
    }

    
//    Pagan $0 por todas las aguas minerales consumidas en el servicio y si el 
//    monto total del servicio supera los $2000 tienen un 5% de descuento sobre el total.
    @Override
    public float obtenerMontoBeneficio() {
        
        Servicio servicio = cliente.getServicio();
        
        float totalBeneficioProducto = servicio.getTotalPorProducto("Agua");
        
        float totalServicio = servicio.montoTotal();
        float totalBeneficio = 0;
        float totalSinProducto = totalServicio - totalBeneficioProducto;
        if(totalSinProducto > 2000){
            double total = totalSinProducto * 0.05;
            totalBeneficio = (float)total;
        }
        return totalBeneficioProducto + totalBeneficio;
    }
    
    
}
