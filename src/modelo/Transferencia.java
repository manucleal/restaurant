package modelo;

public class Transferencia {
    
    private Mozo mozoOrigen;
    private Mozo mozoDestino;
    private Mesa mesa;
    
    public enum eventos {nuevaTranferencia};

    public Transferencia(Mozo mozoOrigen, Mozo mozoDestino, Mesa mesa) {
        this.mozoOrigen = mozoOrigen;
        this.mozoDestino = mozoDestino;
        this.mesa = mesa;     
    }
    
    public boolean validar() throws RestaurantException {
        if(mozoOrigen.equals(mozoDestino)) throw new RestaurantException("Mozo destino y mozo origen no pueden ser iguales.");
        return true;
    }

}
