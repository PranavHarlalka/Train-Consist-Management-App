import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase15TrainConsistMgmtTest {

    @Test
    void testCargo_SafeAssignment() {
        UseCase15TrainConsistMgmt.GoodsBogie bogie = new UseCase15TrainConsistMgmt.GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        // Capture console output to verify the exception is caught and the message is printed
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UseCase15TrainConsistMgmt.GoodsBogie bogie = new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");

        assertTrue(outContent.toString().contains("Error: Unsafe cargo assignment!"));

        System.setOut(System.out); // Reset standard out
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        UseCase15TrainConsistMgmt.GoodsBogie bogie = new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        assertNull(bogie.cargo); // Cargo should remain null
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        UseCase15TrainConsistMgmt.GoodsBogie b1 = new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");
        b1.assignCargo("Petroleum"); // Fails and handled

        UseCase15TrainConsistMgmt.GoodsBogie b2 = new UseCase15TrainConsistMgmt.GoodsBogie("Box");
        b2.assignCargo("Grain"); // Succeeds

        assertNull(b1.cargo);
        assertEquals("Grain", b2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UseCase15TrainConsistMgmt.GoodsBogie bogie = new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");

        assertTrue(outContent.toString().contains("Cargo validation completed for Rectangular bogie"));

        System.setOut(System.out); // Reset standard out
    }
}