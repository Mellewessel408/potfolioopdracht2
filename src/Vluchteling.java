import java.util.Scanner;

public class Vluchteling {
    String naam;
    String landVanHerkomst;
    Dossier dossier;
    boolean verblijfsvergunning = false;
    Adres adres;

    Vluchteling(String naam, String landVanHerkomst, boolean kanPaspoortTonen) {
        this.naam = naam;
        this.landVanHerkomst = landVanHerkomst;
        this.dossier = new Dossier(kanPaspoortTonen);
    }
    public void gegevensOpvragen() {
        System.out.println("Naam: " + naam);
        System.out.println("Land van herkomst " + landVanHerkomst);
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
        System.out.println("Geef de gemeente ");
        String gemeente = scanner.nextLine();
        adres = new Adres(straat, nummer, postcode, gemeente);


    }
}


