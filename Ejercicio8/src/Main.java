import ar.edu.unlu.poo.bibliotecaHyP.Biblioteca;
import ar.edu.unlu.poo.bibliotecaHyP.Libro;
import ar.edu.unlu.poo.bibliotecaHyP.Socio;

/*
Ejercicio 6 (guia anterior)

Necesitamos implementar la clase Libro para un sistema de administración de bibliotecas. Generalmente las búsquedas se hacen por Título o Autor,
es casi imposible que quieran buscar un libro por ISBN y en ciertos casos no se tiene el dato para completarlo. Si solo queda un ejemplar disponible,
no se puede prestar el libro porque tiene que quedar disponible para consultar dentro de la biblioteca. El sistema debería mostrar la descripción
del libro como: El libro <su_titulo> creado por el autor <su_autor> tiene <num_paginas> páginas, quedan <num_ejemplares> disponibles y
se prestaron <num_ejemplares_prestados>. También se necesita determinar la cantidad de préstamos realizados, teniendo en cuenta todos los libros disponibles.

Objetivos:
1.	Definir estructura y comportamiento.
2.	Crear una clase que utilice a la anterior y que cree 2 objetos Libro (los valores que se quieran) y mostrarlos por pantalla e indique cuál de los 2 tiene más páginas.
3.	Intentar prestar un libro con 10 ejemplares y uno con 1 solo ejemplar.
4.	Mostrar cantidad total hecha de préstamos.

Ejercicio 8 (Herencia y Polimorfismo)

Ahora nos llega un nuevo requerimiento: En realidad un Libro es un caso particular de una Publicación, dado que además la biblioteca maneja ahora Revistas, Tesis y Diarios.
Los 4 tipos de publicaciones comparten un nombre, un editor y un teléfono de contacto con el proveedor que los distribuye. Sin embargo, los libros tienen ISBN,
pero las revistas tienen ISSN. Por otro lado, las revistas tienen además un número y año de publicación (los libros solo tienen año de publicación);
las Tesis tienen un Autor y un mes y año de publicación (los Libros pueden tener varios autores, siempre al menos uno); y los diarios tienen una fecha de publicación
(que además del año, incluye mes y día).

Para el caso particular de los Libros, se desea tener un seguimiento de los préstamos. Para ello, el sistema debe entonces incorporar el concepto de Socio de la
Biblioteca y establecer un diseño que permita prestar un ejemplar a un socio. En este caso, es requisito disponer de un método que sepa mostrar los ejemplares en
préstamo actualmente. Además, es necesario disponer de otro método que permita contabilizar la cantidad de ejemplares disponibles por cada libro.

Para el relato anterior se precisa:
-.  Definir una jerarquía de tipos aplicando herencia. En la misma debe definirse claramente qué atributos van en el supertipo y cuáles en los tipos específicos.

    respuesta:
        Superclase (Supertipo): Publicacion
        Atributos compartidos: nombre, editor, teléfonoProveedor, añoPublicacion

        Subclase 1 (Tipo Específico): Libro
        Atributos adicionales: ISBN, autores (una lista de autores)

        Subclase 2 (Tipo Específico): Revista
        Atributos adicionales: ISSN, numeroPublicacion, añoPublicacion (puedes heredarlo de la superclase)

        Subclase 3 (Tipo Específico): Tesis
        Atributos adicionales: autor, mesPublicacion,añoPublicacion (puedes heredarlo de la superclase)

        Subclase 4 (Tipo Específico): Diario
        Atributos adicionales: fechaPublicacion, añoPublicacion (puedes heredarlo de la superclase)

-.	Para el caso de la clase Libro, debe mantenerse toda la lógica del Ejercicio 6 de la guía anterior.
    Sin embargo, es importante tener en cuenta que las revistas cuentan con la misma lógica (incluyendo lo de cantidad de ejemplares).

    respuesta: rediseñare mi proyecto para que la superclase Publicacion implemente la logica de la clase libro (ejercicio 6), a modo que Libro y Revista puedan
    heredar esta logica.

-.	Generar una clase que utilice este modelo y realice algunos préstamos.


 */
public class Main {
    public static void main(String[] args) {
        Libro l1 = new Libro("0001", "Mi primer libro");
        l1.setAutor("Autor 1");
        l1.setPaginas(200);
        l1.setAutor("Autor 2");
        l1.setAutor("Autor 3");
        l1.setAutor("Autor 4");
        l1.setCantidadEjemplares(10);
        System.out.println(l1);

        Biblioteca bi = new Biblioteca();
        bi.addLibro(l1);
        // -- segundo libro
        Libro l2 = new Libro("0002", "Mi segundo libro");
        l2.setAutor("Autor 1");
        l2.setPaginas(100);
        l2.setAutor("Autor 2");
        l2.setAutor("Autor 3");
        l2.setCantidadEjemplares(1);
        System.out.println(l2);
        bi.addLibro(l2);

        if (l1.getPaginas() > l2.getPaginas()){
            System.out.println("El libro 1 tiene mayor cantidad de paginas que el libro 2");
        }else {
            if (l1.getPaginas() < l2.getPaginas()) {
                System.out.println("El libro 2 tiene mayor cantidad de paginas que el libro 1");
            } else {
                System.out.println("Igual cantidad de paginas.");
            }
        }

        Socio socio1 = new Socio(143, "Roberto", "Garcia", "453563");
        Socio socio2 = new Socio(654, "Roberto", "Ramirez", "653423");
        bi.addSocio(socio1);
        bi.addSocio(socio2);

        l1.prestarEjemplar(socio1);
        l1.prestarEjemplar(socio2);
        System.out.println("Prestados : " + bi.countPrestados());
        bi.ejemplaresDisponibles();
        bi.mostrarEjemplaresEnPrestamo();
    }
}