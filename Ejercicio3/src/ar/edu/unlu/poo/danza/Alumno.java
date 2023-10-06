package ar.edu.unlu.poo.danza;

public class Alumno {
    private String nombreYapellido;
    private int edad;
    private int documento;
    private String direccion;
    private int telefono;

    public Alumno(String nombreYapellido, int edad, int documento, String direccion, int telefono) {
        this.nombreYapellido = nombreYapellido;
        this.edad = edad;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombreYapellido() {
        return nombreYapellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getDocumento() {
        return documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }
}
