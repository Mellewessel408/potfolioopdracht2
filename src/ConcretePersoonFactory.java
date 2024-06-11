import java.util.Scanner;

public class ConcretePersoonFactory implements PersoonFactory{
    @Override
    public Vluchteling createVluchteling() {
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
        return new Vluchteling(naam, Persoon.landen.get(getal), kanPaspoortTonen);
    }

    @Override
    public Beheerder createBeheerder(String gebruikersnaam, String wachtwoord) {
        return new Beheerder(gebruikersnaam, wachtwoord);
    }

    @Override
    public COAMedewerker createCOAMedewerker(String gebruikersnaam, String wachtwoord) {
        return new COAMedewerker(gebruikersnaam, wachtwoord);
    }
}
