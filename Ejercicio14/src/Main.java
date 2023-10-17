import ar.edu.unlu.poo.proveedor.ProveedorGuiaTuristico;
import ar.edu.unlu.poo.proveedor.ProveedorHospedaje;
import ar.edu.unlu.poo.proveedor.ProveedorTransporte;
import ar.edu.unlu.poo.sistemaSB.SistemaDeGestion;
import ar.edu.unlu.poo.venta.Cliente;
import ar.edu.unlu.poo.venta.PaqueteTurismo;
import ar.edu.unlu.poo.venta.Venta;

public class Main {
    public static void main(String[] args) {
        SistemaDeGestion sistemaDeGestion = new SistemaDeGestion();

        Cliente cliente1 = new Cliente("1", "Juan", "Pérez", "+1234567890");
        Cliente cliente2 = new Cliente("2", "Ana", "García", "+9876543210");
        Cliente cliente3 = new Cliente("3", "Carlos", "Rodríguez", "+5551234567");
        Cliente cliente4 = new Cliente("4", "María", "López", "+4449998888");
        Cliente cliente5 = new Cliente("5", "Pedro", "Martínez", "+7773332222");

        ProveedorHospedaje proveedorHospedaje1 = new ProveedorHospedaje("Hotel A", "Hospedaje", 150.0);
        ProveedorHospedaje proveedorHospedaje2 = new ProveedorHospedaje("Hostal B", "Hospedaje", 80.0);
        ProveedorHospedaje proveedorHospedaje3 = new ProveedorHospedaje("Cabañas C", "Hospedaje", 120.0);

        ProveedorGuiaTuristico proveedorGuia1 = new ProveedorGuiaTuristico("Guía Juan", "GuiaTuristico", 50.0);
        ProveedorGuiaTuristico proveedorGuia2 = new ProveedorGuiaTuristico("Guía Ana", "GuiaTuristico", 40.0);
        ProveedorGuiaTuristico proveedorGuia3 = new ProveedorGuiaTuristico("Guía Carlos", "GuiaTuristico", 60.0);

        ProveedorTransporte proveedorTransporte1 = new ProveedorTransporte("Aerolínea X", "Transporte", 200.0);
        ProveedorTransporte proveedorTransporte2 = new ProveedorTransporte("Autobuses Y", "Transporte", 80.0);
        ProveedorTransporte proveedorTransporte3 = new ProveedorTransporte("Navegación Z", "Transporte", 150.0);

        PaqueteTurismo paquete1 = new PaqueteTurismo("P1", "Playa Paradisíaca", 50);
        PaqueteTurismo paquete2 = new PaqueteTurismo("P2", "Montañas Verdes", 30);
        PaqueteTurismo paquete3 = new PaqueteTurismo("P3", "Ciudad Cultural", 40);
        paquete1.agregarProveedor(proveedorHospedaje2);
        paquete1.agregarProveedor(proveedorGuia3);
        paquete1.agregarProveedor(proveedorTransporte1);

        paquete2.agregarProveedor(proveedorHospedaje1);
        paquete2.agregarProveedor(proveedorGuia1);
        paquete2.agregarProveedor(proveedorTransporte2);

        paquete3.agregarProveedor(proveedorHospedaje3);
        paquete3.agregarProveedor(proveedorGuia2);
        paquete3.agregarProveedor(proveedorTransporte3);

        Venta venta1 = new Venta("V1", paquete2, cliente4);
        Venta venta2 = new Venta("V2", paquete1, cliente1);
        Venta venta3 = new Venta("V3", paquete3, cliente5);
        Venta venta4 = new Venta("V4", paquete2, cliente1);

        sistemaDeGestion.registrarVenta(venta1);
        sistemaDeGestion.registrarVenta(venta2);
        sistemaDeGestion.registrarVenta(venta3);
        sistemaDeGestion.registrarVenta(venta4);

        sistemaDeGestion.generearInformeVentasPorDestino();
    }
}