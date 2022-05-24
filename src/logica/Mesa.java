/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author ecoitino
 */
public class Mesa {
    
    private int numero;
    //private Mozo mozo;
    private Servicio servicio = new Servicio();

    public Mesa(int numero, Mozo mozo) {
        this.numero = numero;
        //this.mozo = mozo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
}
