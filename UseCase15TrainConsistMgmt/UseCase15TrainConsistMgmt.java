public class UseCase15TrainConsistMgmt {

    // Custom Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie model
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        // Assign cargo with safety validation
        void assignCargo(String newCargo) {
            try {
                // Rule: Rectangular bogie cannot carry petroleum
                if (this.shape.equals("Rectangular") && newCargo.equals("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }
                this.cargo = newCargo;
                System.out.println("Cargo assigned successfully -> " + newCargo);
            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Cargo validation completed for " + this.shape + " bogie\n");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("=== UC15 - Safe Cargo Assignment ===");
        System.out.println("========================================\n");

        GoodsBogie cylindricalBogie = new GoodsBogie("Cylindrical");
        cylindricalBogie.assignCargo("Petroleum");

        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");
        rectangularBogie.assignCargo("Petroleum");

        System.out.println("UC15 runtime handling completed...");
    }
}