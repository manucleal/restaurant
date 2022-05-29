package modelo;

public class Mesa {
    
    private int numero;
    private Mozo mozo;
    private Servicio servicio;
    private Transferencia transferencia;

    public Mesa(int numero) {
        this.numero = numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    } 

    public int getNumero() {
        return numero;
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
    
    
}
