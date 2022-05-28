package modelo;

import logica.Usuario;

public class Conexion {
    
    private Usuario usuario;
    
    public Conexion(Usuario usuario) {
        this.usuario = usuario;
    }   

    public Usuario getUsuario() {
        return usuario;
    }
        
}
