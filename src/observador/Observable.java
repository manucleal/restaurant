/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observador;

import java.util.ArrayList;

/**
 *
 * @author Dario
 */
public class Observable {
    
    private ArrayList<Observador> observadores = new ArrayList();
    
    public void agregarObservador(Observador o){
        if(!observadores.contains(o)){
            observadores.add(o);
        }
    }
    
    public void quitarObservador(Observador o){
        observadores.remove(o);
    }
    
    public void avisar(Object evento){
        
        ArrayList<Observador> copia = new ArrayList(observadores);
        
        for(Observador o : copia) {
            try{
                o.actualizar(evento, this);
            }catch(Exception e){
                System.out.println("Error al avisar:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
}
