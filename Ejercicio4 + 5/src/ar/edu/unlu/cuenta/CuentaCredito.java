package ar.edu.unlu.cuenta;

import java.util.ArrayList;
import java.util.List;

public class CuentaCredito {
    private double limite;
    private static final double RECARGO_FIJO = 0.05;
    private List<Double> compras;
    private List<Double> pagado;


    public CuentaCredito(double limite) {
        this.limite = limite;
        this.compras = new ArrayList<Double>();
        this.pagado = new ArrayList<Double>();
    }

    /**
     * Registra una nueva compra en caso que todavía quede saldo disponible para compras.
     *
     * @param monto
     * @return boolean: true si la compra fue existosa, false en caso contrario.
     */
    public boolean comprar(double monto) {
        if (monto > 0 && monto <= limite){
            compras.add(monto);
            limite -= monto;
            return true;
        }else return false;
    }

    /**
     * Realiza un pago sobre una compra. Si el monto es menor o igual al saldo que queda por pagar de la compra, el pago se registra
     * y la operacion es exitosa devolviendo true.
     * Si el monto es mayor al saldo, entonces la operación no se realiza devolviendo false.
     *
     * @param monto: cantidad a pagar.
     * @param indiceCompra: el numero de indice de la compra sobre la cual se requiere realizar un pago.
     * @return
     */
    public boolean pagar(double monto, int indiceCompra) {
        if (indiceCompra >= 0 && indiceCompra < compras.size()){
            Double compra = compras.get(indiceCompra);
            if (monto <= compra){
                compras.set(indiceCompra, monto - compra);
                pagado.add(monto);
                limite += monto;
                return true;
            }else return false;
        }else return false;
    }

    /**
     * Retorna el saldo que queda por pagar de una compra, incluyendo el interes.
     *
     * @param indiceCompra
     * @return
     */
    public double getSaldoDeudorCompra(int indiceCompra) {
        if (indiceCompra >= 0 && indiceCompra < compras.size()){
            Double compra = compras.get(indiceCompra);
            return compra + (compra * RECARGO_FIJO);
        }else {
            System.out.println("Posicion invalida.");
            return 0.0d;
        }
    }

    /**
     * Devuelve el saldo deudor total teniendo en cuenta todas las compras impagas.
     * @return double
     */
    public double getSaldoDeudor() {
        double total = 0;
        for (double compra : compras) {
            total += compra + (compra * RECARGO_FIJO) ;
        }
        return total;
    }

    /**
     * Devuelve el monto disponible para compras de la cuenta teniendo en cuenta todas las compras
     * realizadas que quedan por pagar, sin tener en cuenta las que deben solo el interes.
     * @return double: el saldo disponible para realizar compras.
     */
    public double getMontoDisponibleParaCompras() {
        double saldoRestante = limite; // Inicialmente, el saldo restante es igual al límite de compra

        for (double compra : compras) {
            // Calcular el monto total a pagar, incluyendo el recargo del 5%
            double totalAPagar = compra + (compra * RECARGO_FIJO);

            // Verificar si la compra ha sido completamente pagada
            if (!pagado.contains(compra)) {
                // Si la compra no ha sido completamente pagada, restarla del saldo restante
                saldoRestante -= totalAPagar;
            }
        }

        return saldoRestante;
    }

}
