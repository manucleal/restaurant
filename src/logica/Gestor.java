package logica;

import java.util.Date;

public class Gestor extends Usuario {
    
    private Date fechaUltimoAcceso;

    public Gestor(Date fechaUltimoAcceso, String nombreUsuario, String contrasena, String nombreCompleto) {
        super(nombreUsuario, contrasena, nombreCompleto);
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }
    
}
