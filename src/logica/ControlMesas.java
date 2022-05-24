/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author ecoitino
 */
public class ControlMesas {
    
    private ArrayList<Mesa> mesas = new ArrayList();
    private int numeroMesa;    
   
    protected ControlMesas() {}
    
    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    
    public void agregarMesa(Mesa mesa) {
        mesa.setNumero(generarProximoNumero());
        mesas.add(mesa);
    }
    
    private int generarProximoNumero(){
        numeroMesa++;
        return numeroMesa;
    }
}
