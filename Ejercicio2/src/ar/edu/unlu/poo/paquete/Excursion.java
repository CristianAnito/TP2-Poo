package ar.edu.unlu.poo.paquete;

import ar.edu.unlu.poo.agenciaTurismo.Proveedor;

public class Excursion {
    private String descripcion;
    private Proveedor proveedor;
    private double precio;

    public Excursion(String descripcion, Proveedor proveedor, double precio) {
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public double getPrecio() {
        return precio;
    }
}
