import java.util.Scanner;

public class Menu {

    BevoegdPersoon beheerder = new Beheerder("Melle", "12345");
    BevoegdPersoon coaMedewerker = new COAMedewerker("Melle123", "12345");

    public void beginMenu() {
        Scanner scanner = new Scanner(System.in);
        Inloggen inloggen = Inloggen.getInloggen();

        System.out.println("Maak een keuze:");
        System.out.println("[1] Inloggen");
        System.out.println("[2] Registreren");
        int keuze;
        while (true) {
            if (scanner.hasNextInt()) {
                keuze = scanner.nextInt();
                break;
            } else {
                System.out.println("Ongeldige invoer. Voer een geldig getal in.");
                scanner.next(); // Consumeer de ongeldige invoer
            }
        }

        switch (keuze) {
            case 1:
                System.out.println("Als wie wil je inloggen? \n[1] Beheerder \n[2] COA-medewerker\n[3] Vluchteling");
                if (scanner.hasNextInt()) {
                    int keuze3 = 0;
                    while (true) {
                        System.out.print("Voer een geldig getal in: ");
                        if (scanner.hasNextInt()) {
                            keuze3 = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Ongeldige invoer. Voer een geldig getal in.");
                            scanner.next();
                        }
                    }
                    switch (keuze3) {
                        case 1:
                            if (inloggen.beheerderInloggen()) {
                                beheerder.voerTaakUit();
                            }
                            beginMenu();
                            break;
                        case 2:
                            if (inloggen.COAMedewerkerInloggen()) {
                                coaMedewerker.voerTaakUit();
                            }
                            beginMenu();
                            break;
                        case 3:
                            if (!(BevoegdPersoon.vluchtelingen.isEmpty())) {
                                int counter = 0;
                                for (Vluchteling vluchteling : BevoegdPersoon.vluchtelingen) {
                                    counter++;
                                    System.out.println("[" + counter + "] " + vluchteling.naam);
                                }
                                if (scanner.hasNextInt()) {
                                    BevoegdPersoon.vluchtelingen.get(scanner.nextInt() - 1).voerTaakUit();
                                }
                            } else {
                                System.out.println("Er zijn geen vluchtelingen om uit te kiezen");
                            }
                            beginMenu();
                            break;

                        default:
                            System.out.println("Voer een geldige keuze in.");
                    }
                }
            case 2:
                Registreren registreren = new Registreren();
                System.out.println("Als wie wil je registreren\n[1] Beheerder\n[2] COA-medewerker");
                int getal = scanner.nextInt();
                switch (getal) {
                    case 1:
                        registreren.registreerBeheerder();
                        beginMenu();
                    case 2 :
                        registreren.registreerCAOMedewerker();
                        beginMenu();
                }

        }
        beginMenu();

    }
}
