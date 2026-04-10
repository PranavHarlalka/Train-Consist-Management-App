import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseCase11TrainConsistMgmt {

    private static final String TRAIN_ID_REGEX = "^TRN-\\d{4}$";
    private static final String CARGO_CODE_REGEX = "^PET-[A-Z]{2}$";

    public static boolean isValidTrainId(String trainId) {
        if (trainId == null) return false;
        Pattern pattern = Pattern.compile(TRAIN_ID_REGEX);
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    public static boolean isValidCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        Pattern pattern = Pattern.compile(CARGO_CODE_REGEX);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("=== UC11 - Validate Train ID and Cargo Code ===");
        System.out.println("========================================\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isValidTrainId(trainId));
        System.out.println("Cargo Code Valid: " + isValidCargoCode(cargoCode));

        System.out.println("\nUC11 validation completed...");
        scanner.close();
    }
}