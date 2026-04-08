import java.util.*;
import java.util.regex.*;
public class TrainConsistManagementAppTest {
    public static void main(String[] args) {
        System.out.println("===== UC11 - Regex Validation =====\n");
        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";
        String trainPattern = "TRN-\\d{4}";
        String cargoPattern = "PET-[A-Z]{2}";
        Pattern p1 = Pattern.compile(trainPattern);
        Pattern p2 = Pattern.compile(cargoPattern);
        Matcher m1 = p1.matcher(trainId);
        Matcher m2 = p2.matcher(cargoCode);
        boolean isTrainValid = m1.matches();
        boolean isCargoValid = m2.matches();
        System.out.println("Train ID: " + trainId + " -> " + (isTrainValid ? "Valid" : "Invalid"));
        System.out.println("Cargo Code: " + cargoCode + " -> " + (isCargoValid ? "Valid" : "Invalid"));
    }
}