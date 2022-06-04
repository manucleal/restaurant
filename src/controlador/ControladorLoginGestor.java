/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Fachada;
import exceptions.RestaurantException;
import modelo.UnidadProcesadora;
import vistaEscritorio.VistaLoginGestor;

/**
 *
 * @author ecoitino
 */
public class ControladorLoginGestor extends ControladorLogin {
    
    public ControladorLoginGestor(VistaLoginGestor vistaGestor) {
        super(vistaGestor);
    }
    
    @Override
    public Object llamarLogin(String nombreUsuario, String password) throws RestaurantException {
        return Fachada.getInstancia().loginGestor(nombreUsuario, password, new UnidadProcesadora("TEST"));
    }
    
}
