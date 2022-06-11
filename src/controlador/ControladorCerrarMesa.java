/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Cliente;
import modelo.Fachada;
import modelo.RestaurantException;
import modelo.Servicio;
import vistaEscritorio.VistaCerrarMesa;

/**
 *
 * @author faustoperillo
 */
public class ControladorCerrarMesa {
    
    private VistaCerrarMesa vistaCerrarMesa;
    private Servicio modeloServicio;
    private Fachada fachada = Fachada.getInstancia();

    public ControladorCerrarMesa(VistaCerrarMesa vistaCerrarMesaCliente, Servicio modelo) {
        this.vistaCerrarMesa = vistaCerrarMesaCliente;
        this.modeloServicio = modelo;
        this.vistaCerrarMesa.setLocationRelativeTo(null);
        this.vistaCerrarMesa.setTitle("Cerrar mesa");
        cargarTotalServicio();
    }

    public void buscarCliente(String idIngresado) {
        try {
            Cliente cliente = fachada.buscarCliente(idIngresado);
            modeloServicio.asignarCliente(cliente);
            vistaCerrarMesa.cargarNombreCliente(cliente.getNombre());
            vistaCerrarMesa.mostrarNombreBeneficio(modeloServicio.getBeneficioAplicado());
            
            cargarTotalServicio();
            vistaCerrarMesa.cargarTotalBeneficio(modeloServicio.getMontoDescuento());
        } catch (RestaurantException e) {
            vistaCerrarMesa.mostrarMensaje(e.getMessage());
            limpiarDatos();
        }
    }
    
    private void limpiarDatos(){
        modeloServicio.asignarCliente(null);
        modeloServicio.setMontoDescuento(0);
        vistaCerrarMesa.cargarNombreCliente("");
        vistaCerrarMesa.mostrarNombreBeneficio("");
        vistaCerrarMesa.cargarTotalBeneficio(0);
        vistaCerrarMesa.cargarTotalAPagar(modeloServicio.obtenerMontoTotalMenosBeneficio());
    }
    
    private void cargarTotalServicio(){
        vistaCerrarMesa.mostrarTotalServicio(modeloServicio.obtenerMontoTotalServicio());
        vistaCerrarMesa.cargarTotalAPagar(modeloServicio.obtenerMontoTotalMenosBeneficio());
    }
    
    public void cerrarMesa() {
        modeloServicio.getMesa().cerrarMesa();
        vistaCerrarMesa.dispose();
    }
    
}
