

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TrainAppTest {

    @Test
    public void testSafety_AllBogiesValid() {
        List<Bogie> bogies = Arrays.asList(new Bogie("Cylindrical", "Petroleum"), new Bogie("Open", "Coal"));
        assertTrue(TrainApp.isTrainSafe(bogies));
    }

    @Test
    public void testSafety_CylindricalWithInvalidCargo() {
        List<Bogie> bogies = Arrays.asList(new Bogie("Cylindrical", "Coal"));
        assertFalse(TrainApp.isTrainSafe(bogies));
    }

    @Test
    public void testSafety_NonCylindricalBogiesAllowed() {
        List<Bogie> bogies = Arrays.asList(new Bogie("Open", "Wood"), new Bogie("Box", "Electronics"));
        assertTrue(TrainApp.isTrainSafe(bogies));
    }

    @Test
    public void testSafety_MixedBogiesWithViolation() {
        List<Bogie> bogies = Arrays.asList(
            new Bogie("Open", "Coal"),
            new Bogie("Cylindrical", "Grain")
        );
        assertFalse(TrainApp.isTrainSafe(bogies));
    }

    @Test
    public void testSafety_EmptyBogieList() {
        assertTrue(TrainApp.isTrainSafe(new ArrayList<>()));
    }
}
