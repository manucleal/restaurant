/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import exceptions.RestaurantException;
import exceptions.UsuarioException;

/**
 *
 * @author ecoitino
 */
public class DatosPrueba {
    
    public static void cargar() throws RestaurantException {
        
        Fachada logica = Fachada.getInstancia();
        
//    --------------------- ALTA TIPO CLIENTE  ---------------------
        TipoCliente tipoClientePreferencial = new ClientePreferencial();
        TipoCliente tipoClienteCasa = new ClienteCasa();
        TipoCliente tipoClienteComun = new ClienteComun();
        
//    --------------------- ALTA CLIENTE  ---------------------
        Cliente clientePreferencial = new Cliente("Pedrito", "pedrito@gmail.com", tipoClientePreferencial );
        Cliente clienteCasa = new Cliente("Claudia", "clau@gmail.com", tipoClienteCasa );
        Cliente clienteComun = new Cliente("Egidio", "Egidio@gmail.com", tipoClienteComun );
        
        logica.agregarCliente(clientePreferencial);
        logica.agregarCliente(clienteCasa);
        logica.agregarCliente(clienteComun);
        
//    --------------------- ALTA MESA  ---------------------
        Mesa mesa1 = new Mesa(1,true);
        Mesa mesa2 = new Mesa(2,true);
        Mesa mesa3 = new Mesa(3,false);
        Mesa mesa4 = new Mesa(4,false);
        
//    --------------------- ALTA UNIDAD PROCESADORA  ---------------------
        UnidadProcesadora cocina = null;
        UnidadProcesadora barra = null;
        UnidadProcesadora sushibar = null;
        
        try {
            cocina = logica.crearUnidadProcesadora("COCINA");
            barra = logica.crearUnidadProcesadora("BARRA");
            sushibar = logica.crearUnidadProcesadora("sushibar");
        } catch (RestaurantException ex) {
            System.out.println("No se cargaron unidades procesadoras");
        }        
        
// --------------------- ALTA PRODUCTO ---------------------
        Producto producto1 = new Producto("1A", "milanesa con fritas", 180, 10, cocina);
        Producto producto2 = new Producto("2A", "gin tonic", 250, 20, barra);
        Producto producto3 = new Producto("3A", "Chivito al plato", 250, 20, cocina);
        Producto producto4 = new Producto("4A", "Roll palta y salmón", 80, 300, sushibar);
        
//--------------------- ALTA MOZO ---------------------
             
        Mozo mozo1 = logica.crearUsuarioMozo("099250364", "Emanuel", "emanuel123", "Emanuel Coitiño");
        Mozo mozo2 = logica.crearUsuarioMozo("098869788", "Fausto", "fausto123", "Fausto Perillo");        
        
//--------------------- ASIGNO MESA A MOZO ---------------------
        mozo1.agregarMesa(mesa1);
        mozo1.agregarMesa(mesa2);
        mozo1.agregarMesa(mesa3);
        mozo2.agregarMesa(mesa4);
        
// --------------------- AGREGO PRODUCTOS A SISTEMA ---------------------
        logica.agregarProducto(producto1);
        logica.agregarProducto(producto2);
        logica.agregarProducto(producto3);
        logica.agregarProducto(producto4);
//--------------------- AGREGO ITEM A UN SERVICIO DE UNA MESA ---------------------
        mesa1.getServicio().agregarItemServicio(producto1, "Milanesa a punto", "1");
        mesa1.getServicio().agregarItemServicio(producto1, "Puré de calabaza", "2" );
        mesa2.getServicio().agregarItemServicio(producto2, "Sin hielo", "1");
        mesa2.getServicio().agregarItemServicio(producto4, "Con salsa de soja", "12");
        
//--------------------- AGREGO CLIENTE A UN SERVICIO DE UNA MESA ---------------------        
//        mesa1.getServicio().asignarCliente(clientePreferencial);
//        mesa2.getServicio().asignarCliente(clienteCasa);
//        mesa3.getServicio().asignarCliente(clienteComun);
//        mesa4.getServicio().asignarCliente(clientePreferencial);



        // GESTION
        //<editor-fold>
        try {
            logica.crearUsuarioGestor("G1", "G1", "Gestor 1");
            logica.crearUsuarioGestor("G2", "G2", "Gestor 2");
            logica.crearUsuarioGestor("G3", "G3", "Gestor 3");

        } catch (UsuarioException ex) {
            System.out.println("Usuarios gestor no creados.");
        }
        //</editor-fold>
        
    }
}
