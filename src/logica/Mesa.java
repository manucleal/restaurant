package logica;

public class Mesa {
    
    private int numero;
    private Mozo mozo;
    private Servicio servicio;
    private Transferencia transferencia;

    public Mesa(int numero, Mozo mozo) {
        this.numero = numero;
        //this.mozo = mozo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
}
