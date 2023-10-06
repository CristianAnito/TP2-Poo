package ar.edu.unlu.poo.futbol;

import java.time.LocalDate;
import java.util.Date;

public class Credencial {
    private int id;
    private Socio socio;
    private int documento;
    private String nomYap;
    private LocalDate fechaIngreso;
    private LocalDate fechaVencimiento;

    public Credencial(int id, String nombre, String apellido, int documento, LocalDate fechaIngreso, LocalDate fechaVencimiento){
        this.id = id;
        this.documento = documento;
        this.nomYap = nombre + " " + apellido;
        this.fechaIngreso = fechaIngreso;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getId() {
        return id;
    }

    public int getDocumento() {
        return documento;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public String getNomYap() {
        return nomYap;
    }
}
