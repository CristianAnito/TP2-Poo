package ar.edu.unlu.poo.venta;

public class Venta {
    private String id;
    private PaqueteTurismo paqueteTurismo;
    private Cliente cliente;

    public Venta(String id, PaqueteTurismo paqueteTurismo, Cliente cliente) {
        this.id = id;
        this.paqueteTurismo = paqueteTurismo;
        this.cliente = cliente;
    }
    public double calcularImporteTotal(){
        return paqueteTurismo.calcularPrecioPorPersona();
    }

    public String getId() {
        return id;
    }

    public PaqueteTurismo getPaqueteTurismo() {
        return paqueteTurismo;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
