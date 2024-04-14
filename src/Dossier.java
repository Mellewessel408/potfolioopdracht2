import java.util.Scanner;

public class Dossier {
    boolean kanPaspoortTonen;
    boolean asielAanvraagCompleet;
    boolean rechter;
    boolean uitspraakRechter;
    boolean toegelatenInNederland;
    boolean terruggekeerd;

    Dossier(boolean kanPaspoortTonen) {
        this.kanPaspoortTonen = kanPaspoortTonen;
    }

    public void pasDossierAan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("voer in of er een pasooort getoond is: (y/n)");
        String paspoort = scanner.nextLine();
        if (paspoort.equals("y")) {
            kanPaspoortTonen = true;
        } else {
            kanPaspoortTonen = false;
        }
        System.out.println("Is de asiel aanvraag compleet? (y/n)");
        String asiel = scanner.nextLine();
        if (asiel.equals("y")) {
            asielAanvraagCompleet = true;
        } else {
            asielAanvraagCompleet = false;
        }
        System.out.println("Is er een rechter teogewezen? (y/n)");
        String recht = scanner.nextLine();
        if (recht.equals("y")) {
            rechter = true;
        } else {
            rechter = false;
        }
        if (rechter) {
            System.out.println("Heeft de rechter een uitspraak gedaan? (y/n)");
            String uitspraak = scanner.nextLine();
            if (uitspraak.equals("y")) {
                uitspraakRechter = true;
            } else {
                uitspraakRechter = false;
            }
        }
        if (uitspraakRechter) {
            System.out.println("Is de vluchteling toegelaten? (y/n)");
            String teogelaten = scanner.nextLine();
            if (teogelaten.equals("y")) {
                toegelatenInNederland = true;
            } else {
                toegelatenInNederland = false;
            }
        }
        System.out.println("Is de vluchteling teruggekeerd naar zijn/haar land van herkomst? (y/n)");
        String terug = scanner.nextLine();
        if (terug.equals("y")) {
            terruggekeerd = true;
        } else {
            terruggekeerd = false;
        }
    }

    public void statusDossier() {
        System.out.print("Pasporrt getoond: ");
        if (kanPaspoortTonen) {
            System.out.println("ja");
        }
        else {
            System.out.println("nee");
        }
        System.out.print("Asiel aanvraag is compleet: ");
        if (asielAanvraagCompleet) {
            System.out.println("ja");
        }
        else {
            System.out.println("nee");
        }
        System.out.print("Rechter toegewezen: ");
        if (rechter) {
            System.out.println("ja");
        }
        else {
            System.out.println("nee");
        }
        System.out.print("Rechter heeft uitspraak gedaan: ");
        if (uitspraakRechter) {
            if (toegelatenInNederland) {
                System.out.println("geaccepteerd");
            }
            else {
                System.out.println("afgewezen");
            }
        }
        else {
            System.out.println("nee");
        }
    }


}
