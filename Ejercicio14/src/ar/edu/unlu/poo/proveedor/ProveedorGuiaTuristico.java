package ar.edu.unlu.poo.proveedor;

public class ProveedorGuiaTuristico extends Proveedor{
    private static final int IMPORTE_EXTRA = 90;

    public ProveedorGuiaTuristico(String nombre, String tipo, double precioBase) {
        super(nombre, tipo, precioBase);
    }
    @Override
    public double calcularImporteExtra(int clientes) {
        if (clientes > 200){
            return IMPORTE_EXTRA;
        }else return 0;
    }
}
