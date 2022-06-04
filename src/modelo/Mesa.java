package modelo;

import exceptions.RestaurantException;

public class Mesa {
    
    private int numero;
    private Mozo mozo;
    private Servicio servicio = new Servicio();
    private boolean estaAbierta;
    private Transferencia transferencia;

    public Mesa(int numero, boolean estaAbierta) {
        this.numero = numero;
        this.estaAbierta = estaAbierta;
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

    public Mozo getMozo() {
        return mozo;
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
    
    public boolean mesaTieneCliente(){
        return this.servicio.tieneCliente();
    }
    
    public boolean agregarItemAServicio(Producto producto, String descripcion, String cantidad) throws RestaurantException {
        return servicio.agregarItemServicio(producto, descripcion, cantidad);
    }
}
