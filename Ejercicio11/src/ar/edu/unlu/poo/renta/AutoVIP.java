package ar.edu.unlu.poo.renta;

public class AutoVIP extends Automovil{
    private final double plaza = 500.0;
    public AutoVIP(String patente) {
        super(patente);
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        return super.calcularCostoAlquiler(dias) + (plaza * dias);
    }
}
