package ar.edu.unlu.poo.figura2Dy3D;

public class Circulo extends Figura2D{
    private double radio;

    public Circulo(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }

    @Override
    public double getArea() {
        return Math.PI * radio * radio;
    }
}
