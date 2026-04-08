package UC10;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TrainAppTest {

    @Test
    public void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = Arrays.asList(new Bogie("A", 10), new Bogie("B", 20));
        assertEquals(30, TrainApp.countTotalSeats(bogies));
    }
    
    @Test
    public void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = Arrays.asList(new Bogie("A", 10), new Bogie("B", 20), new Bogie("C", 30));
        assertEquals(60, TrainApp.countTotalSeats(bogies));
    }
    
    @Test
    public void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Arrays.asList(new Bogie("A", 40));
        assertEquals(40, TrainApp.countTotalSeats(bogies));
    }
    
    @Test
    public void testReduce_EmptyBogieList() {
        assertEquals(0, TrainApp.countTotalSeats(new ArrayList<>()));
    }
    
    @Test
    public void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = Arrays.asList(new Bogie("A", 10));
        assertEquals(10, TrainApp.countTotalSeats(bogies));
    }
    
    @Test
    public void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = Arrays.asList(new Bogie("A", 10), new Bogie("B", 20));
        assertEquals(30, TrainApp.countTotalSeats(bogies));
    }
    
    @Test
    public void testReduce_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(Arrays.asList(new Bogie("A", 10)));
        TrainApp.countTotalSeats(original);
        assertEquals(1, original.size());
    }
}
