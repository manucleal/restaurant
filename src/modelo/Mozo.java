package modelo;

import java.util.ArrayList;

public class Mozo extends Usuario {
    
    private String telefono;
    public static int cantidadMaxMesas = 5;
    private ArrayList<Mesa> mesas = new ArrayList();
    private ArrayList<Transferencia> transferencias = new ArrayList();

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
    
    private boolean validar() {
        return mesas.size() < cantidadMaxMesas;
    }
    
    public boolean agregarMesa(Mesa mesa) {
        if(validar()) {
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
    
}
