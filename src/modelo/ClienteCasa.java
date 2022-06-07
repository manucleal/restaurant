package modelo;

public class ClienteCasa extends TipoCliente {

    public ClienteCasa() {
        super("ClienteCasa");
    }
    
    //Tienen $500 de consumo gratis por servicio.
    @Override
    public void obtenerMontoBeneficio() {        
        Servicio servicio = cliente.getServicio();
        servicio.setBeneficioAplicado("$500 invitación");
        float totalServicio = servicio.obtenerMontoTotalServicio();
        if(totalServicio > 500) {
            servicio.setMontoDescuento(500);            
        } else {
            servicio.setMontoDescuento(totalServicio);
        }
    }
    
}
