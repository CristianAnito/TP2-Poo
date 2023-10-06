package ar.edu.unlu.poo.renta;

public class Combi extends Automovil{
    public Combi(String patente) {
        super(patente);
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        return 4500.0 * dias;
    }
}
