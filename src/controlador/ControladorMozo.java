/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Conexion;
import modelo.Mozo;
import vistaEscritorio.VistaMozo;

/**
 *
 * @author ecoitino
 */
public class ControladorMozo {

    private VistaMozo vistaMozo;
    private Conexion conexion;
    private Mozo mozo;

    public ControladorMozo(VistaMozo vista, Conexion conexion) {
        this.vistaMozo = vista;
        this.conexion = conexion;
        this.mozo = (Mozo) conexion.getUsuario();
        inicializarVista();
    }

    private void inicializarVista() {
        vistaMozo.setLocationRelativeTo(null);
        vistaMozo.mostrarNombreUsuario(conexion.getUsuario().getNombreCompleto());
        vistaMozo.mostrarMesas(mozo.getMesas());
    }

}
