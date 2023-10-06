package ar.edu.unlu.poo.persona;

import ar.edu.unlu.poo.pasajero.Ticket;

public class Pasajero extends Persona{
    private String idDePasajero;
    public Pasajero(String nombre, String numeroDeTelefono, String direccion, String idDePasajero) {
        super(nombre, numeroDeTelefono, direccion);
        this.idDePasajero = idDePasajero;
    }

    public String getidDePasajero() {
        return idDePasajero;
    }

}
