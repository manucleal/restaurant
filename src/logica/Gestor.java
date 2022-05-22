/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Date;

/**
 *
 * @author ecoitino
 */
public class Gestor extends Usuario {
    
    private Date fechaUltimoAcceso;

    public Gestor(Date fechaUltimoAcceso, String nombreUsuario, String contrasena, String nombreCompleto) {
        super(nombreUsuario, contrasena, nombreCompleto);
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }
    
}
