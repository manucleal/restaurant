/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import modelo.Conexion;
import modelo.Mesa;
import modelo.Mozo;
import vistaEscritorio.VistaMozo;

/**
 *
 * @author ecoitino
 */
public class ControladorMozo {

    private VistaMozo vistaMozo;
    private Conexion conexion;
    private Mozo modelo;
    private Mesa mesaSeleccionada;

    public ControladorMozo(VistaMozo vista, Conexion conexion) {
        this.vistaMozo = vista;
        this.conexion = conexion;
        this.modelo = (Mozo) conexion.getUsuario();
        inicializarVista();
    }

    private void inicializarVista() {
        vistaMozo.setLocationRelativeTo(null);
        vistaMozo.mostrarNombreUsuario(conexion.getUsuario().getNombreCompleto());
        vistaMozo.mostrarMesas(modelo.getMesas());        
    }
    
    public void buscarMesa(ActionEvent e, javax.swing.JPanel panel) {
        Component[] botonesPanel = panel.getComponents();
            
        for(Component component : botonesPanel) {
            JButton botonPresionado = (JButton)e.getSource();
            JButton botonPanel = (JButton)component;
            String nombreBotonPresionado = botonPresionado.getActionCommand();
            if (nombreBotonPresionado.equals(botonPanel.getActionCommand())) {
                this.mesaSeleccionada = modelo.bucarMesaPorNumero(eliminarNoDigitos(e.getActionCommand()));
                vistaMozo.mostrarLabelMesa(nombreBotonPresionado);
                vistaMozo.mostrarDatosServicio(this.mesaSeleccionada.getServicio().getItemsServicio());
            }
        }       
    }
    
    private int eliminarNoDigitos(String str) {
        String aux = str.replaceAll("\\D+","");
        return Integer.parseInt(aux);
    }
}
