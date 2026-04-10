import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase20TrainConsistMgmtTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] bogies = {};
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            UseCase20TrainConsistMgmt.searchBogie(bogies, "BG101");
        });
        assertTrue(exception.getMessage().contains("No bogies available"));
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogies = {"BG101", "BG205"};
        assertDoesNotThrow(() -> {
            UseCase20TrainConsistMgmt.searchBogie(bogies, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};
        assertTrue(UseCase20TrainConsistMgmt.searchBogie(bogies, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};
        assertFalse(UseCase20TrainConsistMgmt.searchBogie(bogies, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogies = {"BG101"};
        assertTrue(UseCase20TrainConsistMgmt.searchBogie(bogies, "BG101"));
    }
}