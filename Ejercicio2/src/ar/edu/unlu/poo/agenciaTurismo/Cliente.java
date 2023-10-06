package ar.edu.unlu.poo.agenciaTurismo;

import java.util.List;

public class Cliente {
    private String nombreYapellido;
    private int documento;
    private String direccion;
    private int telefono;

    public Cliente(String nombreYapellido, int documento, String direccion, int telefono) {
        this.nombreYapellido = nombreYapellido;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombreYapellido() {
        return nombreYapellido;
    }

    public int getDocumento() {
        return documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }
}
