package ar.edu.unlu.poo.renta;

public class AutoDePasajero extends Automovil{
    private int asientos;
    private final double precioAsiento = 300.0;
    public AutoDePasajero(String patente, int asientos) {
        super(patente);
        this.asientos = asientos;
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        return super.calcularCostoAlquiler(dias) + ((precioAsiento * asientos) * dias);
    }
}
