import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase14TrainConsistMgmtTest {

    @Test
    void testException_ValidCapacityCreation() throws UseCase14TrainConsistMgmt.InvalidCapacityException {
        UseCase14TrainConsistMgmt.PassengerBogie bogie = new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 72);
        assertNotNull(bogie);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(UseCase14TrainConsistMgmt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmt.PassengerBogie("AC Chair", -10);
        });
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(UseCase14TrainConsistMgmt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmt.PassengerBogie("General", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(UseCase14TrainConsistMgmt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmt.PassengerBogie("First Class", -5);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws UseCase14TrainConsistMgmt.InvalidCapacityException {
        UseCase14TrainConsistMgmt.PassengerBogie bogie = new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 72);
        assertEquals("Sleeper", bogie.type);
        assertEquals(72, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws UseCase14TrainConsistMgmt.InvalidCapacityException {
        UseCase14TrainConsistMgmt.PassengerBogie b1 = new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 72);
        UseCase14TrainConsistMgmt.PassengerBogie b2 = new UseCase14TrainConsistMgmt.PassengerBogie("AC Chair", 56);
        assertNotNull(b1);
        assertNotNull(b2);
    }
}