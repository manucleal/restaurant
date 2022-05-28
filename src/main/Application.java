/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import logica.DatosPrueba;
import vistaEscritorio.Menu;

/**
 *
 * @author ecoitino
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatosPrueba.cargar();
        new Menu().setVisible(true);
    }
    
}
