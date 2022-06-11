/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

/**
 *
 * @author ecoitino
 */
public class NumberUtils {
    
    public static boolean esNumero(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }    
}
