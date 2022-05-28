package modelo;

import modelo.Mesa;
import java.util.ArrayList;

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
