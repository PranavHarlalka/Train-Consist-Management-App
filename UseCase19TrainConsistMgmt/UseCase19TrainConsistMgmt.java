import java.util.Arrays;

public class UseCase19TrainConsistMgmt {

    public static boolean binarySearch(String[] bogieIds, String searchId) {
        // Handle empty array safely
        if (bogieIds == null || bogieIds.length == 0) {
            return false;
        }

        // Ensure data is sorted before binary search (precondition)
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = searchId.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                return true; // Match found
            } else if (comparison < 0) {
                high = mid - 1; // Narrow to left half
            } else {
                low = mid + 1; // Narrow to right half
            }
        }
        return false; // Exhausted search range
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("=== UC19 - Binary Search for Bogie ID ===");
        System.out.println("========================================\n");

        // Create array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Ensure data is sorted for display
        Arrays.sort(bogieIds);

        // Search key
        String key = "BG309";

        // Display sorted bogies
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // Apply binary search logic
        boolean found = binarySearch(bogieIds, key);

        // Display result
        System.out.println();
        if (found) {
            System.out.println("Bogie " + key + " found using Binary Search.");
        } else {
            System.out.println("Bogie " + key + " not found using Binary Search.");
        }

        System.out.println("\nUC19 search completed...");
    }
}