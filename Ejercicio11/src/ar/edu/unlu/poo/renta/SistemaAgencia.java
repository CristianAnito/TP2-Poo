package ar.edu.unlu.poo.renta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SistemaAgencia {
    List<Cliente> clienteList = new ArrayList<>();
    List<Automovil> automovilList = new ArrayList<>();
    public void registrarVehiculo(Automovil automovil){
        for (Automovil auto: automovilList){
            if (auto.getPatente().equals(automovil.getPatente())){
                System.out.println("Patente " + automovil.getPatente() + " ya registrada.");
            }else automovilList.add(automovil);
        }
    }
    public void registrarCliente(Cliente cliente){
        clienteList.add(cliente);
    }
    public Presupuesto emitirPresupuesto(Automovil automovil, int dias){
        return new Presupuesto(automovil, dias);
    }
    public Alquiler generarAlquiler(Cliente cliente, Presupuesto presupuesto, Date fechaInicio, Date fechaFin){
        return new Alquiler(cliente, presupuesto, fechaInicio, fechaFin);
    }
    public double montoTotalAlquileresCliente(Cliente cliente){
        return cliente.montoTotalAlquileres();
    }
    public double montoTotalAlquileres(){
        double montoTotal = 0;
        for (Cliente cliente: clienteList){
            montoTotal = montoTotal + cliente.montoTotalAlquileres();
        }
        return montoTotal;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public List<Automovil> getAutomovilList() {
        return automovilList;
    }
}
