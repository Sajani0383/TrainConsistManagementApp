/*
 * ================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ================================================================
 *
 * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 *
 * Description:
 * This class safely assigns cargo to goods bogies
 * while handling unsafe combinations using structured
 * exception handling blocks.
 *
 * At this stage, the application:
 * - Defines a custom runtime exception
 * - Validates cargo assignment rules
 * - Throws exception for unsafe cargo
 * - Catches and handles the exception
 * - Executes finally block for logging
 *
 * This maps runtime safety handling using try-catch-finally.
 *
 * Author: Developer
 * Version: 1.0
 */
public class TrainConsistManagementApp {
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }
    static class GoodsBogie {
        String shape;
        String cargo;
        GoodsBogie(String shape) {
            this.shape = shape;
        }
        void assignCargo(String cargo) {
            try {
                if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }
                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);
            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Cargo validation completed for " + shape + " bogie");
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("====================================");
        GoodsBogie g1 = new GoodsBogie("Cylindrical");
        g1.assignCargo("Petroleum");
        System.out.println();
        GoodsBogie g2 = new GoodsBogie("Rectangular");
        g2.assignCargo("Petroleum");
        System.out.println();
        System.out.println("UC15 runtime handling completed...");
    }
}