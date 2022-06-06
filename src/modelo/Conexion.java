package modelo;

import exceptions.RestaurantException;

public class Conexion {
    
    private Usuario usuario;
    
    public Conexion(Usuario usuario) {
        this.usuario = usuario;
    }   

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void logout() throws RestaurantException {
        Fachada.getInstancia().logoutConexion(this);
    }
        
}
