package modelo;

public class Cliente {
    
    private int id;
    private String nombre;
    private String email;
    private TipoCliente tipoCliente;
    private Servicio servicio;

    public Cliente(String nombre, String email, TipoCliente tipoCliente) {
        this.nombre = nombre;
        this.email = email;
        this.tipoCliente = tipoCliente;
        this.tipoCliente.setCliente(this);
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

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    public String obtenerNombreBeneficio(TipoCliente tipo){
        return tipo.getNombreBeneficio();
    }
    
    public float obtenerMontoBeneficio(){
        return tipoCliente.obtenerMontoBeneficio();
    }
    
    public float obtenerMontoTotalMenosBeneficio() {
        return tipoCliente.obtenerMontoTotalMenosBeneficio();
    }

    public float obtenerMontoTotal() {
        return servicio.obtenerMontoTotalServicio();
    }

}
