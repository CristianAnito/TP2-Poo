import ar.edu.unlu.poo.pasajero.Ticket;
import ar.edu.unlu.poo.pasajero.Vuelo;
import ar.edu.unlu.poo.persona.Pasajero;
import ar.edu.unlu.poo.persona.Persona;
import ar.edu.unlu.poo.persona.Tripulante;
import ar.edu.unlu.poo.tripulante.ReciboSueldo;

public class Main {
    public static void main(String[] args) {

        // Crear tripulantes
        Tripulante tripulante1 = new Tripulante("John Doe", "123-456-7890", "123 Main St.","Piloto");
        Tripulante tripulante2 = new Tripulante("Alice Smith", "987-654-3210", "456 Elm St.", "Azafata");

        // Crear pasajeros
        Pasajero pasajero1 = new Pasajero("Bob Doe", "543-978-7890", "183 New St.","P12345");
        Pasajero pasajero2 = new Pasajero("Carol Zaw", "707-897-9581", "205 Lovel St.","P67890");

        // Crear recibos de sueldo para tripulantes
        ReciboSueldo reciboTripulante1 = new ReciboSueldo(5000.0);
        ReciboSueldo reciboTripulante2 = new ReciboSueldo(4500.0);

        // Crear tickets para pasajeros
        Ticket ticketPasajero1 = new Ticket("T123", 350.0);
        Ticket ticketPasajero2 = new Ticket("T456", 280.0);

        // Crear vuelos
        Vuelo vuelo1 = new Vuelo("V567", "Miami - New York");
        Vuelo vuelo2 = new Vuelo("V789", "Los Angeles - Chicago");

        // Asociaciones
        tripulante1.agregarRecibo(reciboTripulante1);
        tripulante2.agregarRecibo(reciboTripulante2);

        vuelo1.agregarMiembroDelVuelo(tripulante1);
        vuelo1.agregarMiembroDelVuelo(pasajero1);

        vuelo2.agregarMiembroDelVuelo(tripulante2);
        vuelo2.agregarMiembroDelVuelo(pasajero2);
    }
}