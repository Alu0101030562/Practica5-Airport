package es.ull.passengers;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PassengersTest {
  
  @DisplayName("Informacion de pasajeros")
  @Nested
  class PasajeroTest {
    private Passenger pasajero;
    private Passenger pasajero2;
    private Passenger pasajero3;
    private Passenger pasajero4;

    @BeforeEach
    void setUp() {
      pasajero = new Passenger("1", "Mike", "BE");
      pasajero2 = new Passenger("2", "Javier", "ES");
      pasajero3 = new Passenger("3", "Jean", "FR");
      pasajero4 = new Passenger("4", "Yoshida", "JP");
    }

    @Test
    @DisplayName("Informacion del pasajero 1")
    void testPasajero() {
      assertAll("Verificacion de condiciones para el pasajero",
        () -> assertEquals("1", pasajero.getIdentifier()),
        () -> assertEquals("Mike", pasajero.getName()),
        () -> assertEquals("BE", pasajero.getCountryCode())
      );
    }

    @Test
    @DisplayName("Informacion del pasajero 2")
    void testPasajero2() {
      assertAll("Verificacion de condiciones para el pasajero",
        () -> assertEquals("2", pasajero2.getIdentifier()),
        () -> assertEquals("Javier", pasajero2.getName()),
        () -> assertEquals("ES", pasajero2.getCountryCode())
      );
    }

    @Test
    @DisplayName("Informacion del pasajero 3")
    void testPasajero3() {
      assertAll("Verificacion de condiciones para el pasajero",
        () -> assertEquals("3", pasajero3.getIdentifier()),
        () -> assertEquals("Jean", pasajero3.getName()),
        () -> assertEquals("FR", pasajero3.getCountryCode())
      );
    }

    @Test
    @DisplayName("Informacion del pasajero 4")
    void testPasajero4() {
      assertAll("Verificacion de condiciones para el pasajero",
        () -> assertEquals("4", pasajero4.getIdentifier()),
        () -> assertEquals("Yoshida", pasajero4.getName()),
        () -> assertEquals("JP", pasajero4.getCountryCode())
      ); 
    }
  }
}
