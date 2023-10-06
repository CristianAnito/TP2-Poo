package ar.edu.unlu.poo.danza;

public class Disciplina {
    private String nombre;
    private String duracion;
    private boolean estado;

    public Disciplina(String nombre, String duracion, boolean estado) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public boolean isEstado() {
        return estado;
    }
}
