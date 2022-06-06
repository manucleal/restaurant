package modelo;

public class ClientePreferencial extends TipoCliente {

    public ClientePreferencial() {
        super("ClientePreferencial", "Agua gratis + 5% según consumo");
    }

    
//    Pagan $0 por todas las aguas minerales consumidas en el servicio y si el 
//    monto total del servicio supera los $2000 tienen un 5% de descuento sobre el total.
    @Override
    public void obtenerBeneficio() {
        
    }
    
}
