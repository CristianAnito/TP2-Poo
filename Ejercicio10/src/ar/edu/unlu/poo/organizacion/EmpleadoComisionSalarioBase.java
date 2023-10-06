package ar.edu.unlu.poo.organizacion;

import java.util.Date;

public class EmpleadoComisionSalarioBase extends Empleado{
    private int montoVentas;
    private double porcentajeComision;
    private double salarioMensual;

    public EmpleadoComisionSalarioBase(String nombre, String apellido, String telefono, String cuit, Date fechaCumple, int montoVentas, double porcentajeComision, double salarioMensual) {
        super(nombre, apellido, telefono, cuit, fechaCumple);
        this.montoVentas = montoVentas;
        this.porcentajeComision = porcentajeComision;
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularSueldo() {
        double bono = super.calcularSueldo();
        if (super.esCumple()){
            return (montoVentas + (montoVentas * porcentajeComision / 100)) + salarioMensual + (montoVentas * 0.5) + 1000 + bono;
        }
        return (montoVentas + (montoVentas * porcentajeComision / 100)) + salarioMensual;
    }
}
