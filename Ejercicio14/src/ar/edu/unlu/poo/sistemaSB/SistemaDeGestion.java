package ar.edu.unlu.poo.sistemaSB;

import ar.edu.unlu.poo.proveedor.Proveedor;
import ar.edu.unlu.poo.venta.Cliente;
import ar.edu.unlu.poo.venta.PaqueteTurismo;
import ar.edu.unlu.poo.venta.Venta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaDeGestion {
    private List<Proveedor> proveedors;
    private List<PaqueteTurismo> paqueteTurismos;
    private List<Cliente> clientes;
    private List<Venta> ventas;

    public SistemaDeGestion() {
        this.proveedors = new ArrayList<>();
        this.paqueteTurismos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }
    public void registrarVenta(Venta venta){
        ventas.add(venta);
    }
    public void generearInformeVentasPorDestino(){
        Map<String, List<Venta>> ventasPorDestino = new HashMap<>();
        for (Venta venta: ventas){
            String destino = venta.getPaqueteTurismo().getDestino();
            List<Venta> ventasEnDestino = ventasPorDestino.computeIfAbsent(destino, k -> new ArrayList<>());

            ventasEnDestino.add(venta);
        }

        for (String destino: ventasPorDestino.keySet()){
            List<Venta> ventasEnDestino = ventasPorDestino.get(destino);
            System.out.println("Destino: " + destino);
            for (Venta venta: ventasEnDestino){
                System.out.println("Venta: " + venta.getId()
                        + ", Paquete: " + venta.getPaqueteTurismo().getId()
                        + ", Cliente: " + venta.getCliente().getNombre() + venta.getCliente().getApellido());
            }
        }
    }
    public void destinoFavoritoClientes(){
        String destinoFav = "";
        // Crear un mapa para contar las ventas por destino
        Map<String, Integer> ventasPorDestino = new HashMap<>();

        // Contar las ventas por destino
        for (Venta venta: ventas){
            String destino = venta.getPaqueteTurismo().getDestino();
            ventasPorDestino.put(destino, ventasPorDestino.getOrDefault(destino, 0) + 1);

        }

        // Encontrar el destino con la mayor cantidad de ventas
        int maxVentas = 0;
        for (Map.Entry<String, Integer> entry: ventasPorDestino.entrySet()){
            if (entry.getValue() > maxVentas){
                maxVentas = entry.getValue();
                destinoFav = entry.getKey();
            }
        }
        System.out.println("El destino favorito de los clientes es: " + destinoFav + ", con " + maxVentas + " ventas.");
    }
    public void generarInformeProveedores(){
        Map<String, List<Proveedor>> proveedorPorTipo = new HashMap<>();
        for (Proveedor proveedor: proveedors){
            String tipo = proveedor.getTipo();
            List<Proveedor> tipoProveedor = proveedorPorTipo.computeIfAbsent(tipo, k -> new ArrayList<>());

            tipoProveedor.add(proveedor);
        }

        for (String tipo: proveedorPorTipo.keySet()){
            List<Proveedor> tipoProveedor = proveedorPorTipo.get(tipo);
            System.out.println("Proveedor de: " + tipo);
            for (Proveedor proveedor: tipoProveedor){
                System.out.println("Proveedor: " + proveedor.getNombre());
            }
        }
    }
}
