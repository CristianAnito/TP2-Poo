package ar.edu.unlu.poo.bibliotecaHyP;

import java.util.ArrayList;

public class Libro extends Publicacion{
    //Propiedades
    private String[] autores = new String[5];
    private String isbn = "";
    private ArrayList<Socio> socios = new ArrayList<>();

    //Constructores
    public Libro(String isbn, String nombre) {
        this(isbn, nombre, null); //La línea this(isbn, nombre, null); intenta llamar a otro constructor de Libro con los mismos parámetros (isbn, nombre, null)
    }

    public Libro(String isbn, String nombre, String[] listaDeAutores) {
        this(isbn, nombre, listaDeAutores, 0);
    }

    public Libro(String isbn, String nombre, String[] listaDeAutores, int cantidadEjemplaresIniciales) {
        this(isbn, nombre, listaDeAutores, cantidadEjemplaresIniciales, 0);
    }

    public Libro(String isbn, String nombre, String[] listaDeAutores, int cantidadEjemplaresIniciales, int cantidadPaginas) {
        super(nombre, cantidadEjemplaresIniciales, cantidadPaginas);
        this.setIsbn(isbn);
        if (listaDeAutores == null) {
            for (int x = 0;x < autores.length; x ++){
                autores[x] = new String("");
            }
        } else {
            for (String autor : autores) {
                this.setAutor(autor);
            }
        }
    }

    public String[] getAutores() {
        return autores;
    }

    public boolean setAutor(String autor) {
        // Buscamos el primer autor vacio y lo ponemos allí
        int contadorAutores = 0;
        while (contadorAutores < autores.length && !autores[contadorAutores].equals(""))
            contadorAutores ++;

        if (contadorAutores < autores.length) {
            autores[contadorAutores] = autor;
            return true;
        } else {
            return false;
        }
    }
    public boolean esAutor(String autor){
        return (buscarAutor(autor) > -1);
    }
    public int buscarAutor(String autor) {
        int x = 0;
        autor = autor.toLowerCase();
        while (x < autores.length && !contieneIgnoreCase( autor,autores[x]))
            x++;
        if (x < autores.length) {
            return x;
        } else {
            return -1;
        }
    }
    public boolean hallar(String dato){
        return (contieneIgnoreCase(dato,getIsbn()) ||
                contieneIgnoreCase(dato,getNombre()) ||
                esAutor(dato));
    }

    public static boolean contieneIgnoreCase(String cadena1, String cadena2) {
        // Convertir ambas cadenas a minúsculas para hacer la comparación
        String cadena1Lower = cadena1.toLowerCase();
        String cadena2Lower = cadena2.toLowerCase();

        // Verificar si la cadena2 contiene la cadena1 (ignorando mayúsculas y minúsculas)
        return cadena2Lower.contains(cadena1Lower);
    }


    public boolean removeAutor(String autor) {
        // Buscamos el primer el autor y si está lo vaciamos
        int x = this.buscarAutor(autor);
        if (x >= 0) {
            autores[x] = "";
            return true;
        } else {
            return false;
        }
    }
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", autores=" + mostrarAutores() +
                ", isbn='" + isbn + '\'';
    }

    private String mostrarAutores(){
        String respuesta = "";
        for (int x = 0; x < autores.length; x ++) {
            if (!autores[x].equals("")) {
                if (respuesta.length() > 0)
                    respuesta += " - " + autores[x];
                else respuesta += autores[x];
            }
        }
        return respuesta;
    }
    public void addSocio(Socio socio){
        socios.add(socio);
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public boolean prestarEjemplar(Socio socio) {
        if (super.prestarEjemplar()){
            socios.add(socio);
            return true;
        }else return false;
    }

    public boolean devolverEjemplar(Socio socio) {
        if (super.devolverEjemplar()){
            socios.remove(socio);
            return true;
        }else return false;
    }
}
