package ar.edu.unlu.poo.estacion;

public class Empleado {
    private String nombre;
    private String apellido;
    private String direccion;
    private String dni;
    private String telefono;
    private boolean descuentoAplicar;

    public Empleado(String nombre, String apellido, String direccion, String dni, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
        this.descuentoAplicar = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setDescuentoAplicar(boolean descuentoAplicar) {
        this.descuentoAplicar = descuentoAplicar;
    }

    public boolean isDescuentoAplicar() {
        return descuentoAplicar;
    }
}
