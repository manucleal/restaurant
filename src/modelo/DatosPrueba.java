/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo.Fachada;
import modelo.Mesa;
import modelo.Mozo;
import utils.NombrePorcesadora;

/**
 *
 * @author ecoitino
 */
public class DatosPrueba {
    
    public static void cargar() {
        Mesa mesa1 = new Mesa(1);
        Mesa mesa2 = new Mesa(2);
        Mesa mesa3 = new Mesa(3);
        Mesa mesa4 = new Mesa(4);
        
        UnidadProcesadora cocina = new UnidadProcesadora(NombrePorcesadora.cocina.toString());        
        UnidadProcesadora bar = new UnidadProcesadora(NombrePorcesadora.bar.toString());
        
        Producto producto1 = new Producto("1A", "milanesa con fritas", 180, 10, cocina);
        Producto producto2 = new Producto("2A", "gin tonic", 250, 20, bar);
             
        Mozo mozo1 = Fachada.getInstancia().crearUsuarioMozo("099250364", "Emanuel", "emanuel123", "Emanuel Coitiño");
        Mozo mozo2 = Fachada.getInstancia().crearUsuarioMozo("098869788", "Fausto", "fausto123", "Fausto Perillo");        
        
        mozo1.agregarMesa(mesa1);
        mozo1.agregarMesa(mesa2);
        mozo2.agregarMesa(mesa3);
        mozo2.agregarMesa(mesa4);
   
    }
}
