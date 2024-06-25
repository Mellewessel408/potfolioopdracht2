import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Equivalentieklassen {
    @Test
    public void testleeftijdsGroepOnder18() {
        int leeftijd = 17;
        String verwachteUitkomst = "Kind";
        String uitkomst = Vluchteling.leeftijdsGroep(leeftijd);
        Assertions.assertEquals(verwachteUitkomst, uitkomst);
    }
    @Test
    public void test1leeftijdsGroepBoven18Onder65() {
        int leeftijd = 18;
        String verwachteUitkomst = "Volwassen";
        String uitkomst = Vluchteling.leeftijdsGroep(leeftijd);
        Assertions.assertEquals(verwachteUitkomst, uitkomst);
    }
    @Test
    public void test2leeftijdsGroepBoven18Onder65() {
        int leeftijd = 65;
        String verwachteUitkomst = "Volwassen";
        String uitkomst = Vluchteling.leeftijdsGroep(leeftijd);
        Assertions.assertEquals(verwachteUitkomst, uitkomst);
    }
    @Test
    public void leeftijdsGroepBoven65() {
        int leeftijd = 66;
        String verwachteUitkomst = "Senioren";
        String uitkomst = Vluchteling.leeftijdsGroep(leeftijd);
        Assertions.assertEquals(verwachteUitkomst, uitkomst);
    }
}