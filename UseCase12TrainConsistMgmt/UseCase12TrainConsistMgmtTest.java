import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UseCase12TrainConsistMgmtTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum"));

        assertTrue(UseCase12TrainConsistMgmt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Coal"));

        assertFalse(UseCase12TrainConsistMgmt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new UseCase12TrainConsistMgmt.GoodsBogie("Open", "Coal"));
        bogies.add(new UseCase12TrainConsistMgmt.GoodsBogie("Box", "Grain"));

        assertTrue(UseCase12TrainConsistMgmt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new UseCase12TrainConsistMgmt.GoodsBogie("Open", "Coal"));
        bogies.add(new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Grain")); // Violation here

        assertFalse(UseCase12TrainConsistMgmt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> bogies = new ArrayList<>();

        assertTrue(UseCase12TrainConsistMgmt.isTrainSafe(bogies));
    }
}