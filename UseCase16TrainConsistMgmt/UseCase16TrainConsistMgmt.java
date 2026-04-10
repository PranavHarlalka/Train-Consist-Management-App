public class UseCase16TrainConsistMgmt {

    // Extracted sorting logic for testability
    public static void bubbleSort(int[] capacities) {
        int n = capacities.length;
        // Outer Loop controls the number of passes
        for (int i = 0; i < n - 1; i++) {
            // Inner Loop performs adjacent comparisons
            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swap values when left element is greater than right element
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("=== UC16 - Manual Sorting using Bubble Sort ===");
        System.out.println("========================================\n");

        // Create array of passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        // Display original order
        System.out.println("Original Capacities:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }
        System.out.println();

        // Apply bubble sort logic
        bubbleSort(capacities);

        // Display sorted result
        System.out.println("\nSorted Capacities (Ascending):");
        for (int c : capacities) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println("\nUC16 sorting completed...");
    }
}