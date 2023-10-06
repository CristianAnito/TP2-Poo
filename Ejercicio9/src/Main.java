import ar.edu.unlu.poo.figura2Dy3D.*;

import java.util.ArrayList;
import java.util.List;

/*
Ejercicio 9
Estamos desarrollando un módulo de un software de matemática donde debemos modelar figuras geométricas en 2 y 3 dimensiones.
Toda figura geométrica tiene que saber calcular su área y debe retornarla mediante la invocación del método getArea().
Además, solo para el caso de las figuras en 3 dimensiones, tiene sentido solicitar también el volumen de la figura.

El cálculo de área para cada caso es:
1.	Dos dimensiones
    1.	Área del círculo: Pi * radio ^ 2
    2.	Área del rectángulo: base * altura
    3.	Área del cuadrado: lado * lado
    4.	Área del triángulo: base * altura / 2
2.	Tres dimensiones
    1.	Área de la esfera: 4 * Pi * radio ^ 2
    2.	Volumen de la esfera: (4/3) * Pi * radio ^ 3
    3.	Área del paralelepipedo: 2 * (arista1 * arista2 + arista1 * arista3 + arista2 * arista3)
    4.	Volumen del paralelepipedo: arista1 * arista2 * arista3
    5.	Área del cubo: 6 * arista^2
    6.	Volumen del cubo: arista^3
    7.	Área del tetraedro: (regular): arista^2 * raíz(3)
    8.	Volumen del tetraedro: (regular): arista^3 * raíz(2)/12

En todos los casos, se pide:
1.	Generar un diagrama de clases que represente adecuadamente la jerarquía planteada.
2.	Implementar los métodos de área y volumen donde corresponda y aplicar las fórmulas planteadas.
    Debo poder tener una lista de Formas y pedirles el área a todas sin importar el Subtipo. Además, de un listado de Formas en 3D tengo que poder pedirles el volumen.
3.	Generar una clase que utilice varias de las clases construidas para mostrar su funcionamiento.

 */
public class Main {
    public static void main(String[] args) {
        List<Figura> figuras = new ArrayList<>();
        List<Figura3D> figuras3D = new ArrayList<>();

        Circulo circulo = new Circulo("circulo", 4);
        Rectangulo rectangulo = new Rectangulo("rectangulo", 5, 10);
        Cuadrado cuadrado = new Cuadrado("cuadrado", 6);
        Triangulo triangulo = new Triangulo("triangulo", 2, 8);
        Esfera esfera = new Esfera("esfera", 7);
        Paralelepipedo paralelepipedo = new Paralelepipedo("paralelepipedo", 3, 5, 2);
        Cubo cubo = new Cubo("cubo", 8.5);
        Tetraedro tetraedro = new Tetraedro("tetraedro", 3.7);

        figuras.add(circulo);
        figuras.add(rectangulo);
        figuras.add(cuadrado);
        figuras.add(triangulo);
        figuras.add(esfera);
        figuras.add(paralelepipedo);
        figuras.add(cubo);
        figuras.add(tetraedro);

        figuras3D.add(esfera);
        figuras3D.add(paralelepipedo);
        figuras3D.add(cubo);
        figuras3D.add(tetraedro);

        for (Figura figura: figuras){
            System.out.println("La figura " + figura.getNombre() + ", tiene un area de: " + figura.getArea());
        }

        for (Figura3D figura: figuras3D){
            System.out.println("La figura " + figura.getNombre() + ", tiene un volumen de: " + figura.getVolumen());
        }
    }
}