package modelo;

import java.util.ArrayList;

public class Mozo extends Usuario {
    
    private String telefono;
    public static int cantidadMaxMesas = 5;
    private ArrayList<Mesa> mesas = new ArrayList();    
    private Transferencia transferencia;
    private ItemServicio itemFinalizado;

    public enum eventos { mesaCerrada };

    public Mozo(String telefono, String nombreUsuario, String contrasena, String nombreCompleto) {
        super(nombreUsuario,contrasena,nombreCompleto);
        this.telefono = telefono;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    
    public ItemServicio getItemFinalizado() {
        return itemFinalizado;
    }

    public void setItemFinalizado(ItemServicio itemFinalizado) {
        this.itemFinalizado = itemFinalizado;
    }        
    
    public static int getCantidadMaxMesas() {
        return cantidadMaxMesas;
    }
    
    public boolean validarCantidadMesasMozo() {
        return mesas.size() < cantidadMaxMesas;
    }

    public Transferencia getTransferenciaRecibida() {
        return transferencia;
    }      

    public void setTransferencia(Transferencia transferenciaRecibida) {
        this.transferencia = transferenciaRecibida;
    }      
    
    public boolean agregarMesa(Mesa mesa) {
        if(validarCantidadMesasMozo()) {
            mesas.add(mesa);
            mesa.setMozo(this);
            return true;
        }
        return false;
    }
    
    public void reasingnarMesa(Transferencia transferencia) {
        Mozo mozoOrigen = transferencia.getMozoOrigen();
        Mesa mesaTransferencia = transferencia.getMesa();
        mesaTransferencia.setMozo(mozoOrigen);
        Mozo mozoDestino = transferencia.getMozoDestino();        
        mozoDestino.agregarMesa(mesaTransferencia);
        mozoOrigen.getMesas().remove(mesaTransferencia);
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
        Transferencia transferenciaRealizada = new Transferencia(this, mozoDestino, mesa);
        if(transferenciaRealizada.validar()) {
            setTransferencia(transferenciaRealizada);
            mozoDestino.setTransferencia(transferenciaRealizada);          
            mozoDestino.avisar(Transferencia.eventos.nuevaTranferencia);
        }
    }

}
