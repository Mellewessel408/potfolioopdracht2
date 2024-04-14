import java.util.ArrayList;

public class AZC {
    Adres adres;
    ArrayList<Vluchteling> vluchetlingen;

    AZC (Adres adres) {
        this.adres = adres;
        this.vluchetlingen = new ArrayList<Vluchteling>();
    }

    public boolean heeftVlucteling() {
        return vluchetlingen.isEmpty();
    }
}
