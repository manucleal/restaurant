/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Fachada;
import modelo.Mesa;
import modelo.Mozo;
import modelo.RestaurantException;
import vistaEscritorio.VistaTransferencia;

/**
 *
 * @author ecoitino
 */
public class ControladorTransferencia {
    
    private VistaTransferencia vistaTransferencia;
    private Mesa modeloMesa;
    private ArrayList<Mozo> listaConOtrosMozos;

    public ControladorTransferencia(VistaTransferencia vistaTransferencia, Mesa modelo) {
        this.vistaTransferencia = vistaTransferencia;
        this.modeloMesa = modelo;
        inicializarVista();
    }

    private void setListaConOtrosMozos(ArrayList<Mozo> listaConOtrosMozos) {
        this.listaConOtrosMozos = listaConOtrosMozos;
    }    
    
    private void inicializarVista() {
        vistaTransferencia.setLocationRelativeTo(null);
        setListaConOtrosMozos(Fachada.getInstancia().obtenerMozosLogueadosConMenosDeCincoMesas(modeloMesa.getMozo()));
        vistaTransferencia.mostrarMozos(listaConOtrosMozos);
    }   

    public void iniciarTransferencia(int posicion) {
        try {
            if(posicion != -1) {
                Mozo mozoSeleccionado = (Mozo)listaConOtrosMozos.get(posicion);
                Mesa mesaATransferir = modeloMesa;
                Mozo mozoEmisorMesa = mesaATransferir.getMozo();
                
                mozoEmisorMesa.realizarTransferencia(mozoSeleccionado, modeloMesa);
            }
        } catch (RestaurantException e) {
            vistaTransferencia.mostrarMensaje(e.getMessage());
        }
    }
    
}
