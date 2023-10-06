package ar.edu.unlu.poo.renta;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Alquiler> alquilerList;

    public Cliente(String nombre){
        this.nombre = nombre;
        this.alquilerList = new ArrayList<>();
    }
    public void addAlquiler(Alquiler alquiler){
        alquilerList.add(alquiler);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Alquiler> getAlquilerList() {
        return alquilerList;
    }
    public double montoTotalAlquileres(){
        double monto = 0;
        for (Alquiler alquiler: alquilerList){
            monto = monto + alquiler.calcularSaldoAPagar();
        }
        return monto;
    }
}
