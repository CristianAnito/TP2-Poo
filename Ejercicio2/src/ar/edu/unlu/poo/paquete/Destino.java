package ar.edu.unlu.poo.paquete;

public class Destino {
    private String nombre;
    private String descripcion;

    public Destino(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
