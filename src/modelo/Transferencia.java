package modelo;

import static modelo.Transferencia.eventos.nuevaTranferencia;
import observador.Observable;

public class Transferencia  extends Observable {
    
    private Mozo mozoOrigen;
    private Mozo mozoDestino;
    private Mesa mesa;
    
    public enum eventos {nuevaTranferencia};

    public Transferencia(Mozo mozoOrigen, Mozo mozoDestino, Mesa mesa) {
        this.mozoOrigen = mozoOrigen;
        this.mozoDestino = mozoDestino;
        this.mesa = mesa;
        avisar(nuevaTranferencia);        
    }
    
    public boolean validar() throws RestaurantException {
        if(mozoOrigen.equals(mozoDestino)) throw new RestaurantException("Mozo destino y mozo origen no pueden ser iguales.");
        return true;
    }

}
