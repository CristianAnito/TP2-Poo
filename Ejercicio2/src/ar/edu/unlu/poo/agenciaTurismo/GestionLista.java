package ar.edu.unlu.poo.agenciaTurismo;

import ar.edu.unlu.poo.paquete.Destino;
import ar.edu.unlu.poo.paquete.Excursion;
import ar.edu.unlu.poo.paquete.Hospedaje;
import ar.edu.unlu.poo.paquete.MedioTransporte;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GestionLista {
    private List<Proveedor> proveedorList;
    private List<Destino> destinoList;
    private List<MedioTransporte> medioTransporteList;
    private List<Hospedaje> hospedajeList;
    private List<Excursion> excursionList;
    private List<Cliente> clienteList;
    private List<Paquete> paqueteList;
    private List<Compra> compraList;

    public GestionLista(){
        proveedorList = new ArrayList<>();
        destinoList = new ArrayList<>();
        medioTransporteList = new ArrayList<>();
        hospedajeList = new ArrayList<>();
        excursionList = new ArrayList<>();
        clienteList = new ArrayList<>();
        paqueteList = new ArrayList<>();
        compraList = new ArrayList<>();
    }

    public void ordenarProveedores(){
        proveedorList.sort(Comparator.comparing(Proveedor::getTipo));
        System.out.println("PROVEEDORES CLASIFICADOS:");
        proveedorList.forEach(proveedor -> System.out.println(proveedor.getTipo() + ": " + proveedor.getNombre()));;
    }
    public void ordenarComprasPorCliente(){
        Collections.sort(compraList, new Comparator<Compra>() {
            @Override
            public int compare(Compra compra1, Compra compra2) {
                return compra1.getCliente().getNombreYapellido().compareTo(compra2.getCliente().getNombreYapellido());
            }
        });
    }
    public void ordenarComprasPorDestino(){
        Collections.sort(compraList, new Comparator<Compra>() {
            @Override
            public int compare(Compra compra1, Compra compra2) {
                return compra1.getPaquete().getDestino().getNombre().compareTo(compra2.getPaquete().getDestino().getNombre());
            }
        });
    }

    public void ordenarComprasPorPaquete(){
        Collections.sort(compraList, new Comparator<Compra>() {
            @Override
            public int compare(Compra compra1, Compra compra2) {
                return compra1.getPaquete().getId().compareTo(compra2.getPaquete().getId());
            }
        });
    }

    public void mostrarPaquetes(){
        int i = 1;
        for (Paquete paquete:paqueteList) {
            System.out.println("Paquete " + i + ": Destino: " + paquete.getDestino().getNombre() + " -Hospedaje: " + paquete.getHospedaje().getNombreHotel() +
                    " -Transporte: " + paquete.getTransporte().getTipo());
            for (Excursion excursion:excursionList) {
                System.out.println(" -Excursion: " + excursion.getDescripcion());
            }
            System.out.println("-Precio: " + paquete.getPrecio());
            i++;
        }
    }
    public void mostrarClientes(){
        for (Cliente cliente: clienteList) {
            System.out.println("Cliente: " + cliente.getNombreYapellido() + " DNI: " + cliente.getDocumento() + " Telefono: " + cliente.getTelefono());
        }
    }

    public void mostrarCompras(){
        for (Compra compras:compraList) {
            System.out.println("Cliente: " + compras.getCliente().getNombreYapellido() + ". Compro Paquete: " + compras.getPaquete().getId());
        }
    }
    //No se especifica si el informe es mensual o general, opto por hacerlo mensual, ya que el "mostrarCompras" hace algo parecido a un informe general.
    public void informeMensual() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        ordenarComprasPorDestino();
        System.out.println("Informe Mensual:");
        for (Compra ventas: compraList) {
            if (ventas.getFecha().after(format.parse("01-08-2023")) && ventas.getFecha().before(format.parse("31-08-2023"))){
                System.out.println("Cliente: " + ventas.getCliente().getNombreYapellido() + " - Fecha: " + ventas.getFecha() + " - Destino: " + ventas.getPaquete().getDestino().getNombre());
            }
        }
    }
    public void destinoFavorito(){
        ordenarComprasPorPaquete();
        Map<Destino, Integer> comprasPorDestino = new HashMap<>();

        // Recorrer la lista de compras y actualizar el mapa
        for (Compra compra : compraList) {
            Destino destinoCompra = compra.getPaquete().getDestino();
            comprasPorDestino.put(destinoCompra, comprasPorDestino.getOrDefault(destinoCompra, 0) + 1);
        }

        // Encontrar el destino favorito
        Destino destinoFavorito = null;
        int cantidadComprasMax = 0;

        //Map.Entry es una interfaz que representa una entrada (o par clave-valor) en un mapa.
        //comprasPorDestino.entrySet() para obtener un conjunto de todas las entradas del mapa.
        for (Map.Entry<Destino, Integer> entry : comprasPorDestino.entrySet()) {
            if (entry.getValue() > cantidadComprasMax) {
                cantidadComprasMax = entry.getValue();
                destinoFavorito = entry.getKey();
            }
        }

        if (destinoFavorito != null) {
            System.out.println("El destino favorito de los clientes es: " + destinoFavorito.getNombre());
        } else {
            System.out.println("No hay suficientes datos para determinar un destino favorito.");
        }
    }
    public void agregarProveedor(Proveedor proveedor){
        proveedorList.add(proveedor);
    }
    public void agregarDestino(Destino destino){
        destinoList.add(destino);
    }
    public void agregarTransporte(MedioTransporte medioTransporte){
        medioTransporteList.add(medioTransporte);
    }
    public void agregarHospedaje(Hospedaje hospedaje){
        hospedajeList.add(hospedaje);
    }
    public void agregarExcursion(Excursion excursion){
        excursionList.add(excursion);
    }
    public void agregarCliente(Cliente cliente){
        clienteList.add(cliente);
    }
    public void agregarPaquete(Paquete paquete){
        paqueteList.add(paquete);
    }
    public void agregarCompra(Compra compra){
        compraList.add(compra);
    }

    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public List<Destino> getDestinoList() {
        return destinoList;
    }

    public List<MedioTransporte> getMedioTransporteList() {
        return medioTransporteList;
    }

    public List<Hospedaje> getHospedajeList() {
        return hospedajeList;
    }

    public List<Excursion> getExcursionList() {
        return excursionList;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public List<Paquete> getPaqueteList() {
        return paqueteList;
    }

    public List<Compra> getCompraList() {
        return compraList;
    }
}
