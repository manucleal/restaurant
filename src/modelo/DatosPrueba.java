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
        
        Mesa mesa1 = new Mesa(1);
        Mesa mesa2 = new Mesa(2);
        Mesa mesa3 = new Mesa(3);
        Mesa mesa4 = new Mesa(4);
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
             
        Mozo mozo1 = logica.crearUsuarioMozo("099250364", "Emanuel", "emanuel123", "Emanuel Coitiño");
        Mozo mozo2 = logica.crearUsuarioMozo("098869788", "Fausto", "fausto123", "Fausto Perillo");        
        
        //agregando mesa a mozo
        mozo1.agregarMesa(mesa1);
        mozo1.agregarMesa(mesa2);
        mozo1.agregarMesa(mesa3);
        mozo2.agregarMesa(mesa4);
        //agregando item a un servicio de una mesa
        mesa1.getServicio().agregarItemServicio(producto1, 1, "que papa la vida");
        mesa1.getServicio().agregarItemServicio(producto1, 2, "se pidio despues");
        mesa2.getServicio().agregarItemServicio(producto2, 1, "vamo arriba");
        
        
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
