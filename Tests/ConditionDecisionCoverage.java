import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class ConditionDecisionCoverage {

    private final InputStream originalIn = System.in;
    private Dossier dossier;

    @Before
    public void setUp() {
        dossier = new Dossier(false);
    }

    @After
    public void tearDown() {
        System.setIn(originalIn); // Restore original System.in
    }

    @Test
    public void testPasDossierAan_AllTrue_True() {
        String simulatedInput = "y\ny\ny\ny\ny\ny\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        dossier.pasDossierAan();
        boolean verwachteUitkomst = true;
        boolean uitkomst = dossier.toegelatenInNederland;
        Assertions.assertEquals(verwachteUitkomst, uitkomst);
        assertTrue(dossier.kanPaspoortTonen);
    }

    @Test
    public void testPasDossierAan_AllFalse_False() {
        String simulatedInput = "n\nn\nn\nn";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        dossier.pasDossierAan();
        boolean verwachteUitkomst = false;
        boolean uitkomst = dossier.toegelatenInNederland;
        Assertions.assertEquals(verwachteUitkomst, uitkomst);
    }

}