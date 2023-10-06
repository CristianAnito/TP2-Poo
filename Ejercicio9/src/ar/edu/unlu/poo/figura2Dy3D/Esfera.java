package ar.edu.unlu.poo.figura2Dy3D;

public class Esfera extends Figura3D{
    private double radio;

    public Esfera(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * radio * radio;
    }

    @Override
    public double getVolumen() {
        return ((double) 4/3) * Math.PI * radio * radio * radio;
    }
}
