package modelo;

import java.util.ArrayList;
import static utilidades.NumberUtils.esNumero;

public class Servicio {
    
    private ArrayList<ItemServicio> itemsServicio = new ArrayList<>();
    private Mesa mesa;
    private Cliente cliente;
    private String beneficioAplicado;
    private float montoDescuento;
    
    public Servicio() {}

    public ArrayList<ItemServicio> getItemsServicio() {
        return itemsServicio;
    }

    public String getBeneficioAplicado() {
        return beneficioAplicado;
    }  
    
    public float getMontoDescuento() {
        return montoDescuento;
    } 

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void setBeneficioAplicado(String beneficioAplicado) {
        this.beneficioAplicado = beneficioAplicado;
    }

    public void setMontoDescuento(float montoDescuento) {
        this.montoDescuento = montoDescuento;
    }        
    
    public ItemServicio agregarItemServicio(Producto producto, String descripcion, String cantidad) throws RestaurantException {
        if(!esNumero(cantidad)) throw new RestaurantException("La cantidad debe ser un número");
        int cant = Integer.parseInt(cantidad);
        ItemServicio itemServicio = new ItemServicio(producto, cant, descripcion,this);
        itemServicio.validar();
        itemsServicio.add(itemServicio);
        producto.bajarStock(cant);
        itemServicio.agregarAUnidadProcesadora();
        return itemServicio;
    }
    
    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
        if(cliente != null) {
            cliente.obtenerMontoBeneficio(this);
        }        
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public boolean tieneCliente(){
        return cliente != null;
    }
    
    public float obtenerMontoTotalServicio() {
        float montoTotal = 0;
        for(ItemServicio item : this.getItemsServicio()) {
            montoTotal += item.getSubTotal();
        }
        return montoTotal;
    }
    
    public float getTotalPorProducto(String codigo) {
        float total=0;
        for(ItemServicio item : this.getItemsServicio()) {
            if(item.getProducto().getCodigo().equals(codigo)) {
                total += item.getSubTotal();
            }
        }
        return total;
    }
    
    public float obtenerMontoTotalMenosBeneficio() {
        return obtenerMontoTotalServicio() - montoDescuento;
    }
    
    public boolean tieneTodosLosPedidosFinalizados() {
        for(ItemServicio item : itemsServicio){
            if(!item.pedidoFinalizado()) return false;
        }
        return true;
    }
    
    public void avisarUnidadesProcesadoras() {
        for(ItemServicio item : itemsServicio) {
//           item.getProcesadora().avisar(UnidadProcesadora.eventos.hubo_cambio);
            item.getProducto().getUnidadProcesadora().avisar(UnidadProcesadora.eventos.hubo_cambio);
        }
    }

}
