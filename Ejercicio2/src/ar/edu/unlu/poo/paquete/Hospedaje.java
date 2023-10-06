package ar.edu.unlu.poo.paquete;

import ar.edu.unlu.poo.agenciaTurismo.Proveedor;

public class Hospedaje {
    private String nombreHotel;
    private Proveedor proveedor;
    private String calificacion;
    private double precio;

    public Hospedaje(String nombreHotel, Proveedor proveedor, String calificacion, double precio) {
        this.nombreHotel = nombreHotel;
        this.proveedor = proveedor;
        this.calificacion = calificacion;
        this.precio = precio;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public double getPrecio() {
        return precio;
    }
}
