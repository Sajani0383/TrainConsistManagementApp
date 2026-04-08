import java.util.*;
import java.util.stream.*;
public class TrainConsistManagementAppTest {
    static class Bogie {
        String name;
        String type;
        Bogie(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }
    static Map<String, List<Bogie>> groupBogies(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));
    }
    static void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", "Sleeper"),
                new Bogie("B2", "Sleeper")
        );
        Map<String, List<Bogie>> result = groupBogies(bogies);
        System.out.println("Test Grouping Basic: " +
                (result.containsKey("Sleeper") ? "PASS" : "FAIL"));
    }
    static void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", "AC"),
                new Bogie("B2", "AC")
        );
        Map<String, List<Bogie>> result = groupBogies(bogies);
        System.out.println("Test Multiple Same Group: " +
                (result.get("AC").size() == 2 ? "PASS" : "FAIL"));
    }
    static void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", "Sleeper"),
                new Bogie("B2", "AC")
        );
        Map<String, List<Bogie>> result = groupBogies(bogies);
        System.out.println("Test Different Types: " +
                (result.size() == 2 ? "PASS" : "FAIL"));
    }
    static void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        Map<String, List<Bogie>> result = groupBogies(bogies);
        System.out.println("Test Empty List: " +
                (result.isEmpty() ? "PASS" : "FAIL"));
    }
    static void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", "General"),
                new Bogie("B2", "General")
        );
        Map<String, List<Bogie>> result = groupBogies(bogies);
        System.out.println("Test Single Category: " +
                (result.size() == 1 ? "PASS" : "FAIL"));
    }
    static void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", "Sleeper"),
                new Bogie("B2", "AC Chair"),
                new Bogie("B3", "First Class")
        );
        Map<String, List<Bogie>> result = groupBogies(bogies);
        boolean condition = result.containsKey("Sleeper") &&
                result.containsKey("AC Chair") &&
                result.containsKey("First Class");
        System.out.println("Test Map Keys: " +
                (condition ? "PASS" : "FAIL"));
    }
    static void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", "Sleeper"),
                new Bogie("B2", "Sleeper")
        );
        Map<String, List<Bogie>> result = groupBogies(bogies);
        System.out.println("Test Group Size: " +
                (result.get("Sleeper").size() == 2 ? "PASS" : "FAIL"));
    }
    static void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("B1", "AC"));
        int originalSize = bogies.size();
        groupBogies(bogies);
        System.out.println("Test Original List Unchanged: " +
                (bogies.size() == originalSize ? "PASS" : "FAIL"));
    }
    public static void main(String[] args) {
        System.out.println("====== UC-9 TEST CASES ======\n");
        testGrouping_BogiesGroupedByType();
        testGrouping_MultipleBogiesInSameGroup();
        testGrouping_DifferentBogieTypes();
        testGrouping_EmptyBogieList();
        testGrouping_SingleBogieCategory();
        testGrouping_MapContainsCorrectKeys();
        testGrouping_GroupSizeValidation();
        testGrouping_OriginalListUnchanged();
    }
}