package modelo;

public abstract class Usuario {
    
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
    
}
