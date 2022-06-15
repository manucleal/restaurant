/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ecoitino
 */
public class DatosPrueba {
    
    public static void cargar() throws RestaurantException {
        
        Fachada fachada = Fachada.getInstancia();

//    --------------------- ALTA MESA  ---------------------
        Mesa mesa1 = new Mesa(1,true);
        Mesa mesa2 = new Mesa(2,true);
        Mesa mesa3 = new Mesa(3,false);
        Mesa mesa4 = new Mesa(4,false);
        Mesa mesa5 = new Mesa(5,false);
        Mesa mesa6 = new Mesa(6,false);
        Mesa mesa7 = new Mesa(7,false);
        Mesa mesa8 = new Mesa(8,false);
        Mesa mesa9 = new Mesa(9,false);
        
//    --------------------- ALTA UNIDAD PROCESADORA  ---------------------
        UnidadProcesadora cocina = null;
        UnidadProcesadora barra = null;
        UnidadProcesadora sushibar = null;
        
        try {
            cocina = fachada.crearUnidadProcesadora("COCINA");
            barra = fachada.crearUnidadProcesadora("BARRA");
            sushibar = fachada.crearUnidadProcesadora("sushibar");
        } catch (RestaurantException ex) {
            System.out.println("No se cargaron unidades procesadoras");
        }        
        
// --------------------- ALTA PRODUCTO ---------------------
        Producto producto1 = new Producto("1A", "Milanesa con fritas", 180, 10, cocina);
        Producto producto2 = new Producto("2A", "Gin tonic", 250, 20, barra);
        Producto producto3 = new Producto("3A", "Chivito al plato", 250, 20, cocina);
        Producto producto4 = new Producto("4A", "Roll palta y salmón", 80, 300, sushibar);
        Producto producto7 = new Producto("6A", "Tabla nigiris", 1200, 45, sushibar);
        Producto producto5 = new Producto("3B", "Café", 75, 100, barra);
        Producto producto6 = new Producto("5A", "Agua", 50, 200, barra);
                
//    --------------------- ALTA TIPO CLIENTE  ---------------------
        TipoCliente tipoClientePreferencial = new ClientePreferencial();
        TipoCliente tipoClienteCasa = new ClienteCasa();
        TipoCliente tipoClienteComun = new ClienteComun();
        
//    --------------------- ALTA CLIENTE  ---------------------
        Cliente clientePreferencial = new Cliente("Pedrito", "pedrito@gmail.com", tipoClientePreferencial );
        Cliente clienteCasa = new Cliente("Claudia", "clau@gmail.com", tipoClienteCasa );
        Cliente clienteComun = new Cliente("Egidio", "Egidio@gmail.com", tipoClienteComun );
        
        fachada.agregarCliente(clientePreferencial);
        fachada.agregarCliente(clienteCasa);
        fachada.agregarCliente(clienteComun);
        
//--------------------- ALTA MOZO ---------------------
             
        Mozo mozo1 = fachada.crearUsuarioMozo("099250364", "e", "123", "Emanuel Coitiño");
        Mozo mozo2 = fachada.crearUsuarioMozo("098869788", "f", "123", "Fausto Perillo");
        Mozo mozo3 = fachada.crearUsuarioMozo("098876654", "d", "123", "Diego Cubilla");
        Mozo mozo4 = fachada.crearUsuarioMozo("099189100", "p", "123", "Pablo Javier Bengoechea");
        
//--------------------- ASIGNO MESA A MOZO ---------------------
        mozo1.agregarMesa(mesa1);
        mozo1.agregarMesa(mesa2);
        mozo1.agregarMesa(mesa3);
        
        mozo2.agregarMesa(mesa4);
        
        mozo3.agregarMesa(mesa5);
        mozo3.agregarMesa(mesa6);
        mozo3.agregarMesa(mesa7);
        mozo3.agregarMesa(mesa8);
        mozo3.agregarMesa(mesa9);
        
// --------------------- AGREGO PRODUCTOS A SISTEMA ---------------------
        fachada.agregarProducto(producto1);
        fachada.agregarProducto(producto2);
        fachada.agregarProducto(producto3);
        fachada.agregarProducto(producto4);
        fachada.agregarProducto(producto5);
        fachada.agregarProducto(producto6);
//--------------------- AGREGO ITEM A UN SERVICIO DE UNA MESA ---------------------
        mesa1.getServicio().agregarItemServicio(producto1, "Milanesa a punto", "1");
        mesa1.getServicio().agregarItemServicio(producto1, "Puré de calabaza", "2" );
        
        mesa2.getServicio().agregarItemServicio(producto2, "Sin hielo", "1");
        mesa2.getServicio().agregarItemServicio(producto4, "Con salsa de soja", "12");
        
        mesa5.getServicio().agregarItemServicio(producto5, "Sin azúcar", "4");
        mesa5.getServicio().agregarItemServicio(producto7, "Con salsa teriyaki", "1");
        
    //<editor-fold desc="GESTION"> 
        try {
            fachada.crearUsuarioGestor("G1", "G1", "Gestor 1");
            fachada.crearUsuarioGestor("G2", "G2", "Gestor 2");
            fachada.crearUsuarioGestor("G3", "G3", "Gestor 3");

        } catch (RestaurantException ex) {
            System.out.println("Usuarios gestor no creados.");
        }
    //</editor-fold>
        
    }
}