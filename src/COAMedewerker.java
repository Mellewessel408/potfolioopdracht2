import java.util.Scanner;

public class COAMedewerker extends Persoon {
    public void regristreerVluchteling() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voer de naam van de vluchteling in: ");
        String naam = scanner.nextLine();
        System.out.println("Voer het land van herkomst van de vluchteling in:");
        String landVanHerkomst = scanner.nextLine();
        System.out.println("Heeft de vluchteling een verblijfsvergunning? (y/n)");
        String paspoort = scanner.nextLine();
        boolean kanPaspoortTonen = false;
        if (paspoort.equals("y")) {
            kanPaspoortTonen = true;
        }
        Vluchteling vluchteling = new Vluchteling(naam, landVanHerkomst, kanPaspoortTonen);
        vluchtelingen.add(vluchteling);
    }
    public void vluchtelingPlaatsen() {

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
    public void werkDossierBij(Vluchteling vluchteling){
        vluchteling.dossier.pasDossierAan();
    }
}
