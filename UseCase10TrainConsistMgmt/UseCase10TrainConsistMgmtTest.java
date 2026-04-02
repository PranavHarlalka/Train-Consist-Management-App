import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCase10TrainConsistMgmtTest {

    @Test
    void testReduce_TotalSeatCalculation() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("AC Chair", 56));

        int result = UseCase10TrainConsistMgmt.calculateTotalSeats(bogies);

        assertEquals(128, result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("AC Chair", 56));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("First Class", 24));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("Sleeper", 70));

        int result = UseCase10TrainConsistMgmt.calculateTotalSeats(bogies);

        assertEquals(222, result);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("First Class", 24));

        int result = UseCase10TrainConsistMgmt.calculateTotalSeats(bogies);

        assertEquals(24, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();

        int result = UseCase10TrainConsistMgmt.calculateTotalSeats(bogies);

        assertEquals(0, result);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("General", 90));

        int result = UseCase10TrainConsistMgmt.calculateTotalSeats(bogies);

        assertEquals(90, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("A", 10));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("B", 20));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("C", 30));

        int result = UseCase10TrainConsistMgmt.calculateTotalSeats(bogies);

        assertEquals(60, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("Sleeper", 72));

        UseCase10TrainConsistMgmt.calculateTotalSeats(bogies);

        assertEquals(1, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
        assertEquals(72, bogies.get(0).capacity);
    }
}