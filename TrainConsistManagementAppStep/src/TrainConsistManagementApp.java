/**
 * ============================================================
 * MAIN CLASS - UseCase12SafetyCheck
 * ============================================================
 *
 * Use Case 12: Safety Compliance Check for Goods Bogies
 *
 * @author Sajani G
 * @version 12.0
 */
import java.util.*;
import java.util.regex.*;
public class TrainConsistManagementApp  {
    static class Bogie {
        String type;
        String cargo;
        Bogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }
    public static void main(String[] args) {
        System.out.println("===== UC12 - Safety Compliance Check =====\n");
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Cylindrical", "Petroleum"),
                new Bogie("Open", "Coal"),
                new Bogie("Box", "Grain")
        );
        boolean isSafe = bogies.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );
        System.out.println("Train Safety Status: " +
                (isSafe ? "SAFE ✅" : "UNSAFE ❌"));
    }
}