import java.util.ArrayList;
import java.util.Scanner;

public abstract class Persoon {
    protected static ArrayList<Land> landen = new ArrayList<>();
    protected static ArrayList<Gemeente> gemeentes = new ArrayList<Gemeente>();
    protected static ArrayList<AZC> azcs = new ArrayList<AZC>();
    protected static ArrayList<Vluchteling> vluchtelingen = new ArrayList<Vluchteling>();
    Scanner scanner = new Scanner(System.in);


    public void menuKeuze() {

    }
}
