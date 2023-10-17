package ar.edu.unlu.poo.proveedor;

public class ProveedorTransporte extends Proveedor{
    private static final double IMPORTE_EXTRA = 0.003;
    public ProveedorTransporte(String nombre, String tipo, double precioBase) {
        super(nombre, tipo, precioBase);
    }
    @Override
    public double calcularImporteExtra(int cantClientes) {
        return cantClientes * (IMPORTE_EXTRA * getPrecioBase());
    }
}
