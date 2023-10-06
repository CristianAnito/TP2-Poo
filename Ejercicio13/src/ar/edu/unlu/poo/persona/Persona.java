package ar.edu.unlu.poo.persona;

public class Persona {
    private String nombre;
    private String numeroDeTelefono;
    private String direccion;

    public Persona(String nombre, String numeroDeTelefono, String direccion) {
        this.nombre = nombre;
        this.numeroDeTelefono = numeroDeTelefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public String getDireccion() {
        return direccion;
    }
}
