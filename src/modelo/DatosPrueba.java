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
        
//--------------------- ASIGNO MESA A MOZO ---------------------
        mozo1.agregarMesa(mesa1);
        mozo1.agregarMesa(mesa2);
        mozo1.agregarMesa(mesa3);
        mozo2.agregarMesa(mesa4);
        
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
