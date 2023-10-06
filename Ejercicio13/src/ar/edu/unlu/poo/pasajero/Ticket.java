package ar.edu.unlu.poo.pasajero;

public class Ticket {
    private String codigo;
    private double precio;

    public Ticket(String codigo, Double precio) {
        this.codigo = codigo;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }
}
