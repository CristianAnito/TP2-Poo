package ar.edu.unlu.poo.futbol;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Socio {
    private String nombre;
    private String apellido;
    private int edad;
    private int documento;
    private String direccion;
    private String email;
    private int tel;
    private Suscripcion suscripcion;
    private Credencial credencial;
    private int cantSocios;
    private static int id = 0;

    public Socio(String nombre, String apellido, int edad, int documento, String direccion, String email, int tel, Suscripcion suscripcion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.direccion = direccion;
        this.email = email;
        this.tel = tel;
        this.suscripcion = suscripcion;
        this.cantSocios = id++;
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaVenc = fechaActual.plusYears(12).plusMonths(3);
        this.credencial = new Credencial(cantSocios, nombre, apellido, documento,  fechaActual, fechaVenc);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getTel() {
        return tel;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public int getDocumento() {
        return documento;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    public Credencial getCredencial() {
        return credencial;
    }

}
