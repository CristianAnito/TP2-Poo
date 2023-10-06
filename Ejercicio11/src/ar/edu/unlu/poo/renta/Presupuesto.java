package ar.edu.unlu.poo.renta;

public class Presupuesto {
    private Automovil automovil;
    private int diasAlquiler;

    public Presupuesto(Automovil automovil, int diasAlquiler) {
        this.automovil = automovil;
        this.diasAlquiler = diasAlquiler;
    }
    public double calcularMontoFinal(){
        return automovil.calcularCostoAlquiler(diasAlquiler);
    }
}
