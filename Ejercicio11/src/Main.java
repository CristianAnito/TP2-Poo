import ar.edu.unlu.poo.renta.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/*
Ejercicio 11
Una empresa de renta de automóviles necesita un sistema para realizar presupuestos de alquiler a clientes de forma rápida.
Las reglas para calcular el costo de alquilar un vehículo varían según diversas características.
Los vehículos se identifican unívocamente por su patente (El sistema no puede tener una misma patente en más de un vehículo).
Al momento, los tipos de vehículos que se alquilan son autos de pasajeros, combis, camionetas de tipo “flete” y camión de carga.

Todo vehículo tiene un precio base de alquiler diario de $3000 pesos. Luego, existen algunas particularidades que se adicionan al precio base según algunas reglas:
•	En cada auto de pasajero, se suman $300 pesos por cada asiento por día. Ejemplo, existen autos de 4 asientos, pero hay otros de 2 y otros de 5.
•	En el caso de autos de tipo VIP, la plaza es de $500 pesos.
•	Para el caso de las combis, el precio base se modifica en $4500.
•	Para las camionetas tipo flete, se adicionan $600 pesos por un valor conocido como * Peso Autorizado Total (PAT). Este adicional es entonces $600 * PAT de cada camioneta.
•	Los camiones no tienen el precio base, sino que tienen un costo fijo de alquiler de $100000 (cien mil), salvo que se alquilen más de 30 días,
    cuyo precio base diario es de $75000.

Además, se quiere modelar los clientes. Un cliente es alguien que solicita un presupuesto, pero que finalmente puede realizar un alquiler.
Un alquiler vincula un presupuesto con un cliente. Además, el alquiler puede establecer fechas de inicio y fin y generar el saldo a pagar.
Por otro lado, el sistema NO DEBE realizar gestión de pagos.

Dado todo esto, el sistema de la agencia debe poder:
1.	Registrar los vehículos y poder prestarlos. No debe permitirse que dos vehículos se registren con la misma patente.
2.	Emitir un presupuesto. Un presupuesto consta de un vehículo específico y una cantidad de días de alquiler. Debe valorarse el monto final.
3.	De un presupuesto debe poder generarse un alquiler.
4.	De un cliente, mostrar el monto total de todos los alquileres realizados.
5.	El monto total de todos los alquileres generados por el sistema.

 */
public class Main {
    public static void main(String[] args) throws ParseException {
        SistemaAgencia sistemaAgencia = new SistemaAgencia();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        AutoDePasajero autoDePasajero = new AutoDePasajero("AB 958 ZX", 4);
        CamionetaFlete camionetaFlete = new CamionetaFlete("BB 472 CG", 2); //peso en toneladas
        Combi combi = new Combi("AA 213 AJ");
        CamionCarga camionCarga = new CamionCarga("BC 877 AA");

        sistemaAgencia.registrarVehiculo(autoDePasajero);
        sistemaAgencia.registrarVehiculo(camionetaFlete);
        sistemaAgencia.registrarVehiculo(combi);
        sistemaAgencia.registrarVehiculo(camionCarga);

        Cliente cliente1 = new Cliente("Cristian");
        Cliente cliente2 = new Cliente("Gonzalo");

        sistemaAgencia.registrarCliente(cliente1);
        sistemaAgencia.registrarCliente(cliente2);

        Presupuesto presupuesto = sistemaAgencia.emitirPresupuesto(autoDePasajero, 8);
        Alquiler alquiler = sistemaAgencia.generarAlquiler(cliente1, presupuesto, format.parse("15-08-2023"), format.parse("23-08-2023"));
        cliente1.addAlquiler(alquiler);

        Presupuesto presupuesto1 = sistemaAgencia.emitirPresupuesto(combi, 5);
        Alquiler alquiler1 = sistemaAgencia.generarAlquiler(cliente1, presupuesto1, format.parse("15-09-2023"), format.parse("20-09-2023"));
        cliente1.addAlquiler(alquiler1);

        Presupuesto presupuesto2 = sistemaAgencia.emitirPresupuesto(camionCarga, 20);
        Alquiler alquiler2 = sistemaAgencia.generarAlquiler(cliente2, presupuesto2, format.parse("02-09-2023"), format.parse("22-09-2023"));
        cliente2.addAlquiler(alquiler2);

        double montoCliente = sistemaAgencia.montoTotalAlquileresCliente(cliente1);
        System.out.println("El monto total de alquileres del cliente: " + cliente1.getNombre() + " es de: " + montoCliente);

        double montoAlquileres = sistemaAgencia.montoTotalAlquileres();
        System.out.println("El monto total de alquileres es de: " + montoAlquileres);
    }
}