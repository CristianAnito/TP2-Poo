package ar.edu.unlu.poo.organizacion;

import java.util.Date;

public class EmpleadoComision extends Empleado{
    private int montoVentas;
    private double porcentajeComision;

    public EmpleadoComision(String nombre, String apellido, String telefono, String cuit, Date fechaCumple, int montoVentas, double porcentajeComision) {
        super(nombre, apellido, telefono, cuit, fechaCumple);
        this.montoVentas = montoVentas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularSueldo() {
        double bono = super.calcularSueldo();
        if (super.esCumple()){
            return montoVentas + (montoVentas * porcentajeComision / 100) + (montoVentas * 0.5) + bono;
        }
        return montoVentas + (montoVentas * porcentajeComision / 100);
    }
}
