package ar.edu.unlu.poo.organizacion;

import java.util.Date;

public class Pasante extends Empleado{

    public Pasante(String nombre, String apellido, String telefono, String cuit, Date fechaCumple) {
        super(nombre, apellido, telefono, cuit, fechaCumple);
    }
    @Override
    public double calcularSueldo() {
        return super.calcularSueldo();
    }
}
