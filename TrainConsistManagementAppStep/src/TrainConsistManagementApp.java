import java.util.Arrays;
/*
 * ================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ================================================================
 *
 * Use Case 17: Sort Bogie Names Using Arrays.sort()
 *
 * Description:
 * This class demonstrates sorting of bogie type names
 * alphabetically using Java’s built-in Arrays.sort() method.
 *
 * At this stage, the application:
 * - Creates an array of bogie names
 * - Uses Arrays.sort() for sorting
 * - Displays sorted results
 *
 * This maps optimized sorting using Java library utilities.
 *
 * Author: Sajani G
 * Version: 1.0
 */
public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("====================================\n");
        String[] bogieNames = {
                "Sleeper", "AC Chair", "First Class", "General", "Luxury"
        };
        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));
        Arrays.sort(bogieNames);
        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));
        System.out.println("\nUC17 sorting completed...");

    }
}