import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TrainConsistManagementAppTest {
    @Test
    void testException_ValidCapacityCreation() throws Exception {
        TrainConsistManagementApp.PassengerBogie b =
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);

        assertNotNull(b);
    }
    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("Sleeper", -10)
        );
    }
    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("Sleeper", 0)
        );
    }
    @Test
    void testException_ExceptionMessageValidation() {
        Exception ex = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("Sleeper", 0)
        );

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }
    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {
        TrainConsistManagementApp.PassengerBogie b =
                new TrainConsistManagementApp.PassengerBogie("AC Chair", 60);
        assertEquals("AC Chair", b.type);
        assertEquals(60, b.capacity);
    }
    @Test
    void testException_MultipleValidBogiesCreation() throws Exception {
        TrainConsistManagementApp.PassengerBogie b1 =
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);

        TrainConsistManagementApp.PassengerBogie b2 =
                new TrainConsistManagementApp.PassengerBogie("First Class", 50);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}