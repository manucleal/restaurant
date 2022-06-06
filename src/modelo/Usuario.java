package modelo;

import observador.Observable;

public abstract class Usuario extends Observable {
    
    private String nombreUsuario;
    private String password;
    private String nombreCompleto;

    public Usuario(String nombreUsuario, String contrasena, String nombreCompleto) {
        this.nombreUsuario = nombreUsuario;
        this.password = contrasena;
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    public boolean validar() {
        return !(nombreUsuario.isBlank() || password.isBlank() || nombreCompleto.isBlank());
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto;
    }
    
}
