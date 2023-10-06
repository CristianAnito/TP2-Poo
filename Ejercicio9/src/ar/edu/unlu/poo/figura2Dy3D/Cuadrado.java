package ar.edu.unlu.poo.figura2Dy3D;

public class Cuadrado extends Figura2D{
    private double lado;
    public Cuadrado(String nombre, double lado){
        super(nombre);
        this.lado = lado;
    }

    @Override
    public double getArea() {
        return lado * lado;
    }
}
