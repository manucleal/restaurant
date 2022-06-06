package modelo;

public class ClienteComun extends TipoCliente {

    public ClienteComun() {
        super("Cliente comun", "Café invitación");
    }

    //Pagan $0 por todos los cafés consumidos en el servicio.
    @Override
    public float obtenerMontoBeneficio() {
        Servicio servicio = cliente.getServicio();
        return servicio.getTotalPorProducto("Cafe");
    }

    


    
}
