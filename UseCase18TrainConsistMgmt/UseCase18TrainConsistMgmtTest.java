import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UseCase18TrainConsistMgmtTest {

    @Test
    void testSearch_BogieFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UseCase18TrainConsistMgmt.linearSearch(bogies, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(UseCase18TrainConsistMgmt.linearSearch(bogies, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UseCase18TrainConsistMgmt.linearSearch(bogies, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UseCase18TrainConsistMgmt.linearSearch(bogies, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] bogies = {"BG101"};
        assertTrue(UseCase18TrainConsistMgmt.linearSearch(bogies, "BG101"));
        assertFalse(UseCase18TrainConsistMgmt.linearSearch(bogies, "BG999"));
    }
}