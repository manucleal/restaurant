package modelo;

public class Conexion {
    
    private Usuario usuario;
    
    public Conexion(Usuario usuario) {
        this.usuario = usuario;
    }   

    public Usuario getUsuario() {
        return usuario;
    }
}
