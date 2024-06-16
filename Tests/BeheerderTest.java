import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.io.*;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class BeheerderTest {

    private Beheerder beheerder;
    private Scanner scanner;
    private InputStream sysInBackup;
    private ByteArrayInputStream in;

    @Before
    public void setUp() {
        sysInBackup = System.in; // Backup van originele System.in
    }

    @After
    public void tearDown() {
        System.setIn(sysInBackup); // Herstel originele System.in na elke test
    }

    @Test
    public void testVoegLandToe() {
        // Simuleer input
        String input = "Nederland\ny\n";
        scanner = new Scanner(input);
        beheerder = new Beheerder("admin", "password");

        beheerder.voegLandToe();

        List<Land> landen = BevoegdPersoon.landen;
        assertEquals(1, landen.size());
        assertEquals("Nederland", landen.get(0).naam);
        assertTrue(landen.get(0).veilig);
    }

        @Test
        public void testVoegGemeenteToe () {
            // Simuleer de input "Amsterdam\n500000\n"
            String simulatedInput = "Amsterdam\n500000\n";
            in = new ByteArrayInputStream(simulatedInput.getBytes());
            System.setIn(in);

            // Maak een nieuwe Scanner voor de gesimuleerde input
            Scanner scanner = new Scanner(System.in);
            beheerder = new Beheerder("admin", "password");

            // Voer de methode uit die je wilt testen
            beheerder.voegGemeenteToe();

            // Verkrijg de lijst van gemeentes en voer assertions uit
            List<Gemeente> gemeentes = BevoegdPersoon.gemeentes;
            assertEquals(1, gemeentes.size());
            assertEquals("Amsterdam", gemeentes.get(0).naam);
            assertEquals(500000, gemeentes.get(0).aantalInwoners);
        }

        @Test
        public void testVoegAZCToe () {
            // Voeg een gemeente toe
            Gemeente gemeente = new Gemeente("Amsterdam", 500000);
            BevoegdPersoon.gemeentes.add(gemeente);

            // Simuleer input
            String input = "Straatnaam\n123\n1234AB\n1\n";
            scanner = new Scanner(input);
            beheerder = new Beheerder("admin", "password");
            BevoegdPersoon.gemeentes.add(gemeente);

            beheerder.voegAZCToe();

            List<AZC> azcs = BevoegdPersoon.azcs;
            assertEquals(1, azcs.size());
            assertEquals("Straatnaam", azcs.get(0).adres.staartNaam);
            assertEquals(123, azcs.get(0).adres.nummer);
            assertEquals("1234AB", azcs.get(0).adres.postcode);
            assertEquals("Amsterdam", azcs.get(0).adres.gemeente.naam);
        }

        @Test
        public void testVerwijderAZC () {
            // Voeg een gemeente en AZC toe
            Gemeente gemeente = new Gemeente("Amsterdam", 500000);
            AZC azc = new AZC(new Adres("Straatnaam", 123, "1234AB", gemeente));
            BevoegdPersoon.gemeentes.add(gemeente);
            BevoegdPersoon.azcs.add(azc);

            // Simuleer input
            String input = "1\n";
            scanner = new Scanner(input);
            beheerder = new Beheerder("admin", "password");
            BevoegdPersoon.azcs.add(azc);

            beheerder.verwijderAZC();

            List<AZC> azcs = BevoegdPersoon.azcs;
            assertEquals(0, azcs.size());
        }

        @Test
        public void testWeizigLand () {
            // Voeg een land toe
            Land land = new Land("Nederland", true);
            BevoegdPersoon.landen.add(land);

            // Simuleer input
            String input = "1\nn\n";
            scanner = new Scanner(input);
            beheerder = new Beheerder("admin", "password");
            BevoegdPersoon.landen.add(land);

            beheerder.weizigLand();

            List<Land> landen = BevoegdPersoon.landen;
            assertEquals(1, landen.size());
            assertFalse(landen.get(0).veilig);
        }
    }
