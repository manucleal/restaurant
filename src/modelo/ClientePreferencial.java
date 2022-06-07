package modelo;

public class ClientePreferencial extends TipoCliente {

    public ClientePreferencial() {
        super("ClientePreferencial");
    }

    //Pagan $0 por todas las aguas minerales consumidas en el servicio y si el 
    //monto total del servicio supera los $2000 tienen un 5% de descuento sobre el total.
    @Override
    public void obtenerMontoBeneficio() {
        Servicio servicio = cliente.getServicio();
        String beneficioAplicado = "";
        
        float totalBeneficioProducto = servicio.getTotalPorProducto("5A");
        if(totalBeneficioProducto > 0) {
            beneficioAplicado += "Agua gratis";
        }
        float totalServicio = servicio.obtenerMontoTotalServicio();
        float totalBeneficio = 0;
        float totalSinProducto = totalServicio - totalBeneficioProducto;
        if(totalSinProducto > 2000) {
            beneficioAplicado = beneficioAplicado.length() > 0 ? " + " : "";
            beneficioAplicado += "5% según consumo";
            double total = totalSinProducto * 0.05;
            totalBeneficio = (float)total;
        }
        servicio.setBeneficioAplicado(beneficioAplicado);
        servicio.setMontoDescuento(totalBeneficioProducto + totalBeneficio);        
    }
    
}
