package ar.edu.unlu.poo.paquete;

import ar.edu.unlu.poo.agenciaTurismo.Proveedor;

public class MedioTransporte {
    private TipoTransporte tipo;
    private Proveedor proveedor;
    private double precio;

    public MedioTransporte(TipoTransporte tipo, Proveedor proveedor, double precio) {
        this.tipo = tipo;
        this.proveedor = proveedor;
        this.precio = precio;
    }

    public TipoTransporte getTipo() {
        return tipo;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public double getPrecio() {
        return precio;
    }
}
