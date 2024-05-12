import java.util.Scanner;

public class Vluchteling extends Persoon{
    String naam;
    Land land;
    Dossier dossier;
    boolean verblijfsvergunning = false;
    Adres adres;

    @Override
    public void menuKeuze () {
        System.out.println("Maak een keuze:");
        System.out.println("1.Gegevens opvragen\n2. Dossier aanvragen");
        if (dossier.toegelatenInNederland) {
            System.out.println("3. Adres regitsreren");
        }
        if (scanner.hasNextInt()) {
            int keuze = scanner.nextInt();
            switch (keuze) {
                case 1 :
                    gegevensOpvragen();
                    break;
                case 2:
                    dossier.statusDossier();
                    break;
                case 3:
                    if (dossier.uitspraakRechter) {
                        registreerAdres();
                    }
                    break;
            }
        }
        else {
            System.out.println("Voer een geldige keuze in");
            scanner.nextLine();
            menuKeuze();
        }
    }
    Vluchteling(String naam, Land land ,boolean kanPaspoortTonen) {
        this.naam = naam;
        this.land = land;
        this.dossier = new Dossier(kanPaspoortTonen);
    }

    public void gegevensOpvragen() {
        System.out.println("Naam: " + naam);
        System.out.println("Land van herkomst " + land.naam);
        if (verblijfsvergunning) {
            System.out.print("U heeft een verblijfsvergunning");
        }
        else {
            System.out.println("U heeft geen verblijfsvergunning");
        }
    }
    public void registreerAdres() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef de straatnaam");
        String straat = scanner.nextLine();
        System.out.println("Geef het nummer");
        int nummer = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Geef de postcode");
        String postcode = scanner.nextLine();
        System.out.println("Voor welke gemeente wilt je een rapportage?");
        int counter = 0;
        for (Gemeente gemeente : gemeentes) {
            counter++;
            System.out.println("[" + counter + "]" + gemeente);
        }
        adres = new Adres(straat, nummer, postcode, gemeentes.get(scanner.nextInt()-1));


    }
}


