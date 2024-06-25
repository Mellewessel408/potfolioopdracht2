public class ConcretePersoonFactory implements PersoonFactory{
    @Override
    public Vluchteling createVluchteling(String naam, Land land, boolean kanPaspoortTonen) {
        return new Vluchteling(naam, land, kanPaspoortTonen);
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
