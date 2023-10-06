package ar.edu.unlu.poo.bibliotecaHyP;

public class Socio {
    private int id = 0;
    private String nombre = "";
    private String apellido = "";
    private String telefono = "";

    public Socio(int id, String nombre, String apellido, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    //Geteres

    public int getId() {
        return id;
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
}
