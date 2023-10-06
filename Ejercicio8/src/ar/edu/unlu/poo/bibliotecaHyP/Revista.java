package ar.edu.unlu.poo.bibliotecaHyP;

public class Revista extends Publicacion{
    private String issn = "";
    private int numero = 0;
    public Revista(String issn, String nombre) {
        this(issn, nombre, 0);
    }

    public Revista(String issn, String nombre, int numero) {
        this(issn, nombre, numero, 0);
    }

    public Revista(String issn, String nombre, int numero, int cantidadEjemplaresIniciales) {
        this(issn, nombre, numero, cantidadEjemplaresIniciales, 0);
    }

    public Revista(String issn, String nombre, int numero, int cantidadEjemplaresIniciales, int cantidadPaginas) {
        super(nombre, cantidadEjemplaresIniciales, cantidadPaginas);
        this.setIssn(issn);
    }

    //Geteres

    public String getIssn() {
        return issn;
    }

    public int getNumero() {
        return numero;
    }
    //Seteres

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    //Metodos

    @Override
    public String toString() {
        return super.toString() +
                ", numero=" + numero +
                ", issn='" + issn + '\'';
    }
}
