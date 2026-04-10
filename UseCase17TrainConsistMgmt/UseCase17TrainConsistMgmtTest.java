import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class UseCase17TrainConsistMgmtTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] bogies = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        UseCase17TrainConsistMgmt.sortBogies(bogies);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General", "Luxury", "Sleeper"}, bogies);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] bogies = {"Luxury", "General", "Sleeper", "AC Chair"};
        UseCase17TrainConsistMgmt.sortBogies(bogies);
        assertArrayEquals(new String[]{"AC Chair", "General", "Luxury", "Sleeper"}, bogies);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] bogies = {"AC Chair", "First Class", "General"};
        UseCase17TrainConsistMgmt.sortBogies(bogies);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General"}, bogies);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] bogies = {"Sleeper", "AC Chair", "Sleeper", "General"};
        UseCase17TrainConsistMgmt.sortBogies(bogies);
        assertArrayEquals(new String[]{"AC Chair", "General", "Sleeper", "Sleeper"}, bogies);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] bogies = {"Sleeper"};
        UseCase17TrainConsistMgmt.sortBogies(bogies);
        assertArrayEquals(new String[]{"Sleeper"}, bogies);
    }
}