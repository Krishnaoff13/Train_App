

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TrainAppTest {

    @Test
    public void testGrouping_BogiesGroupedByType() {
        List<Bogie> list = Arrays.asList(new Bogie("S1", "Sleeper"), new Bogie("S2", "Sleeper"));
        Map<String, List<Bogie>> grouped = TrainApp.groupBogiesByType(list);
        assertTrue(grouped.containsKey("Sleeper"));
        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> list = Arrays.asList(new Bogie("S1", "Sleeper"), new Bogie("S2", "Sleeper"));
        Map<String, List<Bogie>> grouped = TrainApp.groupBogiesByType(list);
        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    public void testGrouping_DifferentBogieTypes() {
        List<Bogie> list = Arrays.asList(new Bogie("S1", "Sleeper"), new Bogie("AC1", "AC Chair"));
        Map<String, List<Bogie>> grouped = TrainApp.groupBogiesByType(list);
        assertEquals(2, grouped.keySet().size());
        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
    }

    @Test
    public void testGrouping_EmptyBogieList() {
        Map<String, List<Bogie>> grouped = TrainApp.groupBogiesByType(new ArrayList<>());
        assertTrue(grouped.isEmpty());
    }

    @Test
    public void testGrouping_SingleBogieCategory() {
        List<Bogie> list = Arrays.asList(new Bogie("AC1", "AC Chair"));
        Map<String, List<Bogie>> grouped = TrainApp.groupBogiesByType(list);
        assertEquals(1, grouped.size());
        assertTrue(grouped.containsKey("AC Chair"));
    }

    @Test
    public void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> list = Arrays.asList(new Bogie("S1", "Sleeper"), new Bogie("F1", "First Class"));
        Map<String, List<Bogie>> grouped = TrainApp.groupBogiesByType(list);
        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("First Class"));
    }

    @Test
    public void testGrouping_GroupSizeValidation() {
        List<Bogie> list = Arrays.asList(new Bogie("S1", "Sleeper"), new Bogie("S2", "Sleeper"));
        Map<String, List<Bogie>> grouped = TrainApp.groupBogiesByType(list);
        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    public void testGrouping_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(Arrays.asList(new Bogie("S1", "Sleeper")));
        TrainApp.groupBogiesByType(original);
        assertEquals(1, original.size());
    }
}
