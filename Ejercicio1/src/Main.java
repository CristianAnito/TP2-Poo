import ar.edu.unlu.poo.futbol.Credencial;
import ar.edu.unlu.poo.futbol.Socio;
import ar.edu.unlu.poo.futbol.Suscripcion;
import ar.edu.unlu.poo.futbol.Tipo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Ejercicio 1: Club de Futbol
Un club deportivo de la ciudad de San Carlos de Bariloche nos contrata para realizar un sistema de información para la gestión de su institución.
El sistema pretende llevar un registro de socios del club. Al momento de la inscripción, el personal a cargo solicita los datos personales y de contacto,
dirección y e-mail de cada socio; generando una credencial con la cual deberá presentarse cuando quiera ingresar a las distintas instalaciones del complejo.
A principio de mes cada socio debe abonar una cuota cuyo valor depende de la suscripción que haya elegido: básica, intermedia y destacada. Dependiendo de la
suscripción adquirida tendrá acceso a solo ciertas actividades para el caso de la suscripción básica, se añaden algunas más para la suscripción intermedia,
y en el caso de la destacada tiene libre acceso a cualquier actividad que quiera realizar.

El sistema debe facilitar los siguientes reportes:
1.	Reporte mensual de nuevos socios inscriptos
2.	Listado de actividades clasificadas por suscripción (actividades accesibles con la suscripción básica, actividades accesibles con la suscripción
intermedia y aquellas que solo puede accederse con la suscripción destacada).
3.	Listado de socios clasificados por suscripción adquirida

Objetivo:
1.	Encontrar los objetos que participan del problema.
2.	Definir asociaciones entre los objetos, comportamiento y estructura de cada uno.
3.	Validar el modelo construido para garantizar que responde a los requisitos del problema.

 */
public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        List<Socio> listaSocios = new ArrayList<>();

        Suscripcion suscripcion = new Suscripcion(Tipo.BASICO, format.parse("12/07/2023"), format.parse("13/08/2023"));
        Socio socio = new Socio("Cristian", "Garcia", 25, 40869826, "75 y 10", "@gmail", 471359, suscripcion);
        listaSocios.add(socio);

        Suscripcion suscripcion1 = new Suscripcion(Tipo.MEDIO, format.parse("07/08/2023"), format.parse("10/09/2023"));
        Socio socio1 = new Socio("Belen", "Garcia", 20, 42586721, "56 y 78", "@gmail", 423543, suscripcion1);
        listaSocios.add(socio1);

        Suscripcion suscripcion2 = new Suscripcion(Tipo.AVANZADO, format.parse("13/08/2023"), format.parse("19/09/2023"));
        Socio socio2 = new Socio("Camila", "Perez", 29, 38295542, "Hipotilo y martin", "@gmail", 762346, suscripcion2);
        listaSocios.add(socio2);

        Suscripcion suscripcion3 = new Suscripcion(Tipo.BASICO, format.parse("13/09/2023"), format.parse("19/10/2023"));
        Socio socio3 = new Socio("Martina", "Baez", 53, 29857364, "10 y 1", "@gmail", 872346, suscripcion3);
        listaSocios.add(socio3);

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit){
            System.out.println("1: Reporte mensual de nuevos socios.");
            System.out.println("2: Listado de actividades.");
            System.out.println("3: Listado de socios (por suscripcion.)");
            System.out.println("0: Salir.");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    for (Socio newSocio : listaSocios) {
                        if (newSocio.getSuscripcion().getFechaEmision().after(format.parse("01/08/2023")) &&
                                newSocio.getSuscripcion().getFechaEmision().before(format.parse("31/08/2023"))){
                            System.out.println("Socio: " + newSocio.getNombre() + " " + newSocio.getApellido() + " - DNI: " + newSocio.getDocumento());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Basico: " + Tipo.BASICO.getActividades());
                    System.out.println("Intermedio: " + Tipo.MEDIO.getActividades());
                    System.out.println("Destacado: " + Tipo.AVANZADO.getActividades());
                    break;
                case 3:
                    listaSocios.sort(new Comparator<Socio>() {
                        @Override
                        public int compare(Socio o1, Socio o2) {
                            return o1.getSuscripcion().getTipo().compareTo(o2.getSuscripcion().getTipo());
                        }
                    });
                    for (Socio socioSuscTipo : listaSocios) {
                        System.out.println("Suscripcion " + socioSuscTipo.getSuscripcion().getTipo() + " \n" +
                                "-Nombre: " + socioSuscTipo.getNombre() + " " + socioSuscTipo.getApellido());
                    }
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }
}