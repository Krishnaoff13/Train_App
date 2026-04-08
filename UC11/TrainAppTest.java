package UC11;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrainAppTest {

    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(TrainApp.validateTrainId("TRN-1234"));
    }
    
    @Test
    public void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainApp.validateTrainId("TRAIN12"));
        assertFalse(TrainApp.validateTrainId("TRN12A"));
        assertFalse(TrainApp.validateTrainId("1234-TRN"));
    }

    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(TrainApp.validateCargoCode("PET-AB"));
    }
    
    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainApp.validateCargoCode("PET-12"));
        assertFalse(TrainApp.validateCargoCode("PET123"));
        assertFalse(TrainApp.validateCargoCode("AB-PET"));
    }
    
    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainApp.validateTrainId("TRN-123"));
        assertFalse(TrainApp.validateTrainId("TRN-12345"));
    }
    
    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainApp.validateCargoCode("PET-ab"));
        assertFalse(TrainApp.validateCargoCode("PeT-AB"));
    }
    
    @Test
    public void testRegex_EmptyInputHandling() {
        assertFalse(TrainApp.validateTrainId(""));
        assertFalse(TrainApp.validateCargoCode(""));
        assertFalse(TrainApp.validateTrainId(null));
    }
    
    @Test
    public void testRegex_ExactPatternMatch() {
        assertFalse(TrainApp.validateTrainId("TRN-1234ABC"));
        assertFalse(TrainApp.validateCargoCode("PET-ABC"));
    }
}
