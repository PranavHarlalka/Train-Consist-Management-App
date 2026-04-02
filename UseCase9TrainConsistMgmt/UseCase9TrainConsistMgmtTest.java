import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UseCase9TrainConsistMgmtTest {

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72));

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result = UseCase9TrainConsistMgmt.groupBogiesByType(bogies);

        assertTrue(result.containsKey("Sleeper"));
        assertEquals(1, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 70));

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result = UseCase9TrainConsistMgmt.groupBogiesByType(bogies);

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("AC Chair", 56));

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result = UseCase9TrainConsistMgmt.groupBogiesByType(bogies);

        assertEquals(2, result.keySet().size());
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result = UseCase9TrainConsistMgmt.groupBogiesByType(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("First Class", 24));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("First Class", 20));

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result = UseCase9TrainConsistMgmt.groupBogiesByType(bogies);

        assertEquals(1, result.keySet().size());
        assertTrue(result.containsKey("First Class"));
        assertEquals(2, result.get("First Class").size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("AC Chair", 56));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("First Class", 24));

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result = UseCase9TrainConsistMgmt.groupBogiesByType(bogies);

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 70));

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result = UseCase9TrainConsistMgmt.groupBogiesByType(bogies);

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72));

        UseCase9TrainConsistMgmt.groupBogiesByType(bogies);

        assertEquals(1, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
    }
}