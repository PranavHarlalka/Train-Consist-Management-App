import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase13TrainConsistMgmt {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static List<Bogie> generateDataset(int size) {
        List<Bogie> bogies = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            // Alternating capacities to test filtering (72 and 56)
            int capacity = (i % 2 == 0) ? 72 : 56;
            bogies.add(new Bogie("Type" + (i % 5), capacity));
        }
        return bogies;
    }

    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("=== UC13 - Performance Comparison (Loops vs Streams) ===");
        System.out.println("==================================================\n");

        List<Bogie> bogies = generateDataset(1000000);

        // Measure Loop-based execution
        long loopStart = System.nanoTime();
        filterUsingLoop(bogies);
        long loopEnd = System.nanoTime();
        long loopElapsed = loopEnd - loopStart;

        // Measure Stream-based execution
        long streamStart = System.nanoTime();
        filterUsingStream(bogies);
        long streamEnd = System.nanoTime();
        long streamElapsed = streamEnd - streamStart;

        System.out.println("Loop Execution Time (ns): " + loopElapsed);
        System.out.println("Stream Execution Time (ns): " + streamElapsed);

        System.out.println("\nUC13 performance benchmarking completed...");
    }
}