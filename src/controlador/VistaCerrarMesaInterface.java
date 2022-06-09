/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author faustoperillo
 */
public interface VistaCerrarMesaInterface {
        
    public void buscarClienteIngresado();
    
    public void cargarNombreCliente(String nombre);
    
    public void cargarTotalAPagar(float totalAPagar);
    
    public void cargarTotalBeneficio(float montoDescuento);
    
    public void mostrarNombreBeneficio(String nombre);
    
    public void mostrarMensaje(String msg);
    
    public void mostrarTotalServicio(float monto);
}
