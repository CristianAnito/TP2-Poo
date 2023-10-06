package ar.edu.unlu.poo.renta;

public class Automovil {
    private String patente;
    private final double precioBase = 3000.0;

    public Automovil(String patente) {
        this.patente = patente;
    }
    public double calcularCostoAlquiler(int dias){
        return precioBase * dias;
    }

    public String getPatente() {
        return patente;
    }
}
