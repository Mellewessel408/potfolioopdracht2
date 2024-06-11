import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inloggen {
    Scanner scanner = new Scanner(System.in);
    private static volatile Inloggen instance = null;
    private HashMap<String, String> beheerders = new HashMap<>();
    private HashMap<String, String> COAMedewerkers = new HashMap<>();
    private Inloggen() {
    }

    public static Inloggen getInloggen() {
        if (instance == null) {
            synchronized (Inloggen.class) {
                if (instance == null) {
                    instance = new Inloggen();
                }
            }
        }
        return instance;
    }

    public boolean beheerderInloggen() {
        System.out.println("Voer je gebruikersnaam in:");
        String gebruikersnaam = scanner.nextLine();
        System.out.println("Voer je wachtwoord in:");
        String wachtwoord = scanner.nextLine();
        return beheerders.get(gebruikersnaam).equals(wachtwoord);
    }
    public boolean COAMedewerkerInloggen() {
        System.out.println("Voer je gebruikersnaam in:");
        String gebruikersnaam = scanner.nextLine();
        System.out.println("Voer je wachtwoord in:");
        String wachtwoord = scanner.nextLine();
        return COAMedewerkers.get(gebruikersnaam).equals(wachtwoord);
    }
    public void voegBeheerderToe(Beheerder beheerder) {
        beheerders.put(beheerder.gebruikersnaam, beheerder.wachtwoord);
    }
    public void voegCOAMedewerkerToe(COAMedewerker coaMedewerker) {
        beheerders.put(coaMedewerker.gebruikersnaam, coaMedewerker.wachtwoord);
    }
}
