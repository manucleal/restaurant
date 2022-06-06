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
    private SistemaPedidos sistemaPedidos = new SistemaPedidos();
    private SistemaClientes sistemaClientes = new SistemaClientes();

    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
    }

    public ArrayList<UnidadProcesadora> getProcesadoras() {
        return sistemaPedidos.getProcesadoras();
    }

    public UnidadProcesadora crearUnidadProcesadora(String nombre) throws RestaurantException {
        return sistemaPedidos.crearUnidadProcesadora(nombre);
    }

    public UnidadProcesadora buscarConExceptionProcesadora(String nombre) throws RestaurantException {
        return sistemaPedidos.buscarConExceptionProcesadora(nombre);
    }
    
    public ArrayList<Producto> obtenerProductosConStock() {
        return sistemaPedidos.obtenerProductosConStock();
    }
    
    public void agregarProducto(Producto producto) {
        sistemaPedidos.agregarProducto(producto);
    }

    public Conexion loginMozo(String nombreUsuario, String password) throws RestaurantException {
        return sistemaUsuarios.loginMozo(nombreUsuario, password);
    }

    public Conexion loginGestor(String nombreUsuario, String password) throws RestaurantException {
        return sistemaUsuarios.loginGestor(nombreUsuario, password);
    }

    public void logoutConexion(Conexion conexion) throws RestaurantException {
        sistemaUsuarios.logoutConexion(conexion);
    }

    public Mozo crearUsuarioMozo(String telefono, String nombreUsuario, String contrasena, String nombreCompleto) throws RestaurantException {
        return sistemaUsuarios.crearUsuarioMozo(telefono, nombreUsuario, contrasena, nombreCompleto);
    }

    public Gestor crearUsuarioGestor(String nombreUsuario, String contrasena, String nombreCompleto) throws RestaurantException {
        return sistemaUsuarios.crearUsuarioGestor(nombreUsuario, contrasena, nombreCompleto);
    }
    
    public void agregarCliente(Cliente cliente) {
        sistemaClientes.agregar(cliente);
    }
    
    public Cliente buscarCliente(String idCliente) throws RestaurantException {
        return sistemaClientes.buscarCliente(idCliente);
    }         
    
    public ArrayList<Mozo> obtenerMozosLogueadosConMenosDeCincoMesas() {
        return sistemaUsuarios.obtenerMozosLogueadosConMenosDeCincoMesas();
    }
}
