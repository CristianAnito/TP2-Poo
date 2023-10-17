import ar.edu.unlu.poo.billeteraVirtual.Usuario;
import ar.edu.unlu.poo.cuenta.CajaAhorro;
import ar.edu.unlu.poo.cuenta.CuentaCredito;
import ar.edu.unlu.poo.cuenta.CuentaNormal;

public class Main {
    public static void main(String[] args) {
        CuentaNormal cn = new CuentaNormal(1800, 2000);
        CuentaCredito cc = new CuentaCredito(2000);
        CajaAhorro ca = new CajaAhorro(3300);
        Usuario usuario = new Usuario(cn, cc, ca);

        usuario.mostrarEstado();
        usuario.realizarGasto(200);
    }
}