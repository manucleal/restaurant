/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Cliente;

/**
 *
 * @author faustoperillo
 */
public interface VistaCerrarMesaInterface {
        
    public void buscarClienteIngresado();
    
    public void cargarNombreCliente(String nombre);
    
    public void cargarDatosServicioCliente(Cliente cliente);
}
