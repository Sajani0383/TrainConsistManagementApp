import java.util.*;
import java.util.stream.*;
/**
 * ===============================================================
 * MAIN CLASS - UseCase13TrainConsistMgmt
 * ===============================================================
 *
 * Use Case 13: Performance Comparison (Loops vs Streams)
 *
 * Description:
 * This class compares execution time of loop-based filtering
 * versus stream-based filtering using System.nanoTime().
 *
 * The application:
 * - Creates bogie test dataset
 * - Measures loop execution time
 * - Measures stream execution time
 * - Calculates elapsed duration
 * - Displays performance results
 *
 * This demonstrates performance benchmarking using
 * high-resolution timing.
 *
 * @author Sajani G
 * @version 13.0
 */
public class UseCase13TrainConsistMgmt {
    static class Bogie {
        String type;
        int capacity;
        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }
    public static List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }
    public static List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }
    public static long measureLoopTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterWithLoop(bogies);
        long end = System.nanoTime();
        return end - start;
    }
    public static long measureStreamTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterWithStream(bogies);
        long end = System.nanoTime();
        return end - start;
    }
    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("===============================================\n");
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            bogies.add(new Bogie("Passenger", i % 100));
        }
        long loopTime = measureLoopTime(bogies);
        long streamTime = measureStreamTime(bogies);
        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);
        List<Bogie> loopResult = filterWithLoop(bogies);
        List<Bogie> streamResult = filterWithStream(bogies);
        System.out.println("\nResults Match: " + (loopResult.size() == streamResult.size()));
        System.out.println("\nUC13 performance benchmarking completed...");
    }
}