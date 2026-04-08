package dev;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TrainAppTest {

    // --- UC8 Tests ---
    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("AC Chair", 60));
        assertEquals(1, TrainApp.filterBogies(list, 70).size());
    }
    @Test
    public void testFilter_CapacityEqualToThreshold() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 70));
        assertTrue(TrainApp.filterBogies(list, 70).isEmpty());
    }
    @Test
    public void testFilter_CapacityLessThanThreshold() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 60));
        assertTrue(TrainApp.filterBogies(list, 70).isEmpty());
    }
    @Test
    public void testFilter_MultipleBogiesMatching() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("General", 90));
        assertEquals(2, TrainApp.filterBogies(list, 70).size());
    }
    @Test
    public void testFilter_NoBogiesMatching() {
        List<Bogie> list = Arrays.asList(new Bogie("First Class", 24));
        assertTrue(TrainApp.filterBogies(list, 70).isEmpty());
    }
    @Test
    public void testFilter_AllBogiesMatching() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("General", 90));
        assertEquals(2, TrainApp.filterBogies(list, 50).size());
    }
    @Test
    public void testFilter_EmptyBogieList() {
        assertTrue(TrainApp.filterBogies(new ArrayList<>(), 70).isEmpty());
    }
    @Test
    public void testFilter_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(Arrays.asList(new Bogie("Sleeper", 72)));
        TrainApp.filterBogies(original, 70);
        assertEquals(1, original.size());
    }

    // --- UC9 Tests ---
    @Test
    public void testGrouping_BogiesGroupedByType() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("Sleeper", 72));
        Map<String, List<Bogie>> grouped = TrainApp.groupBogiesByType(list);
        assertTrue(grouped.containsKey("Sleeper"));
    }
    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("Sleeper", 60)); // Same type default
        assertEquals(2, TrainApp.groupBogiesByType(list).get("Sleeper").size());
    }
    @Test
    public void testGrouping_DifferentBogieTypes() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("AC Chair", 60));
        assertEquals(2, TrainApp.groupBogiesByType(list).size());
    }
    @Test
    public void testGrouping_EmptyBogieList() {
        assertTrue(TrainApp.groupBogiesByType(new ArrayList<>()).isEmpty());
    }
    @Test
    public void testGrouping_SingleBogieCategory() {
        List<Bogie> list = Arrays.asList(new Bogie("AC Chair", 60));
        assertEquals(1, TrainApp.groupBogiesByType(list).size());
    }
    @Test
    public void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("First Class", 24));
        assertTrue(TrainApp.groupBogiesByType(list).containsKey("Sleeper"));
        assertTrue(TrainApp.groupBogiesByType(list).containsKey("First Class"));
    }
    @Test
    public void testGrouping_GroupSizeValidation() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("Sleeper", 72));
        assertEquals(2, TrainApp.groupBogiesByType(list).get("Sleeper").size());
    }
    @Test
    public void testGrouping_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(Arrays.asList(new Bogie("Sleeper", 72)));
        TrainApp.groupBogiesByType(original);
        assertEquals(1, original.size());
    }

    // --- UC10 Tests ---
    @Test
    public void testReduce_TotalSeatCalculation() {
        assertEquals(132, TrainApp.countTotalSeats(Arrays.asList(new Bogie("S", 72), new Bogie("A", 60))));
    }
    @Test
    public void testReduce_MultipleBogiesAggregation() {
        assertEquals(156, TrainApp.countTotalSeats(Arrays.asList(new Bogie("A", 72), new Bogie("B", 60), new Bogie("C", 24))));
    }
    @Test
    public void testReduce_SingleBogieCapacity() {
        assertEquals(40, TrainApp.countTotalSeats(Arrays.asList(new Bogie("A", 40))));
    }
    @Test
    public void testReduce_EmptyBogieList() {
        assertEquals(0, TrainApp.countTotalSeats(new ArrayList<>()));
    }
    @Test
    public void testReduce_CorrectCapacityExtraction() {
        assertEquals(10, TrainApp.countTotalSeats(Arrays.asList(new Bogie("A", 10))));
    }
    @Test
    public void testReduce_AllBogiesIncluded() {
        assertEquals(30, TrainApp.countTotalSeats(Arrays.asList(new Bogie("A", 10), new Bogie("B", 20))));
    }
    @Test
    public void testReduce_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(Arrays.asList(new Bogie("A", 10)));
        TrainApp.countTotalSeats(original);
        assertEquals(1, original.size());
    }

    // --- UC11 Tests ---
    @Test
    public void testRegex_ValidTrainID() { assertTrue(TrainApp.validateTrainId("TRN-1234")); }
    @Test
    public void testRegex_InvalidTrainIDFormat() { assertFalse(TrainApp.validateTrainId("TRAIN12")); }
    @Test
    public void testRegex_ValidCargoCode() { assertTrue(TrainApp.validateCargoCode("PET-AB")); }
    @Test
    public void testRegex_InvalidCargoCodeFormat() { assertFalse(TrainApp.validateCargoCode("PET-12")); }
    @Test
    public void testRegex_TrainIDDigitLengthValidation() { assertFalse(TrainApp.validateTrainId("TRN-123")); }
    @Test
    public void testRegex_CargoCodeUppercaseValidation() { assertFalse(TrainApp.validateCargoCode("PET-ab")); }
    @Test
    public void testRegex_EmptyInputHandling() { assertFalse(TrainApp.validateTrainId("")); }
    @Test
    public void testRegex_ExactPatternMatch() { assertFalse(TrainApp.validateTrainId("TRN-1234ABC")); }

    // --- UC12 Tests ---
    @Test
    public void testSafety_AllBogiesValid() {
        assertTrue(TrainApp.isTrainSafe(Arrays.asList(new Bogie("Cylindrical", "Petroleum"), new Bogie("Open", "Coal"))));
    }
    @Test
    public void testSafety_CylindricalWithInvalidCargo() {
        assertFalse(TrainApp.isTrainSafe(Arrays.asList(new Bogie("Cylindrical", "Coal"))));
    }
    @Test
    public void testSafety_NonCylindricalBogiesAllowed() {
        assertTrue(TrainApp.isTrainSafe(Arrays.asList(new Bogie("Open", "Wood"), new Bogie("Box", "Electronics"))));
    }
    @Test
    public void testSafety_MixedBogiesWithViolation() {
        assertFalse(TrainApp.isTrainSafe(Arrays.asList(new Bogie("Open", "Coal"), new Bogie("Cylindrical", "Grain"))));
    }
    @Test
    public void testSafety_EmptyBogieList() {
        assertTrue(TrainApp.isTrainSafe(new ArrayList<>()));
    }
}
