package UC8;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TrainAppTest {

    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("AC Chair", 60));
        List<Bogie> filtered = TrainApp.filterBogies(list, 70);
        assertEquals(1, filtered.size());
        assertEquals("Sleeper", filtered.get(0).name);
    }
    
    @Test
    public void testFilter_CapacityEqualToThreshold() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 70));
        List<Bogie> filtered = TrainApp.filterBogies(list, 70);
        assertTrue(filtered.isEmpty());
    }
    
    @Test
    public void testFilter_CapacityLessThanThreshold() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 60));
        List<Bogie> filtered = TrainApp.filterBogies(list, 70);
        assertTrue(filtered.isEmpty());
    }
    
    @Test
    public void testFilter_MultipleBogiesMatching() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("General", 90));
        List<Bogie> filtered = TrainApp.filterBogies(list, 70);
        assertEquals(2, filtered.size());
    }
    
    @Test
    public void testFilter_NoBogiesMatching() {
        List<Bogie> list = Arrays.asList(new Bogie("First Class", 24));
        List<Bogie> filtered = TrainApp.filterBogies(list, 70);
        assertTrue(filtered.isEmpty());
    }
    
    @Test
    public void testFilter_AllBogiesMatching() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("General", 90));
        List<Bogie> filtered = TrainApp.filterBogies(list, 50);
        assertEquals(2, filtered.size());
    }
    
    @Test
    public void testFilter_EmptyBogieList() {
        List<Bogie> filtered = TrainApp.filterBogies(new ArrayList<>(), 70);
        assertTrue(filtered.isEmpty());
    }
    
    @Test
    public void testFilter_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(Arrays.asList(new Bogie("Sleeper", 72)));
        TrainApp.filterBogies(original, 70);
        assertEquals(1, original.size());
    }
}
