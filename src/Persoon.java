import java.util.ArrayList;
import java.util.Scanner;

public abstract class Persoon implements PersoonInterface{
    Scanner scanner = new Scanner(System.in);
    public static ArrayList<Land> landen = new ArrayList<Land>();
    protected static ArrayList<AZC> azcs = new ArrayList<AZC>();
    protected static ArrayList<Gemeente> gemeentes = new ArrayList<Gemeente>();
    ConcretePersoonFactory concretePersoonFactory = new ConcretePersoonFactory();
    @Override
    public void voerTaakUit() {

    }
}
