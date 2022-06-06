package modelo;

public class ClienteCasa extends TipoCliente {

    public ClienteCasa() {
        super("ClienteCasa", "$500 invitación");
    }

    
//  Tienen $500 de consumo gratis por servicio.
    @Override
    public float obtenerMontoBeneficio() {
        
        Servicio servicio = cliente.getServicio();
        float totalServicio = servicio.obtenerMontoTotalServicio();
        if(totalServicio > 500){
            return 500;
        }
        return totalServicio;
    }
    
}
