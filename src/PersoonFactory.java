public interface PersoonFactory {

    public BevoegdPersoon createBeheerder(String gebruikersnaam, String wachtwoord);
    public COAMedewerker createCOAMedewerker(String gebruikersnaam, String wachtwoord);
    public Vluchteling createVluchteling(String naam, Land land, boolean kanPaspoortTonen);
}
