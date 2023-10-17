package ar.edu.unlu.poo.proveedor;

public class Proveedor {
    private String nombre;
    private String tipo;
    private double precioBase;

    public Proveedor(String nombre, String tipo, double precioBase) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioBase = precioBase;
    }
    public double calcularImporteExtra(int clientesMaximos){
        return 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioBase() {
        return precioBase;
    }
}
