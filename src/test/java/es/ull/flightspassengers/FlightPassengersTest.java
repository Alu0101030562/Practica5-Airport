package es.ull.flightspassengers;

import es.ull.flights.Flight;
import es.ull.passengers.Passenger;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas para la combinacion de vuelos y pasajeros")
@Nested
public class FlightPassengersTest {
  private Flight vuelo;
  private Flight vuelo2;
  private Passenger pasajero;
  private Passenger pasajero2;
  private Passenger pasajero3;
  private Passenger pasajero4;

  @BeforeEach
  void setUp() {
    vuelo = new Flight("BA0133", 350);
    vuelo2 = new Flight("TF215", 125);
    pasajero = new Passenger("1", "Mike", "BE");
    pasajero2 = new Passenger("2", "Javier", "ES");
    pasajero3 = new Passenger("3", "Jean", "FR");
    pasajero4 = new Passenger("4", "Yoshida", "JP");
  }

  @Nested
  @DisplayName("Funciones de los vuelos")
  class FlightMethods {
    @Test
    @DisplayName("Se puede añadir pasajeros al vuelo")
    public void testAddPassenger() {
      assertAll("comprobacion de que se pueden añadir pasajeros correctamente",
        () -> assertEquals(0, vuelo.getNumberOfPassengers()),
        () -> assertTrue(vuelo.addPassenger(pasajero)),
        () -> assertEquals(1, vuelo.getNumberOfPassengers()),
        () -> assertTrue(vuelo.addPassenger(pasajero2)),
        () -> assertEquals(2, vuelo.getNumberOfPassengers())
      );
    }

    @Test
    @DisplayName("Se puede eliminar pasajeros al vuelo")
    public void testRemovePassenger() {
      assertAll("comprobacion de que se pueden eliminar pasajeros correctamente",
        () -> assertEquals(0, vuelo.getNumberOfPassengers()),
        () -> assertTrue(vuelo.addPassenger(pasajero3)),
        () -> assertEquals(1, vuelo.getNumberOfPassengers()),
        () -> assertTrue(vuelo.addPassenger(pasajero4)),
        () -> assertEquals(2, vuelo.getNumberOfPassengers()),
        () -> assertTrue(vuelo.removePassenger(pasajero3)),
        () -> assertEquals(1, vuelo.getNumberOfPassengers())
      );
    }
  }

  @Nested
  @DisplayName("Funciones de los pasajeros")
  class PassengerMethods {
    @Test
    @DisplayName("Se puede ver el vuelo al que esta asignado el pasajero")
    public void testFlightPassenger() {
      assertAll("Comprobación de que se puede visualizar el vuelo del pasajero",
        () -> assertTrue(vuelo.addPassenger(pasajero)),
        () -> assertEquals(vuelo, pasajero.getFlight()),
        () -> assertTrue(vuelo2.addPassenger(pasajero2)),
        () -> assertEquals(vuelo2, pasajero2.getFlight()),
        () -> assertTrue(vuelo2.addPassenger(pasajero3)),
        () -> assertEquals(vuelo2, pasajero3.getFlight()),
        () -> assertTrue(vuelo.addPassenger(pasajero4)),
        () -> assertEquals(vuelo, pasajero4.getFlight())
      );
    }

    @Test
    @DisplayName("Se puede cambiar el vuelo al que esta asignado el pasajero manualmente")
    public void testChangeFlightPassenger() {
      assertAll("Comprobación de que se puede cambiar el vuelo del pasajero",
        () -> assertNull(pasajero.getFlight()),
        () -> assertEquals(0, vuelo.getNumberOfPassengers()),
        () -> assertTrue(vuelo.addPassenger(pasajero)),
        () -> assertEquals(1, vuelo.getNumberOfPassengers()),
        () -> assertEquals(vuelo, pasajero.getFlight()),
        () -> pasajero.joinFlight(vuelo2),
        () -> assertEquals(vuelo2, pasajero.getFlight()),
        () -> assertEquals(0, vuelo.getNumberOfPassengers()),
        () -> assertEquals(1, vuelo2.getNumberOfPassengers())
      );
    }
  }
}
