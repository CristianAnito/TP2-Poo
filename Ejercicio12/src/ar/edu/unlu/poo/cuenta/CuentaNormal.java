package ar.edu.unlu.poo.cuenta;

import java.time.LocalDate;

public class CuentaNormal extends CuentaSaldo{
    private double limiteGiroDescubierto;
    private double giroDescubierto;
    public static final double INTERES_POR_INVERSION_CANCELACION = 0.05;
    public static final double PLAZO_DIAS_INVERSION_CANCELACION = 30;
    private boolean preCancel = false;

    public CuentaNormal(double saldo, double limiteGiroDescubierto) {
        super(saldo);
        this.limiteGiroDescubierto = limiteGiroDescubierto;
        this.giroDescubierto = 0;
        this.saldoInvertido = 0;
        this.fechaInversion = null;
    }

    /**
     * Dado un monto genera un gasto en la cuenta: quita del saldo el monto a gastar, si el monto es mayor
     * al saldo entonces gira en descubierto (siempre y cuando todavía quede límite).
     * Si (saldo + limite descubierto disponible) < monto, entonces la operacion no se realiza y devuelve false.
     * @param monto: el monto a gastar
     * @return boolean: indica si la operación fué exitosa.
     */
    @Override
    public boolean gastar(double monto) {
        boolean res = false;

        if ((this.saldo + (this.limiteGiroDescubierto-this.giroDescubierto)) >= monto) {
            if (this.saldo < monto) {
                //verifico si la precancelacion esta activada
                if (preCancel){
                    cancelarYrecuperarInversion();

                    // Verifico si el saldo me alzanza para el gasto
                    if (this.saldo >= monto){
                        this.saldo -=monto;
                    }else {
                        //Giro en descubierto
                        this.giroDescubierto += monto - this.saldo;
                        this.saldo = 0;
                    }
                }else {
                    //Giro en descubierto
                    this.giroDescubierto += monto - this.saldo;
                    this.saldo = 0;
                }
            }else {
                // El saldo me alzanza para el gasto
                this.saldo -= monto;
            }
            res = true;
        }

        return res;
    }

    /**
     * Deposita el monto en la cuenta. Si existe giro en descubierto, primero intenta cubrirlo y si queda
     * dinero disponible aumenta el saldo.
     * @param monto
     */
    @Override
    public void depositar(double monto) {
        if (monto > 0){
            if (this.giroDescubierto == 0){
                this.saldo += monto;
            }else {
                if (this.giroDescubierto - monto >= 0){
                    this.giroDescubierto -= monto;
                }else {
                    this.saldo += monto - this.giroDescubierto;
                    this.giroDescubierto = 0;
                }
            }
            System.out.println("Saldo depositado.");
        }else {
            System.out.println("Ingrese un deposito positivo.");
        }
    }

    @Override
    public boolean invertir(double monto) {
        return super.invertir(monto);
    }
    @Override
    public boolean recuperarInversion() {
        return super.recuperarInversion();
    }

    /**
     * Devuelve el monto invertido al saldo con el interes establecido. Devuelve una inversion siempre y
     * cuando hayan pasado al menos 30 días desde que que se inicio la inversión.
     * @return
     */
    public boolean cancelarYrecuperarInversion() {
        boolean res = false;
        LocalDate fechaActual = LocalDate.now();
        long diasTranscurridos = fechaInversion.until(fechaActual).getDays();

        if (diasTranscurridos >= PLAZO_DIAS_INVERSION_CANCELACION){
            this.saldo += this.saldoInvertido + (this.saldoInvertido * INTERES_POR_INVERSION_CANCELACION);
            res = true;
        }else {
            this.saldo += this.saldoInvertido;
            res = true;
        }
        this.saldoInvertido = 0;
        return res;
    }

    /**
     * Activa la precancelacion, siempre y cuando exista un monto invertido.
     * @return
     */
    public boolean preCancelacion(){
        if (saldoInvertido > 0){
            preCancel = true;
        }
        return preCancel;
    }

    @Override
    public double getSaldo() {
        return super.getSaldo();
    }

    @Override
    public double getInteresAGanar() {
        return super.getInteresAGanar();
    }

    @Override
    public double getMontoInvertido() {
        return super.getMontoInvertido();
    }

    public double getGiroDescubierto() {
        return this.giroDescubierto;
    }

    public double getLimiteGiroDescubierto() {
        return this.limiteGiroDescubierto;
    }
}
