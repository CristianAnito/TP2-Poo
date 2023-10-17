package ar.edu.unlu.poo.billeteraVirtual;

import ar.edu.unlu.poo.cuenta.CajaAhorro;
import ar.edu.unlu.poo.cuenta.CuentaCredito;
import ar.edu.unlu.poo.cuenta.CuentaNormal;

public class Usuario {
    private CuentaNormal cuentaNormal;
    private CuentaCredito cuentaCredito;
    private CajaAhorro cajaAhorro;

    public Usuario(CuentaNormal cuenta, CuentaCredito cuentaCredito, CajaAhorro cajaAhorro) {
        this.cuentaNormal = cuenta;
        this.cuentaCredito = cuentaCredito;
        this.cajaAhorro = cajaAhorro;
    }

    public Usuario(CuentaNormal cuenta, CuentaCredito cuentaCredito) {
        this.cuentaNormal = cuenta;
        this.cuentaCredito = cuentaCredito;
    }

    public Usuario(CuentaNormal cuenta) {
        this(cuenta, null);
    }

    /**
     * Muestra por consola el estado de su cuenta, imprime:
     * 	a. El saldo
     *  b. El limite de giro en descubierto y en parentesis el monto girado en descubierto.
     *  c. El monto total invertido y entre parentesis el interes a ganar.
     *  d. El monto disponible para compras a credito y la deuda total a pagar segun las compras.
     */
    public void mostrarEstado() {
        System.out.println("--- Cuenta ----");
        System.out.println("");
        System.out.println("Saldo: "+this.cuentaNormal.getSaldo());
        System.out.println("Giro en descubierto: "+this.cuentaNormal.getLimiteGiroDescubierto()+"("+this.cuentaNormal.getGiroDescubierto()+")");
        System.out.println("Inversiones: "+this.cuentaNormal.getMontoInvertido()+"("+this.cuentaNormal.getInteresAGanar()+")");
        System.out.println("");
        System.out.println("--- Caja de ahorros ----");
        System.out.println("");
        System.out.println("Saldo: "+this.cajaAhorro.getSaldo());
        System.out.println("Inversiones: "+this.cajaAhorro.getMontoInvertido()+"("+this.cajaAhorro.getInteresAGanar()+")");
        System.out.println("");
        System.out.println("--- Cuenta crédito ----");
        System.out.println("");
        System.out.println("Disponible para compras: "+this.cuentaCredito.getMontoDisponibleParaCompras());
        System.out.println("Saldo deudor: "+this.cuentaCredito.getSaldoDeudor());
    }

    /**
     * Intenta realizar un gasto sobre la cuenta. En caso de que el monto sea mayor al saldo, emite un mensaje que no se puede
     * realizar el gasto porque se va a girar en descubierto.
     * @param monto
     * @return
     */
    public boolean realizarGasto(double monto) {
        if(monto > this.cuentaNormal.getSaldo()) {
            System.out.println("No se puede realizar el gasto, se va a girar en descubierto..");
            return false;
        }else {
            return this.cuentaNormal.gastar(monto);
        }
    }

    /**
     * Intenta realizar un gasto sobre la cuenta por mas que se vaya a girar en descubierto
     * @param monto
     * @return
     */
    public boolean realizarGastoYGirar(double monto) {
        return this.cuentaNormal.gastar(monto);
    }


    /**
     * Intenta realizar un gasto sobre la cuentaCredito. En caso de que el monto sea mayor al saldo, emite un mensaje que no se puede realizar
     * @param monto
     * @return
     */
    public boolean realizarGastoCC(double monto){
        if (monto > this.cuentaCredito.getMontoDisponibleParaCompras()){
            System.out.println("No se puede realizar el gasto");
            return false;
        }else {
            return this.cuentaCredito.gastar(monto);
        }
    }

    /**
     * Intenta realizar un pago sobre la cuentaCredito
     * @param monto
     * @param indiceCompra
     * @return
     */

    public boolean realizarPago(double monto, int indiceCompra){
        return this.cuentaCredito.pagar(monto, indiceCompra);
    }

    //faltan mas operaciones.
}
