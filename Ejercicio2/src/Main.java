import ar.edu.unlu.poo.agenciaTurismo.*;
import ar.edu.unlu.poo.paquete.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Ejercicio 2: Agencia de Turismo
La agencia SunBeach decide contratar un equipo de profesionales en sistemas para encarar una solución a sus problemas de gestión a través del desarrollo de un software a medida.
SunBeach tiene proveedores en todo el mundo (compañías aéreas, marítimas y terrestres (medios de transporte), cadenas de hoteles, hosterías, búngalos (hospedajes),
y guías de turismo que ofrecen distintas excursiones).
Continuamente se comunica con los mismos y de acuerdo a las distintas ofertas disponibles diseña y arma paquetes de turismo.
Cada paquete de turismo está compuesto por 1 (un) destino, 1 (un) medio de transporte, 1 (un) hospedaje y varias (1 o más) excursiones.
Los clientes que se acercan a la agencia pueden elegir entre los distintos paquetes de turismo vigentes, los cuales abonan en efectivo.
El sistema debe permitir llevar un registro de los distintos proveedores y su clasificación (medios de transporte, hospedajes o excursiones),
los paquetes de turismo y cómo están compuestos, los clientes de la agencia y las compras que realiza cada cliente.
A fin de mes el administrador de SunBeach necesita un informe que contenga un listado de todas las ventas realizadas, organizadas por destino.
También quiere conocer cuál es el destino favorito por sus clientes.

Objetivo:
1.	Encontrar los objetos que participan del problema.
2.	Definir asociaciones entre los objetos, comportamiento y estructura de cada uno.
3.	Validar el modelo construido para garantizar que responde a los requisitos del problema.

 */
