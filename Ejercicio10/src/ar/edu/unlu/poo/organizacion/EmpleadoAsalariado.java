package ar.edu.unlu.poo.organizacion;

import java.util.Date;

public class EmpleadoAsalariado extends Empleado{
    private double salarioMensual;

    public EmpleadoAsalariado(String nombre, String apellido, String telefono, String cuit, Date fechaCumple, double salarioMensual) {
        super(nombre, apellido, telefono, cuit, fechaCumple);
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularSueldo() {
        double bono = super.calcularSueldo();
        if (super.esCumple()){
            return salarioMensual + bono + 1000;
        }else return salarioMensual;
    }
}
