import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Persoon beheerder = new Beheerder();
    Persoon coaMedewerker = new COAMedewerker();

    public void beginMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Als wie wil je inloggen? \n[1] Beheerder \n[2] COA-medewerker\n[3] Vluchteling");
        if (scanner.hasNextInt()) {
            int getal = scanner.nextInt();
            switch (getal) {
                case 1 :
                    beheerder.menuKeuze();
                    beginMenu();
                    break;
                case 2 :
                    coaMedewerker.menuKeuze();
                    beginMenu();
                    break;
                case 3 :
                    if(!(Persoon.vluchtelingen.isEmpty())) {
                        int counter = 0;
                        for (Vluchteling vluchteling : Persoon.vluchtelingen) {
                            counter++;
                            System.out.println("[" + counter + "] " + vluchteling.naam);
                        }
                        if (scanner.hasNextInt()) {
                            Persoon.vluchtelingen.get(scanner.nextInt()-1).menuKeuze();
                        }
                    }
                    else {
                        System.out.println("Er zijn geen vluchtelingen om uit te kiezen");
                    }
                    beginMenu();
                    break;

            default : System.out.println("Voer een geldige keuze in.");
            }
        }
        System.out.println("Voer een geldige keuze in.");
        beginMenu();

    }
}
