import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    @Test
    void testException_ValidCapacityCreation() throws Exception {
        TrainConsistManagementApp.PassengerBogie b =
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 60);

        assertEquals("Sleeper", b.type);
        assertEquals(60, b.capacity);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception e = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("AC", -10)
        );

        assertEquals("Capacity must be greater than zero", e.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception e = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("First Class", 0)
        );

        assertEquals("Capacity must be greater than zero", e.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception e = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("Sleeper", -5)
        );

        assertEquals("Capacity must be greater than zero", e.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {
        TrainConsistManagementApp.PassengerBogie b =
                new TrainConsistManagementApp.PassengerBogie("AC Chair", 70);

        assertEquals("AC Chair", b.type);
        assertEquals(70, b.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws Exception {
        TrainConsistManagementApp.PassengerBogie b1 =
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 50);

        TrainConsistManagementApp.PassengerBogie b2 =
                new TrainConsistManagementApp.PassengerBogie("AC", 80);

        assertEquals(50, b1.capacity);
        assertEquals(80, b2.capacity);
    }
}