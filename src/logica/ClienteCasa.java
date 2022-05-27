package logica;

public class ClienteCasa extends Cliente {

    public ClienteCasa(int id, String nombre, String email) {
        super(id, nombre, email);
    }        

    @Override
    public void obtenerBeneficio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
