package ar.edu.unlu.poo.agenciaTurismo;

import java.util.Comparator;
import java.util.List;

public class Proveedor {
    private String nombre;
    private TipoProveedor tipo;

    public Proveedor (String nombre, TipoProveedor tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoProveedor getTipo() {
        return tipo;
    }

}
