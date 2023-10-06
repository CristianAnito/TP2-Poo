package ar.edu.unlu.poo.estacion;

public class Expendedor {
    private int codigo;
    private Combustible combustible;

    public Expendedor(int codigo, Combustible combustible) {
        this.codigo = codigo;
        this.combustible = combustible;
    }

    public int getCodigo() {
        return codigo;
    }

    public Combustible getCombustible() {
        return combustible;
    }
}
