/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Fachada;
import Exceptions.RestaurantException;
import vistaEscritorio.VistaLoginMozo;


/**
 *
 * @author ecoitino
 */
public class ControladorLoginMozo extends ControladorLogin {
        
    public ControladorLoginMozo(VistaLoginMozo vistaMozo) {
        super(vistaMozo);
    }

    @Override
    public Object llamarLogin(String nombreUsuario, String password) throws RestaurantException {
        return Fachada.getInstancia().loginMozo(nombreUsuario, password);
    }

}
