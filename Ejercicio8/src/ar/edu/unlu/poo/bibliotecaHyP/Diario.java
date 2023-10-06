package ar.edu.unlu.poo.bibliotecaHyP;

import java.util.Date;

public class Diario extends Publicacion{
    private Date fecha;

    public Diario(Date fecha, String editor, String anioPublicacion, String telefonoProveedor, String nombre, Integer paginas, Integer cantidadEjemplares) {
        super(editor, anioPublicacion, telefonoProveedor, nombre, paginas, cantidadEjemplares);
        this.setFecha(fecha);
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }
}
