package logica;

import java.util.ArrayList;

public class SistemaPedidos {
    
    ArrayList<UnidadProcesadora> procesadoras = new ArrayList();
    ArrayList<Servicio> servicios = new ArrayList();

    protected SistemaPedidos() {}        
    
    public ArrayList<UnidadProcesadora> getProcesadoras() {
        return procesadoras;        
    }
    
    
}
