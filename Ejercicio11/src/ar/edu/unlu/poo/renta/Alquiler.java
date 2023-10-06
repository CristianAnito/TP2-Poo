package ar.edu.unlu.poo.renta;

import java.util.Date;

public class Alquiler {
    private Cliente cliente;
    private Presupuesto presupuesto;
    private Date fechaInicio;
    private Date fechaFin;

    public Alquiler(Cliente cliente, Presupuesto presupuesto, Date fechaInicio, Date fechaFin) {
        this.cliente = cliente;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    public double calcularSaldoAPagar(){
        return presupuesto.calcularMontoFinal();
    }
}
