package ar.edu.unlu.poo.futbol;

import java.util.Date;

public class Suscripcion {
    private Tipo tipo;
    private Date fechaEmision;
    private Date fechaRenovacion;

    public Suscripcion(Tipo tipo, Date fechaEmision, Date fechaRenovacion){
        this.fechaEmision = fechaEmision;
        this.fechaRenovacion = fechaRenovacion;
        this.tipo = tipo;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public Date getFechaRenovacion() {
        return fechaRenovacion;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
