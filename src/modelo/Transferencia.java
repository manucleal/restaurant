package modelo;

public class Transferencia {
    
    private Mozo mozoOrigen;
    private Mozo mozoDestino;
    private Mesa mesa;
    
    public enum eventos { nuevaTranferencia, transferenciaAceptada, transferenciaRechazada };
 
    public Transferencia(Mozo mozoOrigen, Mozo mozoDestino, Mesa mesa) {
        this.mozoOrigen = mozoOrigen;
        this.mozoDestino = mozoDestino;
        this.mesa = mesa;     
    }

    public Mozo getMozoOrigen() {
        return mozoOrigen;
    }

    public Mozo getMozoDestino() {
        return mozoDestino;
    }

    public Mesa getMesa() {
        return mesa;
    }        
    
    public boolean validar() throws RestaurantException {
        if(mozoOrigen.equals(mozoDestino)) throw new RestaurantException("Mozo destino y mozo origen no pueden ser iguales.");
        return true;
    }

}
