package ar.edu.unlu.poo.persona;

import ar.edu.unlu.poo.tripulante.ReciboSueldo;

import java.util.ArrayList;
import java.util.List;

public class Tripulante extends Persona{
    private String cargo;
    private List<ReciboSueldo> recibos;

    public Tripulante(String nombre, String numeroDeTelefono, String direccion, String cargo) {
        super(nombre, numeroDeTelefono, direccion);
        this.cargo = cargo;
        this.recibos = new ArrayList<>();
    }
    public void agregarRecibo(ReciboSueldo reciboSueldo){
        recibos.add(reciboSueldo);
    }

    public List<ReciboSueldo> getRecibos() {
        return recibos;
    }

    public String getCargo() {
        return cargo;
    }
}
