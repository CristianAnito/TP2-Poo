package ar.edu.unlu.poo.danza;

import java.text.SimpleDateFormat;
import java.util.*;

public class Academia {
    private List<Asistencia> asistencias;

    public Academia(){
        this.asistencias = new ArrayList<>();
    }

    public void agregarAsistencias(Asistencia asistenciaDiaria){
        asistencias.add(asistenciaDiaria);
    }

    public void ordenarListaAsistencias(){
        // Ordenar la lista de clases por comisión
        Collections.sort(asistencias, new Comparator<Asistencia>() {
            @Override
            public int compare(Asistencia clase1, Asistencia clase2) {
                return clase1.getComision().getNumero().compareTo(clase2.getComision().getNumero());
            }
        });
    }

    public void generarListadoMensual(Date fechaMes) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat mesAnioFormat = new SimpleDateFormat("MM-yyyy");
        System.out.println("Listado de asistencia para " + mesAnioFormat.format(fechaMes) + ":");

        ordenarListaAsistencias();
        for (Asistencia clase : asistencias) {
            

            // Obtener el mes y el año de ambas fechas
            int mesFecha = clase.getFecha().getMonth() + 1; // Se suma 1 porque enero es 0
            int anioFecha = clase.getFecha().getYear() + 1900; // Se suma 1900 porque el valor base es 1900

            int mesReferencia = fechaMes.getMonth() + 1;
            int anioReferencia = fechaMes.getYear() + 1900;

            if (mesFecha == mesReferencia && anioFecha == anioReferencia) {
                System.out.println("Disciplina: " + clase.getComision().getDisciplina().getNombre() + " Dia: " + dateFormat.format(clase.getFecha()));

                //Imprime la lista de alumnos que se presentaron
                List<Alumno> alumnosPresentes = clase.getAlumnosPresentes();
                for (Alumno alumno : alumnosPresentes) {
                    System.out.println("- " + alumno.getNombreYapellido());
                }
            }
        }
    }

    public void calcularPago(){
        ordenarListaAsistencias();
        Map<Comision, Integer> comisionIntegerMap = new HashMap<>();

        // Recorrer la lista de compras y actualizar el mapa
        for (Asistencia clase : asistencias) {
            Comision comisionConcurrida = clase.getComision();
            comisionIntegerMap.put(comisionConcurrida, comisionIntegerMap.getOrDefault(comisionConcurrida, 0) + 1);
        }

        Comision comision = null;

        //Map.Entry es una interfaz que representa una entrada (o par clave-valor) en un mapa.
        //comisionIntegerMap.entrySet() para obtener un conjunto de todas las entradas del mapa.
        for (Map.Entry<Comision, Integer> entry : comisionIntegerMap.entrySet()) {
            comision = entry.getKey();
            System.out.println("Comision: " + comision.getNumero() + " Profesor: " + comision.getProfesor() + " Pago: " + (entry.getValue() * 10) + "$");
        }
    }

    public void disciplinaFavorita(){
        ordenarListaAsistencias();
        Map<Disciplina, Integer> disciplinaIntegerMap = new HashMap<>();

        // Recorrer la lista de compras y actualizar el mapa
        for (Asistencia clase : asistencias) {
            Disciplina disciplinaConcurrida = clase.getComision().getDisciplina();
            disciplinaIntegerMap.put(disciplinaConcurrida, disciplinaIntegerMap.getOrDefault(disciplinaConcurrida, 0) + 1);
        }

        // Encontrar la disciplina favorita
        Disciplina disciplinaFav = null;
        int disciplinaMax = 0;

        //Map.Entry es una interfaz que representa una entrada (o par clave-valor) en un mapa.
        //disciplinaIntegerMap.entrySet() para obtener un conjunto de todas las entradas del mapa.
        for (Map.Entry<Disciplina, Integer> entry : disciplinaIntegerMap.entrySet()) {

            if (entry.getValue() > disciplinaMax) {
                disciplinaMax = entry.getValue();
                disciplinaFav = entry.getKey();
            }
        }

        if (disciplinaFav != null) {
            System.out.println("La disciplina que genera mayor ingreso es : " + disciplinaFav.getNombre());
        } else {
            System.out.println("No hay suficientes datos para determinar una disciplina favorita.");
        }
    }
}
