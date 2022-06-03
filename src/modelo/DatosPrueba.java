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
    
    public static void cargar() {
        
        Fachada logica = Fachada.getInstancia();
        
        //    ---------------------  CLIENTE  ---------------------
        TipoCliente tipoClientePreferencial = new ClientePreferencial();
        TipoCliente tipoClienteCasa = new ClienteCasa();
        TipoCliente tipoClienteComun = new ClientePreferencial();
        
        Cliente clientePreferencial = new Cliente(1, "Pedrito", "pedrito@gmail.com", tipoClientePreferencial );
        Cliente clienteCasa = new Cliente(1, "Claudia", "clau@gmail.com", tipoClienteCasa );
        Cliente clienteComun = new Cliente(1, "Egidio", "Egidio@gmail.com", tipoClienteComun );
        
        //    ---------------------  MESA  ---------------------
        Mesa mesa1 = new Mesa(1);
        Mesa mesa2 = new Mesa(2);
        Mesa mesa3 = new Mesa(3);
        Mesa mesa4 = new Mesa(4);
        
        //    ---------------------  UNIDAD PROCESADORA  ---------------------
        UnidadProcesadora cocina = null;
        UnidadProcesadora barra = null;
        UnidadProcesadora sushibar = null;
        
        try {
            cocina = logica.crearUnidadProcesadora("COCINA");
            barra = logica.crearUnidadProcesadora("BARRA");
            sushibar = logica.crearUnidadProcesadora("sushibar");
        } catch (UnidadProcesadoraException ex) {
            System.out.println("No se cargaron unidades procesadoras");
        }        
        
        Producto producto1 = new Producto("1A", "milanesa con fritas", 180, 10, cocina);
        Producto producto2 = new Producto("2A", "gin tonic", 250, 20, barra);
        Producto producto3 = new Producto("3A", "Chivito al plato", 250, 20, cocina);
        Producto producto4 = new Producto("4A", "Rolls palta y salmón", 175, 300, sushibar);
             
        Mozo mozo1 = logica.crearUsuarioMozo("099250364", "Emanuel", "emanuel123", "Emanuel Coitiño");
        Mozo mozo2 = logica.crearUsuarioMozo("098869788", "Fausto", "fausto123", "Fausto Perillo");        
        
//--------------------- ASIGNO MESA A MOZO ---------------------
        mozo1.agregarMesa(mesa1);
        mozo1.agregarMesa(mesa2);
        mozo1.agregarMesa(mesa3);
        mozo2.agregarMesa(mesa4);
        
//--------------------- AGREGO ITEM A UN SERVICIO DE UNA MESA ---------------------
        mesa1.getServicio().agregarItemServicio(producto1, 1, "Milanesa a punto");
        mesa1.getServicio().agregarItemServicio(producto1, 2, "Puré de calabaza");
        mesa2.getServicio().agregarItemServicio(producto2, 1, "Sin hielo");
        mesa2.getServicio().agregarItemServicio(producto4, 12, "Con salsa de soja");
        
//--------------------- AGREGO CLIENTE A UN SERVICIO DE UNA MESA ---------------------        
        mesa1.getServicio().asignarCliente(clientePreferencial);
        mesa2.getServicio().asignarCliente(clienteCasa);
        mesa3.getServicio().asignarCliente(clienteComun);



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
