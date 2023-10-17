package ar.edu.unlu.poo.cuenta;

public abstract class Cuenta {
    protected double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    public abstract boolean gastar(double monto);

    public double getSaldo() {
        return saldo;
    }
}
