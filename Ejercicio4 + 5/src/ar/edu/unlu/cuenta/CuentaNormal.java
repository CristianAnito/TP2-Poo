package ar.edu.unlu.cuenta;

import java.time.LocalDate;

public class CuentaNormal extends Cuenta{
    private double limiteGiroDescubierto;
    private double giroDescubierto;
    private double saldoInvertido;
    public static final double INTERES_POR_INVERSION = 0.4;
    public static final double INTERES_POR_INVERSION_CANCELACION = 0.05;
    public static final double PLAZO_DIAS_INVERSION = 90;
    public static final double PLAZO_DIAS_INVERSION_CANCELACION = 30;
    private LocalDate fechaInversion;
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

    public boolean gastar(double monto) {
        boolean res = false;

        if ((super.getSaldo() + (this.limiteGiroDescubierto-this.giroDescubierto)) >= monto) {
            if (getSaldo() < monto) {
                //verifico si la precancelacion esta activada
                if (preCancel){
                    cancelarYrecuperarInversion();

                    // Verifico si el saldo me alzanza para el gasto
                    if (getSaldo() >= monto){
                        retirar(monto);
                    }else {
                        //Giro en descubierto
                        this.giroDescubierto += monto - getSaldo();
                        this.saldo = 0;
                    }
                }else {
                    //Giro en descubierto
                    this.giroDescubierto += monto - getSaldo();
                    this.saldo = 0;
                }
            }else {
                // El saldo me alzanza para el gasto
                retirar(monto);
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

    /**
     * Realiza la inversion del monto indicado. Condiciones para que la operación sea exitosa:
     * 	a. Que el saldo sea >= monto
     *  b. Que no exista una inversión activa.
     *
     * Tambien establece la fecha de inversión.
     *
     * @param monto
     * @return
     */
    public boolean invertir(double monto) {
        boolean res = false;
        if (this.saldoInvertido == 0){
            if (monto > 0 && this.saldo >= monto){
                this.saldo -= monto;
                this.saldoInvertido = monto;
                this.fechaInversion = LocalDate.now();
            }
            res = true;
        }

        return res;
    }

    /**
     * Devuelve el monto invertido al saldo con el interes establecido. Se puede realizar siempre y cuando
     * hayan pasado los N días que dura la inversión.
     * @return
     */
    public boolean recuperarInversion() {
        boolean res = false;
        LocalDate fechaActual = LocalDate.now();
        // Calcular la diferencia de días entre la fecha establecida y la fecha actual
        long diasTranscurridos = fechaInversion.until(fechaActual).getDays();
        if (diasTranscurridos >= PLAZO_DIAS_INVERSION){
            this.saldo += this.saldoInvertido + (this.saldoInvertido * INTERES_POR_INVERSION);
            this.saldoInvertido = 0;
            res = true;
        }
        return res;
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

    public double getSaldo() {
        return this.saldo;
    }

    public double getGiroDescubierto() {
        return this.giroDescubierto;
    }

    public double getLimiteGiroDescubierto() {
        return this.limiteGiroDescubierto;
    }

    public double getMontoInvertido() {
        return this.saldoInvertido;
    }

    public double getInteresAGanar() {
        if (this.fechaInversion != null)
            return this.saldoInvertido * CuentaNormal.INTERES_POR_INVERSION;
        return 0.0d;
    }
}
