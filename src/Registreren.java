import java.util.Scanner;

public class Registreren {
    Inloggen inloggen = Inloggen.getInloggen();
    Scanner scanner = new Scanner(System.in);
    public ConcretePersoonFactory concretePersoonFactory = new ConcretePersoonFactory();
    int inlogcode = 12345;
    public void registreerBeheerder() {
        System.out.println("Voer de gekregen code in:");
        if (inlogcode == scanner.nextInt()) {
            System.out.println("Wat wordt je gebruikersnaam?");
            scanner.nextLine();
            String gebruikersnaam = scanner.nextLine();
            System.out.println("Wat wordt je wachtwoord?");
            String wachtwoord = scanner.nextLine();
            inloggen.voegBeheerderToe(concretePersoonFactory.createBeheerder(gebruikersnaam, wachtwoord));

        }
        else {
            System.out.println("De inlogcode was niet geldig");
        }
    }
    public void registreerCAOMedewerker() {
        System.out.println("Voer de gekregen code in:");
        if (inlogcode == scanner.nextInt()) {
            System.out.println("Wat wordt je gebruikersnaam?");
            scanner.nextLine();
            String gebruikersnaam = scanner.nextLine();
            System.out.println("Wat wordt je wachtwoord?");
            String wachtwoord = scanner.nextLine();
            inloggen.voegCOAMedewerkerToe(concretePersoonFactory.createCOAMedewerker(gebruikersnaam, wachtwoord));

        }
        else {
            System.out.println("De inlogcode was niet geldig");
        }
    }
}
