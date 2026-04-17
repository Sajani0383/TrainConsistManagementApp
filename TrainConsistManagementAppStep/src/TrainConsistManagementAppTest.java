import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TrainConsistManagementAppTest {
    @Test
    void testCargo_SafeAssignment() {
        TrainConsistManagementApp.GoodsBogie g =
                new TrainConsistManagementApp.GoodsBogie("Cylindrical");
        g.assignCargo("Petroleum");
        assertEquals("Petroleum", g.cargo);
    }
    @Test
    void testCargo_UnsafeAssignmentHandled() {
        TrainConsistManagementApp.GoodsBogie g =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");
        g.assignCargo("Petroleum");
        assertNull(g.cargo);
    }
    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        TrainConsistManagementApp.GoodsBogie g =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        g.assignCargo("Petroleum");

        assertNull(g.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        TrainConsistManagementApp.GoodsBogie g1 =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        TrainConsistManagementApp.GoodsBogie g2 =
                new TrainConsistManagementApp.GoodsBogie("Cylindrical");

        g1.assignCargo("Petroleum");
        g2.assignCargo("Coal");

        assertEquals("Coal", g2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        TrainConsistManagementApp.GoodsBogie g =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        g.assignCargo("Petroleum");

        assertNull(g.cargo);
    }
}