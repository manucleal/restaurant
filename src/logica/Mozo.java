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
public class Mozo extends Usuario {
    
    private String telefono;
    private ArrayList<Mesa> mesas = new ArrayList();

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
