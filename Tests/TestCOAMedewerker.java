import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCOAMedewerker {

    private COAMedewerker coaMedewerker;
    private ArrayList<Vluchteling> vluchtelingen;
    private ArrayList<Gemeente> gemeentes;

    @BeforeEach
    void setUp() {
        // Setup voor COAMedewerker
        coaMedewerker = new COAMedewerker("testGebruiker", "testWachtwoord");

        // Initiëren van vluchtelingenlijst
        vluchtelingen = new ArrayList<>();
        Land land = new Land("Nederland", true);
        Vluchteling vluchteling = new Vluchteling("Pieter", land, true);
        vluchtelingen.add(vluchteling);

        // Initiëren van gemeentelijst en AZC's
        gemeentes = new ArrayList<>();
        Gemeente gemeente = new Gemeente("Haarlem", 10);
        gemeente.naam = "Gemeente 1";
        Adres adres = new Adres("Middeweg", 25, "1876", gemeente);
        AZC azc = new AZC(adres);

        azc.adres.staartNaam = "Straat 1";
        gemeente.azcs = new ArrayList<>();
        gemeente.azcs.add(azc);
        gemeentes.add(gemeente);

        // Stel de vluchtelingen- en gemeentelijsten in (stel dat je een setter of public veld hebt)
        coaMedewerker.vluchtelingen = vluchtelingen;
        coaMedewerker.gemeentes = gemeentes;

        // Mock de scanner input voor het testen
        String input = "1\n1\n1\n";
        Scanner scanner = new Scanner(input);
        coaMedewerker.scanner = scanner;
    }

    @Test
    void testVluchtelingPlaatsen() {
        // Test de vluchtelingPlaatsen methode
        coaMedewerker.vluchtelingPlaatsen();

        // Controleer of de vluchteling is toegevoegd aan het juiste AZC
        AZC azc = gemeentes.get(0).azcs.get(0);
        assertEquals(1, azc.vluchetlingen.size());
        assertEquals("Pieter", azc.vluchetlingen.get(0).naam);
    }

    @Test
    void testVoerTaakUitCase1() {
        String input = "1\nMelle\n1\n1\n";
        Scanner scanner = new Scanner(input);
        coaMedewerker.scanner = scanner;
        Gemeente haarlem = new Gemeente("haarlem", 1000);
        Adres adres = new Adres("Riouw", 100, "2022er", haarlem);
        AZC azc = new AZC(adres);
        // Voeg een land toe om de voorwaarde te vervullen
        Beheerder.azcs.add(azc);
        Beheerder.gemeentes.add(haarlem);
        Beheerder.gemeentes.get(0).azcs.add(azc);
        coaMedewerker.landen = new ArrayList<>();
        coaMedewerker.landen.add(new Land("Nederland", true));

        // Test de voerTaakUit methode
        coaMedewerker.voerTaakUit();

        // Controleer of de juiste methode is aangeroepen (via console output of ander mechanisme)
        // Dit moet verder uitgewerkt worden afhankelijk van hoe je dit wilt controleren
    }

    @Test
    void testVoerTaakUitCase2() {
        // Mock de scanner input voor case 2
        String input = "2\n";
        Scanner scanner = new Scanner(input);
        coaMedewerker.scanner = scanner;

        // Voeg een gemeente toe om de voorwaarde te vervullen
        coaMedewerker.gemeentes = new ArrayList<>();
        coaMedewerker.gemeentes.add(new Gemeente("Gemeente 1", 1000));

        // Test de voerTaakUit methode
        coaMedewerker.voerTaakUit();

        // Controleer of de juiste methode is aangeroepen
    }

    @Test
    void testVoerTaakUitCase3() {
        // Mock de scanner input voor case 3
        String input = "3\n";
        Scanner scanner = new Scanner(input);
        coaMedewerker.scanner = scanner;

        // Voeg een vluchteling toe om de voorwaarde te vervullen
        BevoegdPersoon.vluchtelingen = new ArrayList<>();
        Land nederland = new Land("Nederland", true);
        BevoegdPersoon.vluchtelingen.add(new Vluchteling("Vluchteling 1", nederland, true));

        // Test de voerTaakUit methode
        coaMedewerker.voerTaakUit();

        // Controleer of de juiste methode is aangeroepen
    }
    @Test
    void testVoerTaakUitCase4() {
        // Mock de scanner input voor case 4
        String input = "4\n";
        Scanner scanner = new Scanner(input);
        coaMedewerker.scanner = scanner;

        // Test de voerTaakUit methode
        coaMedewerker.voerTaakUit();

        // Controleer of de methode is teruggekeerd naar inloggen
    }

}

