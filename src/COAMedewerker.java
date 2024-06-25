import java.util.Scanner;

public class COAMedewerker extends BevoegdPersoon {
    public COAMedewerker(String gebruikersnaam, String wachtwoord) {
        super.gebruikersnaam = gebruikersnaam;
        super.wachtwoord = wachtwoord;
    }
    @Override
    public void voerTaakUit() {
        System.out.println("Maak je keuze \n1. Vluchteling registreren \n2. Vluchteling plaatsen \n3. Dossier bijwerken\n4. Terug naar inloggen");
        if (scanner.hasNextInt()) {
            int keuze = scanner.nextInt();
            switch (keuze) {
                case 1:
                    if (!(landen.isEmpty())) {
                        regristreerVluchteling();
                    }
                    else {
                        System.out.println("Er zijn geen landen gevonden");
                    }
                    break;
                case 2:
                    if (!(gemeentes.isEmpty())) {
                        vluchtelingPlaatsen();
                    }
                    else {
                        System.out.println("Er zijn geen gemeentes gevonden");
                    }

                    break;
                case 3:
                    if (!(vluchtelingen.isEmpty())) {
                    werkDossierBij();
                } else {
                        System.out.println("Er zijn geen vluchtelingen gevonden");
                    }
                    break;
                case 4: return;
                default:
                    System.out.println("Voer een geldige keuze in");
                    voerTaakUit();
                    break;
            }
        }
        else {

            scanner.nextLine();
            System.out.println("Voer een geldige keuze in");
            voerTaakUit();
        }

    }

    public void regristreerVluchteling() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voer de naam van de vluchteling in: ");
        String naam = scanner.nextLine();
        System.out.println("Kies het land van herkomst van de vluchteling in:");
        int counter =0;
        for (Land land : Persoon.landen) {
            counter++;
            System.out.println("[" + counter + "]" + land.naam);
        }
        int getal = scanner.nextInt()-1;
        scanner.nextLine();
        System.out.println("Heeft de vluchteling een verblijfsvergunning? (y/n)");
        String paspoort = scanner.nextLine();
        boolean kanPaspoortTonen = paspoort.equals("y");
        vluchtelingen.add(concretePersoonFactory.createVluchteling(naam, landen.get(getal), kanPaspoortTonen));

    }
    public void vluchtelingPlaatsen() {
        System.out.println("Kies een vluchteling");
        int counter = 0;
        for (Vluchteling vluchteling : vluchtelingen) {
            counter ++;
            System.out.println(counter + ". " + vluchteling.naam);
        }
        int getal = scanner.nextInt()-1;
        System.out.println("Bij welke gemeente wil je deze vluchteling plaatsen");
        counter =0;
        for (Gemeente gemeente : gemeentes){
            counter++;
            System.out.println(counter + ". " + gemeente.naam);
        }
        int getal2 = scanner.nextInt()-1;
        System.out.println("Kies een AZC");
        counter=0;
        for (AZC azc : gemeentes.get(getal2).azcs) {
            counter++;
            System.out.println(counter + ". AZC in de straat: " + azc.adres.staartNaam);
        }
        int getal3 = scanner.nextInt()-1;
        gemeentes.get(getal2).azcs.get(getal3).vluchetlingen.add(vluchtelingen.get(getal));
    }
    public Vluchteling kiesVluchteling() {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        for (Vluchteling vluchteling : vluchtelingen) {
            counter++;
            System.out.println("[" + counter + "]" + vluchteling.naam);
        }

        int antwoord = scanner.nextInt();
        return vluchtelingen.get(antwoord - 1);
    }
    public void werkDossierBij(){
        kiesVluchteling().dossier.pasDossierAan();
    }
}
