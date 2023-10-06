package ar.edu.unlu.poo.agenciaTurismo;

import ar.edu.unlu.poo.paquete.Destino;
import ar.edu.unlu.poo.paquete.Excursion;
import ar.edu.unlu.poo.paquete.Hospedaje;
import ar.edu.unlu.poo.paquete.MedioTransporte;

import java.util.List;

public class Paquete {
    private static int contadorid = 1;
    private Integer id;
    private Destino destino;
    private MedioTransporte transporte;
    private Hospedaje hospedaje;
    private List<Excursion> excursionList;
    private double precio = 0;

    public Paquete(Destino destino, MedioTransporte transporte, Hospedaje hospedaje, List<Excursion> excursionList) {
        this.destino = destino;
        this.transporte = transporte;
        this.hospedaje = hospedaje;
        this.excursionList = excursionList;
        this.id = contadorid++;
    }

    public Destino getDestino() {
        return destino;
    }

    public MedioTransporte getTransporte() {
        return transporte;
    }

    public Hospedaje getHospedaje() {
        return hospedaje;
    }

    public List<Excursion> getExcursionList() {
        return excursionList;
    }

    public Integer getId() {
        return id;
    }

    public double getPrecio(){
        double total = 0;
        for (Excursion excursion: excursionList) {
            total += excursion.getPrecio();
        }
        return transporte.getPrecio() + hospedaje.getPrecio() + total;
    }
}
