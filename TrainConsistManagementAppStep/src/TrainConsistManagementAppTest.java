import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
class TrainConsistManagementAppTest {
    List<TrainConsistManagementApp.Bogie> createTestData() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.Bogie("Passenger", 50));
        list.add(new TrainConsistManagementApp.Bogie("Passenger", 70));
        list.add(new TrainConsistManagementApp.Bogie("Goods", 80));
        list.add(new TrainConsistManagementApp.Bogie("Goods", 40));
        return list;
    }

    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> data = createTestData();
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterWithLoop(data);
        for (TrainConsistManagementApp.Bogie b : result) {
            assertTrue(b.capacity > 60);
        }
    }
    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> data = createTestData();
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterWithStream(data);
        for (TrainConsistManagementApp.Bogie b : result) {
            assertTrue(b.capacity > 60);
        }
    }
    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistManagementApp.Bogie> data = createTestData();
        int loopSize = TrainConsistManagementApp.filterWithLoop(data).size();
        int streamSize = TrainConsistManagementApp.filterWithStream(data).size();
        assertEquals(loopSize, streamSize);
    }
    @Test
    void testExecutionTimeMeasurement() {
        List<TrainConsistManagementApp.Bogie> data = createTestData();
        long loopTime = TrainConsistManagementApp.measureLoopTime(data);
        long streamTime = TrainConsistManagementApp.measureStreamTime(data);
        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }
    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistManagementApp.Bogie> data = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            data.add(new TrainConsistManagementApp.Bogie("Passenger", i % 100));
        }
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterWithStream(data);
        assertNotNull(result);
    }
}