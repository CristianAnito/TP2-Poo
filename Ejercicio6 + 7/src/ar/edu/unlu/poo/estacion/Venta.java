package ar.edu.unlu.poo.estacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venta {
    private Date fecha;
    private Double importeTotal;
    private Empleado empleado;
    private Cliente cliente;
    private Expendedor expendedor;

    public Venta(Date fecha, Double importeTotal, Empleado empleado, Cliente cliente, Expendedor expendedor) {
        this.fecha = fecha;
        this.importeTotal = importeTotal;
        this.empleado = empleado;
        this.cliente = cliente;
        this.expendedor = expendedor;
    }

    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Expendedor getExpendedor() {
        return expendedor;
    }
}
