package ar.edu.unlu.poo.cuenta;

public class CajaAhorro extends CuentaSaldo{
    public CajaAhorro(double saldo) {
        super(saldo);
    }

    @Override
    public boolean gastar(double monto) {
        return monto <= this.saldo;
    }

    @Override
    public void depositar(double monto) {
        if (monto > 0){
            this.saldo += monto;
            System.out.println("Saldo depositado.");
        }else {
            System.out.println("Ingrese un deposito positivo.");
        }
    }

    @Override
    public double getSaldo() {
        return super.getSaldo();
    }
}
