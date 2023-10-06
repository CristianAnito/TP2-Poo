package ar.edu.unlu.poo.figura2Dy3D;

public class Rectangulo extends Figura2D{
    private double base;
    private double altura;

    public Rectangulo(String nombre, double base, double altura) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double getArea() {
        return base * altura;
    }
}
