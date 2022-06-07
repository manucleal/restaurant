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
    private Servicio modelo;
    private Fachada fachada = Fachada.getInstancia();

    public ControladorCerrarMesa(VistaCerrarMesa vistaCerrarMesaCliente, Servicio modelo) {
        this.vistaCerrarMesa = vistaCerrarMesaCliente;
        this.modelo = modelo;
        this.vistaCerrarMesa.setLocationRelativeTo(null);
        this.vistaCerrarMesa.setTitle("Cerrar mesa");
    }

    public void buscarCliente(String idIngresado) {
        try {
            Cliente cliente = fachada.buscarCliente(idIngresado);
            modelo.asignarCliente(cliente);
            cliente.getTipoCliente().obtenerMontoBeneficio();
            vistaCerrarMesa.cargarNombreCliente(cliente.getNombre());
            vistaCerrarMesa.mostrarNombreBeneficio(modelo.getBeneficioAplicado());
            vistaCerrarMesa.cargarTotales(modelo);
        } catch (RestaurantException e) {
            vistaCerrarMesa.mostrarMensaje(e.getMessage());
            //no existe cliente ingresado fin C/U
        }
    }
    
    public void cerrarMesa() {
        modelo.getMesa().cerrarMesa();
        vistaCerrarMesa.dispose();
    }
    
}
