import ar.edu.unlu.poo.estacion.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
Ejercicio 6: Estación de Servicio
Una estación de servicio ubicada en la ruta nacional N.°9 está diseñando un sistema de información para llevar un control de sus ventas.
La estación cuenta con varios expendedores de combustible, cada uno expende un determinado combustible (nafta, gasoil o kerosene).
Los playeros cumplen turnos de 8 hs, habiendo en todo momento personal al servicio de los clientes, ya que se trabaja 24 hs.
Cuando un cliente se presenta para cargar combustible se estaciona frente a algún expendedor, un playero lo atiende y se realiza la venta.
Al momento de cobrar el playero se dirige a alguna de las PC disponibles dentro de la playa y registra el número de patente, el tipo de combustible,
el total de la venta y quién es el vendedor o playero afectado.

El sistema debe permitir generar los siguientes informes mensuales:
1.	Listado de la proporción de ventas efectuadas para cada tipo de combustible.
2.	Listado de surtidores ordenados por monto total de ventas.
3.	Listado de surtidores ordenados por cantidad de litros expendidos.
4.	Listado de empleados ordenado por monto total de ventas.
5.	Top 10 de clientes según monto total de compras.

Mi relacion entre clase:

ModuloInformes (1) -> (*) Venta
Expendedor (1) -> (1) Combustible
Venta (1) -> (1) Expendedor
Venta (1) -> (1) Cliente
Venta (1) -> (1) Playero

Ejercicio 7
El dueño de la estación de servicio tiene nuevos requisitos:
1.	Si un cliente realiza una compra y fué parte del top 10 de clientes del mes anterior, entonces se le realiza un descuento del 5%.
2.	Si un empleado se encuentra en el top 10 de ventas realizadas en el mes anterior, se le permite hacer un descuento del 10% (por única vez) al cliente que elija.

Objetivo:
1.	Extender el diseño del ejercicio anterior e implementar nuevos requisitos.
2.	¿Qué pasa si los combustibles cambian de precio con el tiempo? En caso de que el diseño no lo soporte, proponer una solución e implementarla.

 */
public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        ModuloInformes moduloInformes = new ModuloInformes();

        Empleado empleado1 = new Empleado("Cristian", "Garcia", "75 y 14", "40854234", "471359");
        Empleado empleado2 = new Empleado("Franco", "Suarez", "81 y 22", "42654812", "476534");
        Empleado empleado3 = new Empleado("Sebastian", "Ramirez", "84 y67", "32658345", "928521");
        Empleado empleado4 = new Empleado("Camila", "Gallardo", "105 y 32", "36948592", "908701");
        Empleado empleado5 = new Empleado("Ariel", "Diaz", "Avenida corriente", "41096854", "833512");
        Empleado empleado6 = new Empleado("Nicolas", "Baez", "Ruta 5", "40438834", "267545");

        Cliente cliente1 = new Cliente("Camila", "AA 784 CD");
        Cliente cliente2 = new Cliente("Cristian", "AA 654 XC");
        Cliente cliente3 = new Cliente("Antonella", "AB 231 FG");
        Cliente cliente4 = new Cliente("Sebastian", "BC 025 JK");
        Cliente cliente5 = new Cliente("Marcos", "BB 298 GH");
        Cliente cliente6 = new Cliente("Elina", "AC 384 ER");
        Cliente cliente7 = new Cliente("Milagros", "CD 564 TW");
        Cliente cliente8 = new Cliente("Pablo", "AC 611 KP");
        Cliente cliente9 = new Cliente("Gonzalo", "AA 441 XZ");
        Cliente cliente10 = new Cliente("Ricardo", "AB 881 CD");

        Combustible combustible1 = new Combustible("Nafta", 293.433);
        Combustible combustible2 = new Combustible("Gasoil", 229.69);
        Combustible combustible3 = new Combustible("Kerosene", 340.54);

        Expendedor expendedor1 = new Expendedor(432564, combustible2);
        Expendedor expendedor2 = new Expendedor(654745, combustible3);
        Expendedor expendedor3 = new Expendedor(876967, combustible1);
        Expendedor expendedor4 = new Expendedor(987452, combustible3);

        Venta venta1 = new Venta(format.parse("01-08-2023"), 1000.0, empleado3, cliente5, expendedor3);
        Venta venta2 = new Venta(format.parse("01-08-2023"), 5000.0, empleado2, cliente6, expendedor1);
        Venta venta3 = new Venta(format.parse("02-08-2023"), 800.0, empleado3, cliente2, expendedor1);
        Venta venta4 = new Venta(format.parse("03-08-2023"), 2500.0, empleado3, cliente3, expendedor2);
        Venta venta5 = new Venta(format.parse("06-08-2023"), 7000.0, empleado4, cliente10, expendedor4);
        Venta venta6 = new Venta(format.parse("10-08-2023"), 2300.0, empleado6, cliente5, expendedor3);
        Venta venta7 = new Venta(format.parse("11-08-2023"), 3200.0, empleado5, cliente8, expendedor3);
        Venta venta8 = new Venta(format.parse("13-08-2023"), 1250.0, empleado1, cliente4, expendedor2);
        Venta venta9 = new Venta(format.parse("18-08-2023"), 800.0, empleado1, cliente2, expendedor1);
        Venta venta10 = new Venta(format.parse("20-09-2023"), 2700.0, empleado3, cliente5, expendedor4);

        moduloInformes.agregarVenta(venta1);
        moduloInformes.agregarVenta(venta2);
        moduloInformes.agregarVenta(venta3);
        moduloInformes.agregarVenta(venta4);
        moduloInformes.agregarVenta(venta5);
        moduloInformes.agregarVenta(venta6);
        moduloInformes.agregarVenta(venta7);
        moduloInformes.agregarVenta(venta8);
        moduloInformes.agregarVenta(venta9);
        moduloInformes.agregarVenta(venta10);

        //moduloInformes.mostrarInformeTop10Clientes();
        //moduloInformes.getInformeVentasXCombustible();
        //moduloInformes.getInformeVentasXExpendedor();
        //moduloInformes.getInformeLitrosXExpendedor();
        //moduloInformes.getInformeVentaXEmpleado();

        //Venta venta11 = new Venta(format.parse("21-09-2023"), 1850.0, empleado3, cliente1, expendedor4);
        //moduloInformes.verificarSiAplicaDescuento(venta11);
        //moduloInformes.verificarSiEmpleadoDescuento();

        // Supongamos que un empleado selecciona a un cliente
        //Empleado empleadoSeleccionado = moduloInformes.getInformeTop10Ventas().get(2).getEmpleado();

        // Supongamos que un empleado selecciona a un cliente (cuando se realiza la venta) y calcula el descuento
        //Venta venta11 = new Venta(format.parse("21-09-2023"), 1850.0, empleadoSeleccionado, cliente1, expendedor4);
        //moduloInformes.aplicarDescuento(venta11);
        //moduloInformes.actualizarPrecioCombustible(combustible2, 270.80);

    }
}