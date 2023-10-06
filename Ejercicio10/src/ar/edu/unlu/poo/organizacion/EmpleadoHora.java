package ar.edu.unlu.poo.organizacion;

import java.util.Date;

public class EmpleadoHora extends Empleado{
    private int cantidadHoras;
    private double montoHora;

    public EmpleadoHora(String nombre, String apellido, String telefono, String cuit, Date fechaCumple, int cantidadHoras, double montoHora) {
        super(nombre, apellido, telefono, cuit, fechaCumple);
        this.cantidadHoras = cantidadHoras;
        this.montoHora = montoHora;
    }

    @Override
    public double calcularSueldo() {
        double bono = super.calcularSueldo();
        if (cantidadHoras > 40){
            double sueldo = cantidadHoras * montoHora;
            return sueldo + (sueldo * 20 / 100) + bono;
        }else return cantidadHoras * montoHora + bono;
    }
}
