import java.util.ArrayList;

public class Gemeente {
    String naam;
    int aantalInwoners;
    ArrayList<AZC> azcs;

    Gemeente (String naam, int aantalInwoners) {
        this.naam = naam;
        this.aantalInwoners = aantalInwoners;
        this.azcs = new ArrayList<AZC>();
    }
    public void rapportage() {
        int getal = 0;
        for (AZC Azcs : azcs){
            getal = Azcs.vluchetlingen.size() + getal;
        }
        int getal2 = 0;
        if (aantalInwoners/200 -getal <=100 ) {
            getal2 = 1000 * getal;
        }
        else {
            getal2 =100 * 1000 + (getal -100) * 2000;
        }
        System.out.println("De uitkering bedraagt : €" + getal2);
    }
}
