import ar.edu.unlu.poo.danza.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
Ejercicio 3: Academia de Danzas
Una famosa academia de Capital Federal decide contratar a una consultora informática para desarrollar un sistema de información que le permita llevar un control
de su gestión administrativa.

La academia dicta distintas disciplinas, de las cuales pueden existir una o más diagramaciones o comisiones. Por ejemplo, para la disciplina "Tango" existe una
diagramación que se dicta los días lunes y viernes, siendo de un nivel inicial o para principiantes. A su vez, existe otra diagramación para la disciplina "Tango"
que se dicta los martes y sábados, y el nivel es intermedio. Por tanto, una diagramación deberá contar con los siguientes datos: día y horario, nivel (inicial, intermedio o avanzado),
disciplina (ej. Tango, Salsa, Bachata, Clásico, Stretching, Contemporáneo, Árabe, etc.) y un profesor encargado de dictar la clase.
Las clases o diagramaciones tienen lugar en alguno de los distintos salones que tiene la academia.
La academia cuenta con más de 500 alumnos, los cuales se inscriben a distintas clases o diagramaciones.
Cuando una persona se presenta por primera vez la secretaria toma sus datos personales y de contacto y lo inscribe a una determina diagramación y le entrega una credencial
personal que deberá traer al momento de asistir a clases.
En cada clase, los alumnos deben presentar su credencial en la secretaría, donde la secretaria procede registrar su asistencia.

-Mes a mes la academia debe entregar a los profesores un listado de todos los alumnos que asistieron a sus clases a fin de calcular el importe que se le pagará al profesor
(cada profesor cobra $10 por cada día que un alumno asiste a su clase).
-La academia necesita contar con un reporte que indique cuál es la disciplina que le reditúa mayor ingreso a fin de planificar más diagramaciones de dicha disciplina.

Objetivo:
1.	Encontrar los objetos que participan del problema.
2.	Definir asociaciones entre los objetos, comportamiento y estructura de cada uno.
3.	Validar el modelo construido para garantizar que responde a los requisitos del problema.

 */
public class Main {
    public static void main(String[] args) throws ParseException {
        Disciplina disciplina1 = new Disciplina("Tango", "12 semanas", true);
        Disciplina disciplina2 = new Disciplina("Salsa", "15 semanas", true);
        Disciplina disciplina3 = new Disciplina("Bachata", "12 semanas", false);
        Disciplina disciplina4 = new Disciplina("Stretching", "10 semanas", true);

        Comision comision = new Comision(10, "Martes y jueves", "09:00am a 12:00pm", Nivel.INTERMEDIO, disciplina1, 304, "Rafael castillos");
        Comision comision1 = new Comision(6, "Sabado", "08:00am a 14:00pm", Nivel.INICIAL, disciplina1, 210, "Sara garcia");

        Comision comision2 = new Comision(5, "Lunes y Viernes", "09:00am a 12:00pm", Nivel.INICIAL, disciplina2, 105, "Greciela Sosa");

        Comision comision3 = new Comision(1, "Lunes y Miercoles", "14:30am a 17:00pm", Nivel.AVANZADO, disciplina3, 110, "Rafael castillos");
        Comision comision4 = new Comision(5, "Jueves y Viernes", "14:30am a 17:00pm", Nivel.INTERMEDIO, disciplina3, 200, "Stella Maris");

        Comision comision5 = new Comision(3, "Martes y Miercoles", "11:00am a 13:00pm", Nivel.AVANZADO, disciplina4, 105, "Cristian Garcia");

        Alumno alumno = new Alumno("Cristian Anito", 25, 40869826, "75 y 10", 471359);
        Alumno alumno1 = new Alumno("Belen Gonzales", 20, 43543234, "106 y 31", 543123);
        Alumno alumno2 = new Alumno("Carolina Juarez", 27, 39876451, "Avenida Cabildo", 765345);
        Alumno alumno3 = new Alumno("Tomas Reinoso", 18, 45896718, "Ruta 4", 765098);
        Alumno alumno4 = new Alumno("Antonella Caceres", 25, 40865426, "97 y 10", 723486);

        Credencial credencial = new Credencial(453234, alumno1, comision5);
        Credencial credencial1 = new Credencial(198434, alumno, comision5);
        Credencial credencial2 = new Credencial(987345, alumno2, comision5);
        Credencial credencial3 = new Credencial(324654, alumno3, comision5);
        Credencial credencial4 = new Credencial(786546, alumno4, comision5);

        Credencial credencial5 = new Credencial(543465, alumno1, comision1);

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Asistencia asisentes = new Asistencia(comision5, format.parse("01-08-2023"));
        asisentes.registrarAsistencia(credencial);
        asisentes.registrarAsistencia(credencial2);
        asisentes.registrarAsistencia(credencial3);
        asisentes.registrarAsistencia(credencial4);

        Asistencia asisentes1 = new Asistencia(comision5, format.parse("02-08-2023"));
        asisentes1.registrarAsistencia(credencial);
        asisentes1.registrarAsistencia(credencial2);
        asisentes1.registrarAsistencia(credencial4);

        Asistencia asisentes2 = new Asistencia(comision5, format.parse("08-08-2023"));
        asisentes2.registrarAsistencia(credencial);
        asisentes2.registrarAsistencia(credencial1);
        asisentes2.registrarAsistencia(credencial2);
        asisentes2.registrarAsistencia(credencial3);
        asisentes2.registrarAsistencia(credencial4);

        Academia academia = new Academia();
        academia.agregarAsistencias(asisentes);
        academia.agregarAsistencias(asisentes1);
        academia.agregarAsistencias(asisentes2);

        SimpleDateFormat formatMensual = new SimpleDateFormat("MM-yyyy");
        academia.generarListadoMensual(formatMensual.parse("08-2023"));
        academia.calcularPago();
        academia.disciplinaFavorita();
    }
}