import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
class QuantityMeasurementAppTest {
    List<UseCase13TrainConsistMgmt.Bogie> createTestData() {
        List<UseCase13TrainConsistMgmt.Bogie> list = new ArrayList<>();
        list.add(new UseCase13TrainConsistMgmt.Bogie("Passenger", 50));
        list.add(new UseCase13TrainConsistMgmt.Bogie("Passenger", 70));
        list.add(new UseCase13TrainConsistMgmt.Bogie("Goods", 80));
        list.add(new UseCase13TrainConsistMgmt.Bogie("Goods", 40));
        return list;
    }
    @Test
    void testLoopFilteringLogic() {
        List<UseCase13TrainConsistMgmt.Bogie> data = createTestData();
        List<UseCase13TrainConsistMgmt.Bogie> result =
                UseCase13TrainConsistMgmt.filterWithLoop(data);
        for (UseCase13TrainConsistMgmt.Bogie b : result) {
            assertTrue(b.capacity > 60);
        }
    }
    @Test
    void testStreamFilteringLogic() {
        List<UseCase13TrainConsistMgmt.Bogie> data = createTestData();
        List<UseCase13TrainConsistMgmt.Bogie> result =
                UseCase13TrainConsistMgmt.filterWithStream(data);

        for (UseCase13TrainConsistMgmt.Bogie b : result) {
            assertTrue(b.capacity > 60);
        }
    }
    @Test
    void testLoopAndStreamResultsMatch() {
        List<UseCase13TrainConsistMgmt.Bogie> data = createTestData();
        int loopSize = UseCase13TrainConsistMgmt.filterWithLoop(data).size();
        int streamSize = UseCase13TrainConsistMgmt.filterWithStream(data).size();
        assertEquals(loopSize, streamSize);
    }
    @Test
    void testExecutionTimeMeasurement() {
        List<UseCase13TrainConsistMgmt.Bogie> data = createTestData();
        long loopTime = UseCase13TrainConsistMgmt.measureLoopTime(data);
        long streamTime = UseCase13TrainConsistMgmt.measureStreamTime(data);
        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }
    @Test
    void testLargeDatasetProcessing() {
        List<UseCase13TrainConsistMgmt.Bogie> data = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            data.add(new UseCase13TrainConsistMgmt.Bogie("Passenger", i % 100));
        }
        List<UseCase13TrainConsistMgmt.Bogie> result =
                UseCase13TrainConsistMgmt.filterWithStream(data);
        assertNotNull(result);
    }
}