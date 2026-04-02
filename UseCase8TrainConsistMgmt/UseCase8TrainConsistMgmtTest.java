import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCase8TrainConsistMgmtTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("Sleeper", 75));

        List<UseCase8TrainConsistMgmt.Bogie> result = UseCase8TrainConsistMgmt.filterBogies(bogies, 70);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("Sleeper", 70));

        List<UseCase8TrainConsistMgmt.Bogie> result = UseCase8TrainConsistMgmt.filterBogies(bogies, 70);

        assertEquals(0, result.size());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("AC Chair", 56));

        List<UseCase8TrainConsistMgmt.Bogie> result = UseCase8TrainConsistMgmt.filterBogies(bogies, 70);

        assertEquals(0, result.size());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("General", 90));
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("First Class", 24));

        List<UseCase8TrainConsistMgmt.Bogie> result = UseCase8TrainConsistMgmt.filterBogies(bogies, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("AC Chair", 56));
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("First Class", 24));

        List<UseCase8TrainConsistMgmt.Bogie> result = UseCase8TrainConsistMgmt.filterBogies(bogies, 70);

        assertEquals(0, result.size());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("Sleeper", 75));
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("General", 90));

        List<UseCase8TrainConsistMgmt.Bogie> result = UseCase8TrainConsistMgmt.filterBogies(bogies, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = new ArrayList<>();

        List<UseCase8TrainConsistMgmt.Bogie> result = UseCase8TrainConsistMgmt.filterBogies(bogies, 70);

        assertEquals(0, result.size());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("First Class", 24));

        UseCase8TrainConsistMgmt.filterBogies(bogies, 70);

        assertEquals(2, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
        assertEquals("First Class", bogies.get(1).name);
    }
}