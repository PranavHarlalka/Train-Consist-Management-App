public class UseCase20TrainConsistMgmt {

    public static boolean searchBogie(String[] bogieIds, String searchId) {
        // FAIL-FAST VALIDATION
        // Check if train has bogies before performing search
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        // SEARCH LOGIC (executes only if data exists)
        boolean found = false;
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("=== UC20 - Exception Handling During Search ===");
        System.out.println("========================================\n");

        // Create bogie array (empty train scenario)
        String[] bogieIds = {};

        // Search key
        String searchId = "BG101";

        // This will trigger the IllegalStateException and crash the program intentionally
        // to demonstrate unchecked runtime exceptions as requested.
        boolean isFound = searchBogie(bogieIds, searchId);

        // The following lines will not execute if the exception is thrown
        if (isFound) {
            System.out.println("Bogie found.");
        }

        System.out.println("\nUC20 execution completed...");
    }
}