/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Cliente;
import modelo.Fachada;
import modelo.Servicio;
import vistaEscritorio.VistaCerrarMesaCliente;

/**
 *
 * @author faustoperillo
 */
public class ControladorCerrarMesa {
    
    private VistaCerrarMesaCliente vistaCerrarMesaCliente;
    private Servicio modelo;
    private Fachada fachada = Fachada.getInstancia();

    public ControladorCerrarMesa(VistaCerrarMesaCliente vistaCerrarMesaCliente, Servicio modelo) {
        this.vistaCerrarMesaCliente = vistaCerrarMesaCliente;
        this.modelo = modelo;
    }

    public void buscarCliente(String idIngresado) {
        Cliente cliente = fachada.buscarCliente(idIngresado);
        if(cliente != null){
            vistaCerrarMesaCliente.cargarNombreCliente(cliente.getNombre());
            modelo.asignarCliente(cliente);
            vistaCerrarMesaCliente.cargarDatosServicioCliente(modelo, cliente);
        }else{
            //no existe cliente ingresado fin C/U
        }
    }
    
    
}
