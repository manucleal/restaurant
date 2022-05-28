package modelo;

import java.util.ArrayList;
import logica.Usuario;

public class Mozo extends Usuario {
    
    private String telefono;
    private ArrayList<Mesa> mesas = new ArrayList();
    private ArrayList<Transferencia> transferencias = new ArrayList();

    public Mozo(String telefono, String nombreUsuario, String contrasena, String nombreCompleto) {
        super(nombreUsuario,contrasena,nombreCompleto);
        this.telefono = telefono;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    
    private boolean validar() {
        return mesas.size() < 5;
    }
    
    public boolean agregarMesa(Mesa mesa) {
        if(validar()) {
            return mesas.add(mesa);
        }
        return false;
    }
    
}
