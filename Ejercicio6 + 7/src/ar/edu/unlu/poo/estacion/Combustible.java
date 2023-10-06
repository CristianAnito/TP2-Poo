package ar.edu.unlu.poo.estacion;

public class Combustible {
    private String nombre;
    private double precioVentaXLitro;

    public Combustible(String nombre, double precioVenta) {
        this.nombre = nombre;
        this.precioVentaXLitro = precioVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioVenta() {
        return precioVentaXLitro;
    }

    public void setPrecioVentaXLitro(double precioVentaXLitro) {
        this.precioVentaXLitro = precioVentaXLitro;
    }
}
