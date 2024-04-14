import java.util.Scanner;

public class Beheerder extends Persoon{
    public void voegLandToe (String naam, boolean veilig){
        Land land = new Land(naam, veilig);
        landen.add(land);
    }
    public void voegGemeenteToe(String naam, int aantalInwoners) {
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
        System.out.println("Geef de gemeente van de AZC");
        String gemeente = scanner.nextLine();
        Adres adres = new Adres(straat, nummer, postcode, gemeente);
        AZC azc = new AZC(adres);
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
        azcs.get(getal).adres.gemeente = gemeente;
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
}
