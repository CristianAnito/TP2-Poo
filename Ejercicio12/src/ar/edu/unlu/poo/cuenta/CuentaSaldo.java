package ar.edu.unlu.poo.cuenta;

import java.time.LocalDate;

public abstract class CuentaSaldo extends Cuenta{
    protected double saldoInvertido;
    public static final double INTERES_POR_INVERSION = 0.4;
    public static final double PLAZO_DIAS_INVERSION = 90;
    protected LocalDate fechaInversion;

    public CuentaSaldo(double saldo) {
        super(saldo);
        this.saldoInvertido = 0;
        this.fechaInversion = null;
    }
    /**
     * Dado un monto genera un gasto en la cuenta: quita del saldo el monto a gastar
     * Si el saldo es menor al monto devuelve false
     * @param monto: el monto a gastar
     * @return boolean: indica si la operación fué exitosa.
     */

    @Override
    public abstract boolean gastar(double monto);

    /**
     * Deposita el monto en la cuenta.
     * @param monto
     */
    public abstract void depositar(double monto);

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

    public double getMontoInvertido() {
        return this.saldoInvertido;
    }

    public double getInteresAGanar() {
        if (this.fechaInversion != null)
            return this.saldoInvertido * CuentaNormal.INTERES_POR_INVERSION;
        return 0.0d;
    }
}
