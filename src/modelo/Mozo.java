package modelo;

import java.util.ArrayList;

public class Mozo extends Usuario {
    
    private String telefono;
    public static int cantidadMaxMesas = 5;
    private ArrayList<Mesa> mesas = new ArrayList();    
    private Transferencia transferenciaRecibida;
    private Transferencia transferenciaHecha;   
    
    public enum eventos { mesaCerrada };

    public Mozo(String telefono, String nombreUsuario, String contrasena, String nombreCompleto) {
        super(nombreUsuario,contrasena,nombreCompleto);
        this.telefono = telefono;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    
    public static int getCantidadMaxMesas() {
        return cantidadMaxMesas;
    }
    
    public boolean validarCantidadMesasMozo() {
        return mesas.size() < cantidadMaxMesas;
    }

    public Transferencia getTransferenciaRecibida() {
        return transferenciaRecibida;
    }

    public Transferencia getTransferenciaHecha() {
        return transferenciaHecha;
    }        

    public void setTransferenciaRecibida(Transferencia transferenciaRecibida) {
        this.transferenciaRecibida = transferenciaRecibida;
    }

    public void setTransferenciaHecha(Transferencia transferenciaHecha) {
        this.transferenciaHecha = transferenciaHecha;
    }        
    
    public boolean agregarMesa(Mesa mesa) {
        if(validarCantidadMesasMozo()) {
            mesas.add(mesa);
            mesa.setMozo(this);
            return true;
        }
        return false;
    }
    
    public Mesa bucarMesaPorNumero(int numero) {
        for(Mesa mesa : mesas) {
            if(mesa.getNumero() == numero) {
                return mesa;           
            }
        }
        return null;
    }
    
    public void realizarTransferencia(Mozo mozoDestino, Mesa mesa) throws RestaurantException {
        Transferencia transferencia = new Transferencia(this, mozoDestino, mesa);
        if(transferencia.validar()) {
            setTransferenciaHecha(transferencia);
            mozoDestino.setTransferenciaRecibida(transferencia);          
            mozoDestino.avisar(Transferencia.eventos.nuevaTranferencia);
        }
    }        
    
}