public class Main {
    public static void main(String[] args) throws ParseException {
        GestionLista gestionList = new GestionLista();

        Proveedor proveedor = new Proveedor("Autobús Atlantida", TipoProveedor.MEDIO_TRANSPORTE);
        Proveedor proveedor1 = new Proveedor("Hotel Royal", TipoProveedor.HOSPEDAJE);
        Proveedor proveedor2 = new Proveedor("Agencia de Excursion xz", TipoProveedor.EXCURSION);

        Proveedor proveedor3 = new Proveedor("Aereolinea 206", TipoProveedor.MEDIO_TRANSPORTE);
        Proveedor proveedor4 = new Proveedor("Hotel Argentina", TipoProveedor.HOSPEDAJE);
        Proveedor proveedor5 = new Proveedor("Agencia de Excursion Las palmeras", TipoProveedor.EXCURSION);

        Proveedor proveedor6 = new Proveedor("Barco ViajeSeguro", TipoProveedor.MEDIO_TRANSPORTE);
        Proveedor proveedor7 = new Proveedor("Hotel Paradyse", TipoProveedor.HOSPEDAJE);
        Proveedor proveedor8 = new Proveedor("Agencia de Excursion vuela", TipoProveedor.EXCURSION);
        gestionList.agregarProveedor(proveedor);
        gestionList.agregarProveedor(proveedor1);
        gestionList.agregarProveedor(proveedor2);
        gestionList.agregarProveedor(proveedor3);
        gestionList.agregarProveedor(proveedor4);
        gestionList.agregarProveedor(proveedor5);
        gestionList.agregarProveedor(proveedor6);
        gestionList.agregarProveedor(proveedor7);
        gestionList.agregarProveedor(proveedor8);

        MedioTransporte medioTransporte = new MedioTransporte(TipoTransporte.AEREO, proveedor3, 200.00);
        MedioTransporte medioTransporte1 = new MedioTransporte(TipoTransporte.MARINO, proveedor6, 100.00);
        MedioTransporte medioTransporte2 = new MedioTransporte(TipoTransporte.TERRESTRE, proveedor, 50.00);
        gestionList.agregarTransporte(medioTransporte);
        gestionList.agregarTransporte(medioTransporte1);
        gestionList.agregarTransporte(medioTransporte2);

        Hospedaje hospedaje = new Hospedaje("Hotel Masume", proveedor4, "3 Estrellas", 300.00);
        Hospedaje hospedaje1 = new Hospedaje("Cabaña Royal", proveedor1, "2 Estrellas", 100.00);
        Hospedaje hospedaje2 = new Hospedaje("Hotel Paradyse", proveedor7, "5 Estrellas", 1000.00);
        gestionList.agregarHospedaje(hospedaje);
        gestionList.agregarHospedaje(hospedaje1);
        gestionList.agregarHospedaje(hospedaje2);

        Excursion excursion = new Excursion("Agencia de Excursion vuela", proveedor8,  300.00);
        Excursion excursion1 = new Excursion("Agencia de Excursion Las palmeras", proveedor5,  100.00);
        Excursion excursion2 = new Excursion("Agencia de Excursion xz", proveedor2,  1000.00);
        gestionList.agregarExcursion(excursion);
        gestionList.agregarExcursion(excursion1);
        gestionList.agregarExcursion(excursion2);

        Destino destino = new Destino("París", "La ciudad del amor.");
        Destino destino1 = new Destino("Nueva York", "La ciudad que nunca duerme.");
        Destino destino2 = new Destino("Isla Tropical", "La isla de las fiestas.");
        Destino destino3 = new Destino("Kioto", "La ciudad de los templos en Japón.");
        Destino destino4 = new Destino("Machu Picchu", "Las ruinas incas en Perú.");
        gestionList.agregarDestino(destino);
        gestionList.agregarDestino(destino1);
        gestionList.agregarDestino(destino2);
        gestionList.agregarDestino(destino3);
        gestionList.agregarDestino(destino4);

        Paquete paquete1 = new Paquete(destino1, medioTransporte, hospedaje2, gestionList.getExcursionList());
        Paquete paquete2 = new Paquete(destino2, medioTransporte1, hospedaje1, gestionList.getExcursionList().subList(1,3));
        Paquete paquete3 = new Paquete(destino3, medioTransporte2, hospedaje, gestionList.getExcursionList().subList(0,1));
        gestionList.agregarPaquete(paquete1);
        gestionList.agregarPaquete(paquete2);
        gestionList.agregarPaquete(paquete3);

        Cliente cliente = new Cliente("Cristian Anito", 40869826, "75 y 20", 471359);
        Cliente cliente1 = new Cliente("Gonzalo gutierrez", 32675345, "calle yukino", 654234);
        Cliente cliente2 = new Cliente("Maria crisalida", 28564234, "avenida brasil", 876645);
        Cliente cliente3 = new Cliente("Antonella cacerez", 42564765, "Hipolito y gorostiaga", 908865);
        gestionList.agregarCliente(cliente);
        gestionList.agregarCliente(cliente1);
        gestionList.agregarCliente(cliente2);
        gestionList.agregarCliente(cliente3);

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Compra compra = new Compra(cliente, paquete1, format.parse("05-01-2023"));
        Compra compra1 = new Compra(cliente1, paquete1, format.parse("15-07-2023"));
        Compra compra2 = new Compra(cliente, paquete3, format.parse("23-08-2023"));
        Compra compra3 = new Compra(cliente, paquete1, format.parse("10-02-2023"));
        Compra compra4 = new Compra(cliente1, paquete2, format.parse("22-08-2023"));
        Compra compra5 = new Compra(cliente3, paquete2, format.parse("10-09-2023"));
        Compra compra6 = new Compra(cliente2, paquete3, format.parse("22-01-2023"));
        gestionList.agregarCompra(compra);
        gestionList.agregarCompra(compra1);
        gestionList.agregarCompra(compra2);
        gestionList.agregarCompra(compra3);
        gestionList.agregarCompra(compra4);
        gestionList.agregarCompra(compra5);
        gestionList.agregarCompra(compra6);

        //gestionList.ordenarProveedores();
        //gestionList.mostrarPaquetes();
        //gestionList.mostrarClientes();
        //gestionList.mostrarCompras();
        //gestionList.informeMensual();
        gestionList.destinoFavorito();
    }
}