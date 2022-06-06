/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Fachada;
import modelo.Mozo;
import vistaEscritorio.VistaTransferencia;

/**
 *
 * @author ecoitino
 */
public class ControladorTransferencia {
    
    private VistaTransferencia vistaTransferencia;    
    private Mozo modelo;

    public ControladorTransferencia(VistaTransferencia vistaTransferencia, Mozo modelo) {
        this.vistaTransferencia = vistaTransferencia;
        this.modelo = modelo;
        inicializarVista();
    }
    
    private void inicializarVista() {
        vistaTransferencia.setLocationRelativeTo(null);
        vistaTransferencia.mostrarMozos(obtenerListaConOtrosMozos());    
    }
    
    private ArrayList<Mozo> obtenerListaConOtrosMozos() {
        ArrayList<Mozo> mozos = Fachada.getInstancia().obtenerMozosLogueadosConMenosDeCincoMesas();
        mozos.remove(modelo);
        return mozos;
    }
    
}
