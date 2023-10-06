/*
Ejercicio 10
Una organización mantiene su lista de empleados, donde tiene los siguientes tipos identificados:
•	Empleado asalariado o full-time: Empleado que tiene una relación laboral de tiempo completo con la organización
•	Empleado por comisión: Son empleados que trabajan y cobran porcentaje por el bruto de las ventas. Se estipula de antemano,
    pero su sueldo se calcula según el monto total de ventas y el porcentaje estipulado.
•	Empleados por comisión con salario base: son empleados que tienen trabajo por comisión, pero su salario tiene una suma fija.
•	Empleados por hora: Cobran un monto fijo por hora que se multiplica a la cantidad de horas que tienen estipulada por contrato.
Todo empleado tiene un nombre, apellido, teléfono y CUIT.
Cada empleado debe responder al mensaje de calcularSueldo, teniendo en cuenta las siguientes reglas:
•	Los empleados asalariados tienen una suma fija mensual.
•	Los empleados por comisión tienen una cantidad de ventas que realizaron y un porcentaje fijo por el bruto de esas ventas.
•	Los empleados por comisión con salario base, son similares a los empleados por comisión, pero además tienen un monto fijo de base.
•	Los empleados por hora cobran por una cantidad de horas fijas de antemano, una suma estipulada por hora.
Se tiene un proceso que desea obtener, para cada tipo de empleado, el sueldo correspondiente al mes en curso a partir de los atributos mencionados.
Se le solicita:
4.	Existe un tipo de empleado que es pasante, y cuyo sueldo no depende de la organización. En dichos casos, el cálculo de sueldo debe dar cero.
    Agregar este tipo a la jerarquía y, desarrolle el cálculo de sueldo.
5.	En el caso de empleado por hora, aparece un nuevo convenio que estipula que, en caso de trabajar más de 40 horas en ese mes, el sueldo se calcula igual,
    pero con un extra a favor del empleado del 20 por ciento. Agregar esta lógica al desarrollo que haya realizado.
6.	La organización decide darle un premio por cumpleaños a cada empleado. Entonces le solicita que se pueda registrar dicho dato en el sistema,
    y que para el mes del cumpleaños se le agregue el bono correspondiente. Se le solicita desarrollar la funcionalidad teniendo en cuenta que los extras
    por cumpleaños se manejan de la manera que se explica a continuación:
	   - Cualquier empleado cobra $2000 por su cumpleaños.
	   - Si es empleado asalariado, además, cobrará $1000 extra por cumpleaños.
	   - Si es empleado por comisión, cobrará el 0.5 % del bruto de ventas.
	   - Si es empleado por comisión con salario base, cobrará $1000 extra más el 0.5 % del bruto de ventas.
	   - Los empleados por hora no cobran nada extra sobre los $2000.


 */
import ar.edu.unlu.poo.organizacion.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("Cristian", "Garcia", "487236", "20-45928372-0", format.parse("13-01-2003"), 120000);
        EmpleadoComision empleadoComision = new EmpleadoComision("Antonella", "Caceres", "325423", "22-29536121-2", format.parse("22-09-1987"), 10000, 5);
        EmpleadoComisionSalarioBase empleadoComisionSalarioBase = new EmpleadoComisionSalarioBase("Sebastian", "Juarez", "235653", "23-42563498-7", format.parse("12-05-2000"),15000, 5, 70000);
        EmpleadoHora empleadoHora = new EmpleadoHora("Angeles", "Ojeda", "345667", "27-39674512-0", format.parse("30-10-1995"), 45, 1020);
        Pasante pasante = new Pasante("Laura", "Martinez", "987654", "65-43232198-7", format.parse("17-07-2002"));

        System.out.println("El empleado: " + empleadoAsalariado.getNombre() + " "+ empleadoAsalariado.getApellido() + ", tiene un sueldo de: " + empleadoAsalariado.calcularSueldo());
        System.out.println("El empleado: " + empleadoComision.getNombre() + " "+ empleadoComision.getApellido() + ", tiene un sueldo de: " + empleadoComision.calcularSueldo());
        System.out.println("El empleado: " + empleadoComisionSalarioBase.getNombre() + " "+ empleadoComisionSalarioBase.getApellido() + ", tiene un sueldo de: " + empleadoComisionSalarioBase.calcularSueldo());
        System.out.println("El empleado: " + empleadoHora.getNombre() + " "+ empleadoHora.getApellido() + ", tiene un sueldo de: " + empleadoHora.calcularSueldo());
        System.out.println("El pasante: " + pasante.getNombre() + " "+ pasante.getApellido() + ", tiene un sueldo de: " + pasante.calcularSueldo());
    }
}