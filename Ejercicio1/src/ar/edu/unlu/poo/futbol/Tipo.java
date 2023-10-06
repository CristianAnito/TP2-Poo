package ar.edu.unlu.poo.futbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Tipo {
    BASICO("Basico", 50.00,
            "Entrenamientos de fútbol recreativos.",
            "Participación en partidos amistosos del club.",
            "Acceso a la cancha de fútbol para entrenar."),
    MEDIO("Intermedio", 100.00,
            "Entrenamientos más avanzados con entrenadores calificados.",
            "Participación en ligas locales o torneos internos del club.",
            "Acceso a instalaciones de entrenamiento adicionales, como gimnasio.",
            "Clases de tácticas de fútbol."),
    AVANZADO("Destacado", 200.00,
            "Acceso a todas las actividades basicas e intermedias.",
                    "Acceso exclusivo a todas las instalaciones y actividades sin restricciones.",
                    "Entrenamientos personalizados con entrenadores de élite.",
                    "Participación en torneos de alto nivel a nivel regional o nacional.",
                    "Acceso a eventos especiales, como encuentros con jugadores profesionales o exfutbolistas destacados.",
                    "Acceso a programas de desarrollo de jóvenes talentos.",
                    "Clases avanzadas de tácticas y estrategias de fútbol.");

        private final String descripcion;
        private final double monto;
        private final List<String> actividades;

    Tipo(String descripcion, double monto, String ... actividades) {
        this.descripcion = descripcion;
        this.monto = monto;
        this.actividades = new ArrayList<>();
        Collections.addAll(this.actividades, actividades);
    }

    public List<String> getActividades() {
        return actividades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMonto() {
        return monto;
    }
}
