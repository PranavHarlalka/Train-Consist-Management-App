
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UseCase11TrainConsistMgmtTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(UseCase11TrainConsistMgmt.isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainId("TRAIN12"));
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainId("TRN12A"));
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(UseCase11TrainConsistMgmt.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode("PET-ab"));
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode("PET123"));
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainId("TRN-123"));
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainId("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode("PET-aB"));
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode("PET-Ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainId(""));
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode(""));
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainId(null));
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode(null));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        // Checking partial matches
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainId("TRN-1234-EXTRA"));
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode("EXTRA-PET-AB"));
    }
}