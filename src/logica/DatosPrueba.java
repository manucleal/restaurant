/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import utils.NombrePorcesadora;
import static utils.NombrePorcesadora.cocina;

/**
 *
 * @author ecoitino
 */
public class DatosPrueba {
    
    public static void cargar() {
        
        UnidadProcesadora cocina = new UnidadProcesadora(NombrePorcesadora.cocina.toString());        
        UnidadProcesadora bar = new UnidadProcesadora(NombrePorcesadora.bar.toString());
        
        Producto producto1 = new Producto("1A", "milanesa con fritas", 180, 10, cocina);
        Producto producto2 = new Producto("2A", "gin tonic", 250, 20, bar);
    }
}
