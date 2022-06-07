package modelo;

import java.util.ArrayList;

public class Servicio {
    
    private ArrayList<ItemServicio> itemsServicio = new ArrayList<>();
    private Mesa mesa;
    private Cliente cliente;
    private String beneficioAplicado;
    private float montoDescuento;
    
    public Servicio() {}
    
    public Servicio(Mesa mesa) {}

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
    
    public boolean agregarItemServicio(Producto producto, String descripcion, String cantidad) throws RestaurantException {
        if(esNumero(cantidad)) {
            int cant = Integer.parseInt(cantidad);
            ItemServicio itemServicio = new ItemServicio(producto, cant, descripcion,this);
            if(!itemServicio.validar()) {
                return false;
            }
            itemsServicio.add(itemServicio);
            producto.bajarStock(cant);
            producto.agregarPedidoAUnidadProcesadora(itemServicio);
            return true;
        }
        return false;
    }
    
    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
        cliente.setServicio(this);
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
    
    private boolean esNumero(String num) {
        try {
            Double.parseDouble(num);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
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

}
