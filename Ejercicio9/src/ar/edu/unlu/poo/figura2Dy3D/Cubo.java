package ar.edu.unlu.poo.figura2Dy3D;

public class Cubo extends Figura3D{
    private double arista;

    public Cubo(String nombre, double arista) {
        super(nombre);
        this.arista = arista;
    }

    @Override
    public double getArea() {
        return 6 * arista * arista;
    }

    @Override
    public double getVolumen() {
        return arista * arista * arista;
    }
}
