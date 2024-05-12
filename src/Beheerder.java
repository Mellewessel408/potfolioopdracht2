import java.util.Scanner;

public class Beheerder extends Persoon {
    @Override
    public void menuKeuze() {
        System.out.println("Maak uw keuze: \n1. Voeg nieuw land toe \n2. Wijzigen of een land veilig is \n3. Een gemeente toevoegen\n4. Voeg AZC toe\n5. Wijzig AZC \n6. Verwijder AZC\n7. Rapportage opvragen\n8. Terug naar inloggen");
        if (scanner.hasNextInt()) {

            switch (scanner.nextInt()) {
                case 1:
                    voegLandToe();

                    break;
                case 2:
                    if(!(landen.isEmpty())) {
                        weizigLand();
                    }
                    else {
                        System.out.println("Voeg eerst een land toe.");
                    }
                    break;
                case 3:
                    voegGemeenteToe();

                    break;
                case 4:
                    voegAZCToe();

                    break;
                case 5:
                    if (!(azcs.isEmpty())) {
                        weizigAZC();
                    }
                    else {
                        System.out.println("Voeg eerste een AZC toe.");
                    }
                    break;
                case 6:
                    if (!(azcs.isEmpty())) {
                        verwijderAZC();
                    }
                    else {
                        System.out.println("Voeg eerste een AZC toe.");
                    }

                    break;
                case 7:
                    if (!(azcs.isEmpty())) {
                        rapportageOpvragen();
                    }
                    else {
                        System.out.println("Voeg eerste een gemeente toe.");
                    }
                    break;
                default:
                    System.out.println("Voer een geldige keuze in");
                    menuKeuze();
                    break;
            }

        }
        else {

            System.out.println("voer een geldige keuze in");
            scanner.nextLine();
            menuKeuze();
        }

    }


    public void voegLandToe() {
        System.out.println("Voer het land in:");
        scanner.nextLine();
        String naam = scanner.nextLine();
        System.out.println("Is het land veilig (y/n)");
        String isVeilig = scanner.nextLine();
        boolean veilig = isVeilig.equals("y");
        Land land = new Land(naam, veilig);
        landen.add(land);
    }

    public void weizigLand() {
        int counter = 0;
        for (Land land : landen) {
            counter++;
            System.out.println("[" + counter + "] " + land.naam);
        }

        int getal = scanner.nextInt()-1;
        System.out.println("Is het land veilig (y/n)");
        scanner.nextLine();
        String isVeilig = scanner.nextLine();
        boolean veilig = isVeilig.equals("y");
        landen.get(getal).setVeilig(veilig);
    }


    public void voegGemeenteToe() {
        System.out.println("Wat is de naam van de gemeente?");
        scanner.nextLine();
        String naam = scanner.nextLine();
        System.out.println("Hoeveel inwoners heeft de gemeente ?");
        int aantalInwoners = scanner.nextInt();
        Gemeente gemeente = new Gemeente(naam, aantalInwoners);
        gemeentes.add(gemeente);
    }
    public void voegAZCToe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef de straatnaam van de AZC");
        String straat = scanner.nextLine();
        System.out.println("Geef het nummer van de AZC");
        int nummer = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Geef de postcode van de AZC");
        String postcode = scanner.nextLine();
        System.out.println("Kies de gemeente van de AZC");
        int teller = 0;
        for (Gemeente gemeente : gemeentes) {
            teller++;
            System.out.println("[" + teller + "]" + gemeente.naam);
        }
        int getal = scanner.nextInt()-1;
        Adres adres = new Adres(straat, nummer, postcode, gemeentes.get(getal));
        AZC azc = new AZC(adres);
        gemeentes.get(getal).azcs.add(azc);
        azcs.add(azc);
    }
    public void weizigAZC() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welke AZC wilt u weizigen");
        int counter =0;
        for (AZC azc : azcs) {
            counter++;
            System.out.println("[" + counter + "]" + azc.adres.staartNaam);
        }
        int getal = scanner.nextInt()-1;
        scanner.nextLine();
        System.out.println("Geef de straatnaam van de AZC");
        String straat = scanner.nextLine();
        System.out.println("Geef het nummer van de AZC");
        int nummer = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Geef de postcode van de AZC");
        String postcode = scanner.nextLine();
        System.out.println("Geef de gemeente van de AZC");
        String gemeente = scanner.nextLine();
        azcs.get(getal).adres.staartNaam = straat;
        azcs.get(getal).adres.nummer = nummer;
        azcs.get(getal).adres.postcode = postcode;
        azcs.get(getal).adres.gemeente.naam = gemeente;
    }
    public void verwijderAZC () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welke AZC wilt u verwijderen");
        int counter =0;
        for (AZC azc : azcs) {
            counter++;
            System.out.println("[" + counter + "]" + azc.adres.staartNaam);
        }
        azcs.remove(scanner.nextInt()-1);
    }
    public void rapportageOpvragen () {
        System.out.println("Voor welke gemeente wilt je een rapportage?");
        int counter = 0;
        for (Gemeente gemeente : gemeentes) {
            counter++;
            System.out.println("[" + counter + "]" + gemeente.naam);
        }
        int getal = scanner.nextInt() -1;
        int aantal = 0;
        for (AZC azc : gemeentes.get(getal).azcs) {
            aantal += azc.vluchetlingen.size();
        }
        if(gemeentes.get(getal).aantalInwoners / 200 < gemeentes.get(getal).azcs.size()) {
            System.out.println("De totale uitkering bedraagd: " + (((aantal - gemeentes.get(getal).aantalInwoners / 200) * 2000) + gemeentes.get(getal).aantalInwoners / 200 * 1000) + " Euro");
        }
        else {
            System.out.println("De totale uitkering bedraagd: " + aantal * 1000 + " Euro");
        }
    }
}
