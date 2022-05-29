/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author ecoitino
 */
public class Fachada {

    private SistemaUsuarios sistemaUsuarios = new SistemaUsuarios();
    private SistemaPedidos sPedidos = new SistemaPedidos();

    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
    }

    public ArrayList<UnidadProcesadora> getProcesadoras() {
        return sPedidos.getProcesadoras();
    }

    public UnidadProcesadora crearUnidadProcesadora(String nombre) throws UnidadProcesadoraException {
        return sPedidos.crearUnidadProcesadora(nombre);
    }

    public UnidadProcesadora buscarConExceptionProcesadora(String nombre) throws UnidadProcesadoraException {
        return sPedidos.buscarConExceptionProcesadora(nombre);
    }

    public Conexion loginMozo(String nombreUsuario, String password)
            throws LoginException, UnidadProcesadoraException {
        return sistemaUsuarios.loginMozo(nombreUsuario, password);
    }

    public Conexion loginGestor(String nombreUsuario, String password, UnidadProcesadora unidad)
            throws LoginException, UnidadProcesadoraException {
        return sistemaUsuarios.loginGestor(nombreUsuario, password, unidad);
    }

    public void logoutConexionGestor(Conexion conexion) throws LoginException {
        sistemaUsuarios.logoutConexionGestor(conexion);
    }

    public Mozo crearUsuarioMozo(String telefono, String nombreUsuario, String contrasena, String nombreCompleto) {
        return sistemaUsuarios.crearUsuarioMozo(telefono, nombreUsuario, contrasena, nombreCompleto);
    }

    public Gestor crearUsuarioGestor(String nombreUsuario, String contrasena, String nombreCompleto) throws UsuarioException {
        return sistemaUsuarios.crearUsuarioGestor(nombreUsuario, contrasena, nombreCompleto);
    }

}
