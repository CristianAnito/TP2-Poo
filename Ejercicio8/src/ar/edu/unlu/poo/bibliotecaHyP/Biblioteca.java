package ar.edu.unlu.poo.bibliotecaHyP;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Socio> socios = new ArrayList<Socio>();
    private ArrayList<Libro> libros = new ArrayList<Libro>();

    public void addSocio(Socio socio){ socios.add(socio);}
    public void addLibro(Libro libro){
        libros.add(libro);
    }

    public int countPrestados(){
        int prestados = 0;
        for (Libro l: libros){
            prestados += l.getCantidadPrestados();
        }
        return prestados;
    }
    public void mostrarEjemplaresEnPrestamo(){
        int ejemplar = 1;
        for (Libro l: libros){
            System.out.println("Libro: " + l.getNombre() + " ejemplares prestados actualmente: ");
            for (Socio s: l.getSocios()){
                System.out.println("Ejemplar: " + ejemplar + " prestado a Socio: " + s.getId());
                ejemplar++;
            }
            ejemplar = 1;
        }
    }

    public void ejemplaresDisponibles(){
        for (Libro l: libros){
            System.out.println("Libro: " + l.getNombre() + " dispone de " + l.getCantidadDisponible() + " ejemplares.");
        }
    }

    public void getLibrosAutor(String autor){
        for (Libro l: libros){
            if (l.esAutor(autor))
                System.out.println(l);
        }

    }
    public void hayarLibros(String clave){
        for (Libro l: libros){
            if (l.hallar(clave))
                System.out.println(l);
        }

    }
}
