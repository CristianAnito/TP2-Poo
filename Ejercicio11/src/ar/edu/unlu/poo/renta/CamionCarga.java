package ar.edu.unlu.poo.renta;

public class CamionCarga extends Automovil{
    private final double costoFijo = 100000.0;
    public CamionCarga(String patente) {
        super(patente);
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        if (dias > 30){
            return 75000 * dias;
        }else return costoFijo;
    }
}
