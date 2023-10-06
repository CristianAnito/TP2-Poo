package ar.edu.unlu.poo.danza;

public class Comision {
    private Integer numero;
    private String dia;
    private String hora;
    private Nivel nivel;
    private Disciplina disciplina;
    private int salon;
    private String profesor;


    public Comision(Integer numero, String dia, String hora, Nivel nivel, Disciplina disciplina, int salon, String profesor) {
        this.numero = numero;
        this.dia = dia;
        this.hora = hora;
        this.nivel = nivel;
        this.disciplina = disciplina;
        this.salon = salon;
        this.profesor = profesor;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public int getSalon() {
        return salon;
    }

    public String getProfesor() {
        return profesor;
    }
}
