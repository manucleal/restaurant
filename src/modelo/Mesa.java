package modelo;

public class Mesa {
    
    private int numero;
    private Mozo mozo;
    private Servicio servicio = new Servicio();
    private boolean estaAbierta;
    private Transferencia transferencia;

    public Mesa(int numero) {
        this.numero = numero;
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

    public Servicio getServicio() {
        return servicio;
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public boolean estaAbierta() {
        return estaAbierta;
    }
}
