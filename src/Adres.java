public class Adres {
    String staartNaam;
    int nummer;
    String postcode;
    Gemeente gemeente;

    Adres (String naam, int nummer, String postcode, Gemeente gemeente) {
        this.staartNaam = naam;
        this.nummer = nummer;
        this.postcode = postcode;
        this.gemeente = gemeente;
    }
}
