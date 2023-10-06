package ar.edu.unlu.poo.figura2Dy3D;

public class Tetraedro extends Figura3D{
    private double arista;

    public Tetraedro(String nombre, double arista) {
        super(nombre);
        this.arista = arista;
    }

    @Override
    public double getArea() {
        return arista * arista * Math.sqrt(3);
    }

    @Override
    public double getVolumen() {
        return arista * arista * arista * ((Math.sqrt(2)) / 12);
    }
}
