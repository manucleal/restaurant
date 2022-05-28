package modelo;

import logica.Servicio;

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
}
