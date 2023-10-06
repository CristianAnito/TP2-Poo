package ar.edu.unlu.poo.pasajero;

import ar.edu.unlu.poo.persona.Persona;

import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private String numeroVuelo;
    private String destino;
    private List<Persona> miembrosDelVuelo;

    public Vuelo(String numeroVuelo, String destino) {
        this.numeroVuelo = numeroVuelo;
        this.miembrosDelVuelo = new ArrayList<>();
        this.destino = destino;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void agregarMiembroDelVuelo(Persona persona) {
        miembrosDelVuelo.add(persona);
    }

    public List<Persona> getMiembrosDelVuelo() {
        return miembrosDelVuelo;
    }

    public String getDestino() {
        return destino;
    }
}
