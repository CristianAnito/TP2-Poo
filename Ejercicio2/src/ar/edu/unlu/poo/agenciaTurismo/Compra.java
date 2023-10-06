package ar.edu.unlu.poo.agenciaTurismo;

import java.time.LocalDate;
import java.util.Date;

public class Compra {
    private Cliente cliente;
    private Paquete paquete;
    private Date fecha;

    public Compra(Cliente cliente, Paquete paquete, Date fecha) {
        this.cliente = cliente;
        this.paquete = paquete;
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public Date getFecha() {
        return fecha;
    }
}
