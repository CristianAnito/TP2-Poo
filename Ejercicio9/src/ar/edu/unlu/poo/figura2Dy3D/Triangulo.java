package ar.edu.unlu.poo.figura2Dy3D;

public class Triangulo extends Figura2D{
    private double base;
    private double altura;

    public Triangulo(String nombre, double base, double altura) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double getArea() {
        return (base * altura) / 2;
    }
}
