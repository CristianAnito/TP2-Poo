package ar.edu.unlu.poo.estacion;

import java.text.DecimalFormat;
import java.util.*;

public class ModuloInformes {
    private List<Map.Entry<String, Double>> informeTop10Clientes;
    private List<Map.Entry<String, Double>> informeVentasXCombustible;
    private List<Map.Entry<Integer, Double>> informeVentasXExpendedor;
    private List<Map.Entry<Integer, Double>> informeLitrosXExpendedor;
    private List<Map.Entry<String, Double>> informeVentasXEmpleado;
    private List<Venta> informeTop10Ventas;
    private List<Venta> ventaList;

    public ModuloInformes() {
        this.informeTop10Clientes = new ArrayList<>();
        this.informeVentasXCombustible = new ArrayList<>();
        this.informeVentasXExpendedor = new ArrayList<>();
        this.informeLitrosXExpendedor = new ArrayList<>();
        this.informeVentasXEmpleado = new ArrayList<>();
        this.ventaList = new ArrayList<>();
        this.informeTop10Ventas = new ArrayList<>();
    }

    public void agregarVenta(Venta venta){
        ventaList.add(venta);
    }
//----------------------------------------------------------------------------------------------------------------------
    public void verificarSiAplicaDescuento(Venta venta){
        boolean aplico = false;
        getInformeTop10Clientes();
        for (Map.Entry<String, Double> cliente : informeTop10Clientes){
            if (venta.getCliente().getPatente().equals(cliente.getKey())){
                double montoConDescuento = venta.getImporteTotal() - ((venta.getImporteTotal() * 5) / 100);
                venta.setImporteTotal(montoConDescuento);
                System.out.println("Cliente: " + venta.getCliente().getPatente() + ", descuento aplicado, nuevo pago: " + montoConDescuento);
                agregarVenta(venta);
                aplico = true;
            }
        }
        if (!aplico){
            System.out.println("Cliente: " + venta.getCliente().getPatente() + ", No aplica descuento.");
            agregarVenta(venta);
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    private void getInformeTop10Clientes(){
        Map<String, Double> totalComprasPorCliente = getStringDoubleMap();

        // Ordenar el mapa por el monto total de compras en orden descendente
        List<Map.Entry<String, Double>> topClientes = new ArrayList<>(totalComprasPorCliente.entrySet());
        topClientes.sort((cliente1, cliente2) -> cliente2.getValue().compareTo(cliente1.getValue()));

        // Obtener los primeros 10 clientes
        informeTop10Clientes = topClientes.subList(0, Math.min(topClientes.size(), 10));

    }

    public void mostrarInformeTop10Clientes(){
        getInformeTop10Clientes();

        // Imprimir el "top 10" de clientes
        System.out.println("Top 10 Clientes:");
        for (Map.Entry<String, Double> cliente : informeTop10Clientes) {
            System.out.println("Cliente: " + cliente.getKey() + ", Total de Compras: $" + cliente.getValue());
        }
        System.out.println(" ");
    }

    private Map<String, Double> getStringDoubleMap() {
        Map<String,Double> totalComprasPorCliente = new HashMap<>();

        //obtengo la fecha actual utilizando la clase Calendar
        Date fechaACtual = new Date();
        Calendar calendarFechaActual = Calendar.getInstance();
        calendarFechaActual.setTime(fechaACtual);
        //obtengo el mes de la fecha actual
        int mesFechaActual = calendarFechaActual.get(Calendar.MONTH);

        for (Venta venta: ventaList){
            //Para obtener el mes de cada venta
            Calendar calendarFechaVenta = Calendar.getInstance();
            calendarFechaVenta.setTime(venta.getFecha());
            int mesFechaVenta = calendarFechaVenta.get(Calendar.MONTH);

            if (mesFechaVenta == mesFechaActual - 1){
                String patente = venta.getCliente().getPatente();
                Double totalVenta = venta.getImporteTotal();

                //El método .put(key, value) se utiliza para agregar un par clave-valor a un mapa en Java.
                //getOrDefault(nombreCliente, 0.0): Este método se utiliza para obtener el valor asociado con una clave específica (nombreCliente) en el mapa totalComprasPorCliente.
                // Si la clave (nombreCliente) existe en el mapa, se devuelve el valor correspondiente; de lo contrario, se devuelve el valor predeterminado proporcionado,
                // que en este caso es 0.0. Se suma el importe toal para ir acumulando las ventas que realizo ese cliente.
                totalComprasPorCliente.put(patente, totalComprasPorCliente.getOrDefault(patente,0.0) + totalVenta);
            }
        }
        return totalComprasPorCliente;
    }
    //------------------------------------------------------------------------------------------------------------------
    public void getInformeVentasXCombustible(){
        Map<String, Double> totalComprasPorCombustible = getStringDoubleCombustibleMap();

        // Ordenar el mapa por el monto total de compras en orden descendente
        informeVentasXCombustible = new ArrayList<>(totalComprasPorCombustible.entrySet());
        informeVentasXCombustible.sort((combustible1, combustible2) -> combustible2.getValue().compareTo(combustible1.getValue()));

        System.out.println("Listado de la proporción de ventas efectuadas para cada tipo de combustible");
        for (Map.Entry<String, Double> combustible : informeVentasXCombustible) {
            System.out.println("Combustible: " + combustible.getKey() + ", Total de Compras: $" + combustible.getValue());
        }
    }

    private Map<String, Double> getStringDoubleCombustibleMap() {
        Map<String,Double> totalComprasPorCombustible = new HashMap<>();

        for (Venta venta: ventaList){
            String nombreCombustible = venta.getExpendedor().getCombustible().getNombre();
            Double totalVenta = venta.getImporteTotal();

            totalComprasPorCombustible.put(nombreCombustible, totalComprasPorCombustible.getOrDefault(nombreCombustible,0.0) + totalVenta);
        }
        return totalComprasPorCombustible;
    }
    //------------------------------------------------------------------------------------------------------------------
    public void getInformeVentasXExpendedor(){
        Map<Integer, Double> totalComprasPorExpendedor = getIntegerDoubleExpendedorMap();

        // Ordenar el mapa por el monto total de compras en orden descendente
        informeVentasXExpendedor = new ArrayList<>(totalComprasPorExpendedor.entrySet());
        informeVentasXExpendedor.sort((expendedor1, expendedor2) -> expendedor2.getValue().compareTo(expendedor1.getValue()));

        System.out.println("Listado de la proporción de ventas efectuadas por cada expendedor.");
        for (Map.Entry<Integer, Double> expendedor : informeVentasXExpendedor) {
            System.out.println("Expendedor: " + expendedor.getKey() + ", Total de Compras: $" + expendedor.getValue());
        }
    }

    private Map<Integer, Double> getIntegerDoubleExpendedorMap() {
        Map<Integer,Double> totalComprasPorExpendedor = new HashMap<>();

        for (Venta venta: ventaList){
            Integer codigoExpendedor = venta.getExpendedor().getCodigo();
            Double totalVenta = venta.getImporteTotal();

            totalComprasPorExpendedor.put(codigoExpendedor, totalComprasPorExpendedor.getOrDefault(codigoExpendedor,0.0) + totalVenta);
        }
        return totalComprasPorExpendedor;
    }
//----------------------------------------------------------------------------------------------------------------------

    public void getInformeLitrosXExpendedor(){
        Map<Integer, Double> totalLitrosXExpendedor = getIntegerDoubleLitrosMap();

        //El método entrySet() de un mapa devuelve un conjunto de objetos Map.Entry. Cada Map.Entry representa un par clave-valor en el mapa.
        informeLitrosXExpendedor = new ArrayList<>(totalLitrosXExpendedor.entrySet());
        informeLitrosXExpendedor.sort((litros1, litros2) -> litros2.getValue().compareTo(litros1.getValue()));

        // Crear un objeto DecimalFormat para especificar el formato
        DecimalFormat df = new DecimalFormat("#.00"); // Dos decimales

        System.out.println("Listado de surtidores ordenados por cantidad de litros expendidos");
        for (Map.Entry<Integer, Double> litros : informeLitrosXExpendedor){
            System.out.println("Expendedor: " + litros.getKey() + ", Total de litros expendidos: " + df.format(litros.getValue()));
        }
    }
    private Map<Integer, Double> getIntegerDoubleLitrosMap(){
        Map<Integer, Double> totalLitrosXExpendedor = new HashMap<>();

        for (Venta venta: ventaList){
            Integer codigoExpendedor = venta.getExpendedor().getCodigo();
            Double litros = venta.getImporteTotal() / venta.getExpendedor().getCombustible().getPrecioVenta();

            totalLitrosXExpendedor.put(codigoExpendedor, totalLitrosXExpendedor.getOrDefault(codigoExpendedor, 0.0) + litros);
        }
        return totalLitrosXExpendedor;
    }
//----------------------------------------------------------------------------------------------------------------------

    public void getInformeVentaXEmpleado(){
        Map<String, Double> totalVentaXEmpleado = getStringDoubleEmpleado();
        informeVentasXEmpleado = new ArrayList<>(totalVentaXEmpleado.entrySet());
        informeVentasXEmpleado.sort((empleado1, empleado2) -> empleado2.getValue().compareTo(empleado1.getValue()));

        System.out.println("Listado de ventas por Empleado.");
        for (Map.Entry<String, Double> empleado : informeVentasXEmpleado){
            System.out.println("Empleado: " + empleado.getKey() + ", Total de ventas: " + empleado.getValue());
        }
    }
    private Map<String, Double> getStringDoubleEmpleado(){
        Map<String, Double> totalVentaXEmpleado = new HashMap<>();

        for (Venta venta : ventaList){
            String nombreEmpleado = venta.getEmpleado().getNombre() + " " + venta.getEmpleado().getApellido();
            Double totalVenta = venta.getImporteTotal();

            totalVentaXEmpleado.put(nombreEmpleado, totalVentaXEmpleado.getOrDefault(nombreEmpleado, 0.0) + totalVenta);
        }
        return totalVentaXEmpleado;
    }
    //------------------------------------------------------------------------------------------------------------------
    public void verificarSiEmpleadoDescuento(){
        generarInformeTop10Ventas();
        System.out.println("Top 10 de ventas del mes pasado.");
        for (Venta venta : informeTop10Ventas){
            System.out.println("Empleado: " + venta.getEmpleado().getNombre() + " " + venta.getEmpleado().getApellido() + ", importe de Venta: " + venta.getImporteTotal());
        }
    }

    public List<Venta> getInformeTop10Ventas(){
        generarInformeTop10Ventas();
        return informeTop10Ventas;
    }

    private void generarInformeTop10Ventas(){
        List<Venta> listadoTop10Ventas = new ArrayList<>();
        Date fechaActual = new Date();
        Calendar calendarFechaActual = Calendar.getInstance();
        calendarFechaActual.setTime(fechaActual);
        int mesFechaActual = calendarFechaActual.get(Calendar.MONTH);

        for (Venta venta : ventaList){
            Calendar calendarFechaVenta = Calendar.getInstance();
            calendarFechaVenta.setTime(venta.getFecha());
            int mesFechaVenta = calendarFechaVenta.get(Calendar.MONTH);

            if (mesFechaVenta == mesFechaActual - 1){
                listadoTop10Ventas.add(venta);
            }
        }

        listadoTop10Ventas.sort(Comparator.comparing(Venta::getImporteTotal).reversed());
        informeTop10Ventas = listadoTop10Ventas.subList(0, Math.min(listadoTop10Ventas.size(), 10));
    }

    public void aplicarDescuento(Venta venta){
        if (venta.getEmpleado().isDescuentoAplicar()){
            System.out.println("Ya utilizo su descuento.");
        }else {
            double descuento = venta.getImporteTotal() * 0.10; // Descuento del 10%
            double totalConDescuento = venta.getImporteTotal() - descuento;
            venta.getEmpleado().setDescuentoAplicar(true);
            System.out.println("Descuento aplicado al cliente: " + venta.getCliente().getPatente() +
                    "\n, por el empleado: " + venta.getEmpleado().getNombre() + " " + venta.getEmpleado().getApellido());
        }
    }

    public void actualizarPrecioCombustible(Combustible combustible, Double nuevoPrecio){
        if (combustible != null){
            System.out.println("Precio actualizado");
            System.out.println("Precio anterior: " + combustible.getPrecioVenta() + ", Precio Actualizado: " + nuevoPrecio);
            combustible.setPrecioVentaXLitro(nuevoPrecio);
        }else {
            System.out.println("Tipo de combustible inexistente");
        }
    }
}
