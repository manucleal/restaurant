package modelo;

public class ClienteComun extends TipoCliente {

    public ClienteComun() {
        super("Cliente comun");
    }

    //Pagan $0 por todos los cafés consumidos en el servicio.
    @Override
    public void obtenerMontoBeneficio(Servicio servicio) {
        servicio.setBeneficioAplicado("Café invitación");
        servicio.setMontoDescuento(servicio.getTotalPorProducto("3B"));
    }

}
