package es.ull.flights;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FlightsTest {

  @DisplayName("Informacion de vuelos")
  @Nested
  class VueloTest {
    private Flight vuelo;
    private Flight vuelo2;
    private Flight vuelo3;
    private Flight vuelo4;

    @BeforeEach
    void setUp() {
      vuelo = new Flight("BA0133", 350);
      vuelo2 = new Flight("TF215", 125);
      vuelo3 = new Flight("GC0012", 68);
      vuelo4 = new Flight("JA950", 230);
    }

    @Test
    @DisplayName("Informacion del vuelo 1")
    void testVuelo() {
      assertAll("Verificacion de condiciones para el vuelo",
        () -> assertEquals("BA0133", vuelo.getFlightNumber()),
        () -> assertEquals(0, vuelo.getNumberOfPassengers())
      );
    }

    @Test
    @DisplayName("Informacion del vuelo 2")
    void testVuelo2() {
      assertAll("Verificacion de condiciones para el vuelo",
        () -> assertEquals("TF215", vuelo2.getFlightNumber()),
        () -> assertEquals(0, vuelo2.getNumberOfPassengers())
      );
    }

    @Test
    @DisplayName("Informacion del vuelo 3")
    void testVuelo3() {
      assertAll("Verificacion de condiciones para el vuelo",
        () -> assertEquals("GC0012", vuelo3.getFlightNumber()),
        () -> assertEquals(0, vuelo3.getNumberOfPassengers())
      );
    }

    @Test
    @DisplayName("Informacion del vuelo 4")
    void testVuelo4() {
      assertAll("Verificacion de condiciones para el vuelo",
        () -> assertEquals("JA950", vuelo4.getFlightNumber()),
        () -> assertEquals(0, vuelo4.getNumberOfPassengers())
      );
    }
  }
}
