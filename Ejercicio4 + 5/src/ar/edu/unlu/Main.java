package ar.edu.unlu;

import ar.edu.unlu.billeteraVirtual.Usuario;
import ar.edu.unlu.cuenta.CuentaNormal;
import ar.edu.unlu.cuenta.CuentaCredito;

public class Main {
    public static void main(String[] args){

        CuentaNormal cn = new CuentaNormal(1800, 2000);
        CuentaCredito cc = new CuentaCredito(2000);
        Usuario usuario = new Usuario(cn, cc);

        usuario.mostrarEstado();
        usuario.realizarGasto(200);
    }
}
