package ar.edu.unlu.poo.proveedor;

public class ProveedorHospedaje extends Proveedor{
    private static final double IMPORTE_EXTRA = 0.005;
    private static final int CLIENTES_MIN = 10;
    public ProveedorHospedaje(String nombre, String tipo, double precioBase) {
        super(nombre, tipo, precioBase);
    }

    @Override
    public double calcularImporteExtra(int clientesMaximos) {
        if (clientesMaximos > CLIENTES_MIN){
            return (getPrecioBase() * IMPORTE_EXTRA) * (clientesMaximos - CLIENTES_MIN);
        }else return 0;
    }
}
