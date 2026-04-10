import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UseCase13TrainConsistMgmtTest {

    @Test
    void testLoopFilteringLogic() {
        List<UseCase13TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase13TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase13TrainConsistMgmt.Bogie("AC Chair", 56));

        List<UseCase13TrainConsistMgmt.Bogie> result = UseCase13TrainConsistMgmt.filterUsingLoop(bogies);

        assertEquals(1, result.size());
        assertEquals(72, result.get(0).capacity);
    }

    @Test
    void testStreamFilteringLogic() {
        List<UseCase13TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase13TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase13TrainConsistMgmt.Bogie("AC Chair", 56));

        List<UseCase13TrainConsistMgmt.Bogie> result = UseCase13TrainConsistMgmt.filterUsingStream(bogies);

        assertEquals(1, result.size());
        assertEquals(72, result.get(0).capacity);
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<UseCase13TrainConsistMgmt.Bogie> bogies = UseCase13TrainConsistMgmt.generateDataset(500);

        List<UseCase13TrainConsistMgmt.Bogie> loopResult = UseCase13TrainConsistMgmt.filterUsingLoop(bogies);
        List<UseCase13TrainConsistMgmt.Bogie> streamResult = UseCase13TrainConsistMgmt.filterUsingStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<UseCase13TrainConsistMgmt.Bogie> bogies = UseCase13TrainConsistMgmt.generateDataset(1000);

        long start = System.nanoTime();
        UseCase13TrainConsistMgmt.filterUsingLoop(bogies);
        long end = System.nanoTime();

        long elapsed = end - start;
        assertTrue(elapsed > 0, "Elapsed time should be greater than zero");
    }

    @Test
    void testLargeDatasetProcessing() {
        // Test processing of 100,000 items
        List<UseCase13TrainConsistMgmt.Bogie> bogies = UseCase13TrainConsistMgmt.generateDataset(100000);

        List<UseCase13TrainConsistMgmt.Bogie> result = UseCase13TrainConsistMgmt.filterUsingStream(bogies);

        // Since dataset generation alternates >60 and <=60, exactly half should match
        assertEquals(50000, result.size());
    }
}