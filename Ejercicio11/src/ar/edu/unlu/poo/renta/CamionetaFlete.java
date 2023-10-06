package ar.edu.unlu.poo.renta;

public class CamionetaFlete extends Automovil{
    private int pesoAutorizadoTotal;
    private final double precioPAT = 600.0;
    public CamionetaFlete(String patente, int pesoAutorizadoTotal) {
        super(patente);
        this.pesoAutorizadoTotal = pesoAutorizadoTotal;
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        return super.calcularCostoAlquiler(dias) + pesoAutorizadoTotal * precioPAT;
    }
}
