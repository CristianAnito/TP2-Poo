package ar.edu.unlu.poo.venta;

import ar.edu.unlu.poo.proveedor.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class PaqueteTurismo {
    private String id;
    private List<Proveedor> proveedorList = new ArrayList<>();
    private String destino;
    private int clientesMaximos;

    public PaqueteTurismo(String id, String destino, int clientesMaximos) {
        this.id = id;
        this.destino = destino;
        this.clientesMaximos = clientesMaximos;
    }
    public void agregarProveedor(Proveedor proveedor){
        proveedorList.add(proveedor);
    }
    public double calcularPrecioPorPersona(){
        double precioProveedor = 0;
        double precioPersona = 0;
        for (Proveedor proveedor: proveedorList){
            precioProveedor = (proveedor.getPrecioBase() * clientesMaximos) + proveedor.calcularImporteExtra(clientesMaximos);
            precioPersona += precioProveedor/clientesMaximos;
        }
        return precioPersona;
    }

    public String getId() {
        return id;
    }

    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public String getDestino() {
        return destino;
    }

    public int getClientesMaximos() {
        return clientesMaximos;
    }
}
