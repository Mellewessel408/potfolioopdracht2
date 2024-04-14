import java.util.Scanner;

public class Menu {
    Beheerder beheerder = new Beheerder();
    COAMedewerker coaMedewerker = new COAMedewerker();

    public void beginMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Als wie wilt u inloggen: \n1. Beheerder \n2. COA-medewerker \n3. Asielzoeker");
        int keuze = scanner.nextInt();
        if (keuze == 1) {
            System.out.println("Maak uw keuze: \n1. Voeg nieuw land toe \n2. weizigen of een land veilig is \n3. Een gemeente toe voegen\n4. AZC's beheren\n5. Rapportage opvragen");
            int keuze2 = scanner.nextInt();
            if (keuze2 == 1) {
                System.out.println("Voer het land in:");
                scanner.nextLine();
                String land = scanner.nextLine();
                System.out.println("Is het land veilig (y/n)");
                String isVeilig = scanner.nextLine();
                boolean veilig = isVeilig.equals("y");
                beheerder.voegLandToe(land, veilig);
                beginMenu();
            }
            if (keuze2 == 2) {
                System.out.println("Welk land wilt u weizigen");
                int counter = 0;
                for (Land land : beheerder.landen) {
                    counter++;
                    System.out.println("[" + counter + "] " + land.naam);
                }
                int keuze3 = scanner.nextInt();
                System.out.println("Is het land nu veilig? (y/n)");
                scanner.nextLine();
                String isVeilig = scanner.nextLine();
                beheerder.landen.get(keuze3 - 1).veilig = isVeilig.equals("y");
                beginMenu();
            }
            if (keuze2 == 3) {
                System.out.println("Wat is de naam van de gemeente?");
                scanner.nextLine();
                String gemeenteNaam = scanner.nextLine();
                System.out.println("Hoeveel inwoners heeft deze gemeente?");
                int aantaInwoners = scanner.nextInt();
                beheerder.voegGemeenteToe(gemeenteNaam, aantaInwoners);
                beginMenu();
            }
            if (keuze2 == 4) {
                System.out.println("Wat wilt u doen: \n1. AZC aanmaken \n2. AZC weizigen \n3. AZC verwijderem");
                int keuze3 = scanner.nextInt();
                if (keuze3 == 1) {
                    beheerder.voegAZCToe();
                }
                if (keuze3 == 2) {

                    beheerder.weizigAZC();
                }
                if (keuze3 == 3) {
                    beheerder.verwijderAZC();
                }
                beginMenu();
            }
            if (keuze2 == 5) {
                int counter = 0;
                System.out.println("Van wellke gemeente wilt u een rapportage opvragen?");
                for (Gemeente gemeente : beheerder.gemeentes) {
                    counter++;
                    System.out.println("[" + counter + "]" + gemeente.naam);
                }
                beheerder.gemeentes.get(scanner.nextInt()).rapportage();
                beginMenu();
            }
        }
        if (keuze == 2) {
            System.out.println("Maak uw keuze: ");
            System.out.println("1. Vluchteling registreren \n2. Dossier bijwerken");
            int keuze2 = scanner.nextInt();
            if (keuze2 == 1) {
                coaMedewerker.regristreerVluchteling();
                beginMenu();
            }
            if (keuze2 == 2) {
                coaMedewerker.werkDossierBij(coaMedewerker.kiesVluchteling());
                beginMenu();
            }

        }
        if (keuze == 3) {

            System.out.println("Welke asielzoeker bent u?");
            int counter = 0;
            for (Vluchteling vluchteling : coaMedewerker.vluchtelingen) {
                counter++;
                System.out.println("[" + counter + "] " + vluchteling.naam);
            }
            int getal = scanner.nextInt() - 1;
            System.out.println("Maak uw keuze: \n1. Geregistreerde geegevens opvragen\n2. Dossier status aanvragen");
            if (coaMedewerker.vluchtelingen.get(getal).dossier.toegelatenInNederland) {
                System.out.println("3. Adres registreren");
            }
            int getal2 = scanner.nextInt();
            if (getal2 == 1) {
                coaMedewerker.vluchtelingen.get(getal).gegevensOpvragen();
                beginMenu();
            }
            if (getal2 == 2) {
                coaMedewerker.vluchtelingen.get(getal).dossier.statusDossier();
                beginMenu();
            }
            if (getal2 == 3) {
                coaMedewerker.vluchtelingen.get(getal).registreerAdres();
            }
        }
    }
}
