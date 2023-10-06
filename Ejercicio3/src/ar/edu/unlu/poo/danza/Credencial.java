package ar.edu.unlu.poo.danza;

public class Credencial {
    private int Numero;
    private Alumno alumno;
    private Comision comision;

    public Credencial(int numero, Alumno alumno, Comision comision) {
        Numero = numero;
        this.alumno = alumno;
        this.comision = comision;
    }

    public int getNumero() {
        return Numero;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Comision getComision() {
        return comision;
    }
}
