package modelo;

import controlador.ControladorMozo;

public class Mesa {
    
    private int numero;
    private Mozo mozo;
    private Servicio servicio = new Servicio();
    private boolean estaAbierta;
    private Transferencia transferencia;


    public Mesa(int numero, boolean estaAbierta) {
        this.numero = numero;
        this.estaAbierta = estaAbierta;
        this.servicio.setMesa(this);
    }

    public int getNumero() {
        return numero;
    }        

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void setEstaAbierta(boolean abierta) {
        this.estaAbierta = abierta;
    }

    public Mozo getMozo() {
        return mozo;
    }

    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }
    

    public Servicio getServicio() {
        return servicio;
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public boolean estaAbierta() {
        return estaAbierta;
    }
        
    public String abrirMesa() throws RestaurantException{
        if(!estaAbierta()){
            setEstaAbierta(true);
            return "Mesa abierta con éxito";
        } else {
            throw new RestaurantException("La mesa ya está abierta");
        }
    }
    
    public boolean estaCerrada(String msg) throws RestaurantException{
        if(!estaAbierta()) throw new RestaurantException(msg);
        return false;
    }
    
    public boolean tienePedidosPendientes() throws RestaurantException{
        if(!sinPedidosPendientes()) throw new RestaurantException("No se puede cerrar la mesa, tiene pedidos pendientes");
        return false;
    }

    public boolean mesaTieneCliente(){
        return this.servicio.tieneCliente();
    }

    public void cerrarMesa() {
        servicio.asignarCliente(null);
        servicio = new Servicio();
        servicio.setMesa(this);
        estaAbierta = false;
        mozo.avisar(Mozo.eventos.mesaCerrada);
    }
    
    private boolean sinPedidosPendientes(){
        return this.servicio.verificarPedidosFinalizados();
    }

//    public void agregarOservadorItemsServicio(ControladorMozo controlador) {
//        servicio.agregarOservadorItemsServicio(controlador);
//    }
}
