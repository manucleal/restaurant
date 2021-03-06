/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Fachada;
import modelo.Conexion;
import modelo.Gestor;
import modelo.RestaurantException;
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
        return Fachada.getInstancia().loginGestor(nombreUsuario, password);
    }

    public void agregarUnidadProcesadoraAGestor(UnidadProcesadora unidad, Conexion c) {
        try {
            Gestor gestor = (Gestor) c.getUsuario();
            gestor.agregarProcesadora(unidad);
        } catch (RestaurantException e) {
            vista.mostrarError(e.getMessage());
        }
    }

    public void mostrarUnidadesProcesadoras(Conexion conexion) {
        vista.mostrarElegirUnidadesProcesadoras(Fachada.getInstancia().getProcesadoras(), conexion);
    }

}
