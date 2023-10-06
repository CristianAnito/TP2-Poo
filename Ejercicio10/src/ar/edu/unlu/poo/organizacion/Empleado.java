package ar.edu.unlu.poo.organizacion;

import java.util.Calendar;
import java.util.Date;

public class Empleado {
    private String nombre;
    private String apellido;
    private String telefono;
    private String cuit;
    private Date fechaCumple;
    private final int bono = 2000;

    public Empleado(String nombre, String apellido, String telefono, String cuit, Date fechaCumple) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.cuit = cuit;
        this.fechaCumple = fechaCumple;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCuit() {
        return cuit;
    }

    public Date getFechaCumple() {
        return fechaCumple;
    }
    public boolean esCumple(){
        Date fechaActual = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual);
        int mes = calendar.get(Calendar.MONTH) + 1;

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(fechaCumple);
        int mesCumple = calendar2.get(Calendar.MONTH) + 1;

        return mes == mesCumple;
    }
    public double calcularSueldo(){
        if (esCumple()){
            return bono;
        }else return 0;
    }
}
