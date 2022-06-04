package modelo;

public class Cliente {
    
    private int id;
    private String nombre;
    private String email;
    private TipoCliente tipoCliente;

    public Cliente(String nombre, String email, TipoCliente tipoCliente) {
        this.nombre = nombre;
        this.email = email;
        this.tipoCliente = tipoCliente;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

}
