package ar.edu.unlu.poo.bibliotecaHyP;

public class Tesis extends Publicacion{
    private String autor = "";
    private String mes = "";

    public Tesis(String autor, String mes, String editor, String anioPublicacion, String telefonoProveedor, String nombre, Integer paginas, Integer cantidadEjemplares) {
        super(editor, anioPublicacion, telefonoProveedor, nombre, paginas, cantidadEjemplares);
        this.setAutor(autor);
        this.setMes(mes);
    }

    //Geteres

    public String getAutor() {
        return autor;
    }

    public String getMes() {
        return mes;
    }

    //Seteres

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
