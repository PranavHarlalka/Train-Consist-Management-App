import java.util.Arrays;

public class UseCase17TrainConsistMgmt {

    public static void sortBogies(String[] bogies) {
        Arrays.sort(bogies);
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("=== UC17 - Sort Bogie Names Using Arrays.sort() ===");
        System.out.println("=================================================\n");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        sortBogies(bogieNames);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");
    }
}