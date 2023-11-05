import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] data;
        data = GenerateArray.readFromTxt("2^16_reversed.txt");
        testShellSort(data);
        testHeapSort(data);
    }

    private static void testShellSort(int[] data) {
        long startTime = 0;
        long totalMemory = 0;

        for (int i = 0; i <= 100; i++) {
            if (i == 1) {
                startTime = System.currentTimeMillis(); // Start timing after the first iteration
            }
            int[] sorted = ShellSort.randomizedShellSort(data);

            // Calculate memory usage after each iteration
            Runtime runtime = Runtime.getRuntime();
            long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
            totalMemory += memoryUsed;
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        double avgTime = (double) totalTime / 100;
        double avgMemory = (double) totalMemory / 100 / 1024; // Convert from bytes to kilobytes

        System.out.println("Average Memory Usage: " + avgMemory + " KB");
        System.out.println("Average Execution Time: " + avgTime + " ms");
    }

    private static void testHeapSort(int[] data) {
        long startTime = 0;
        long totalMemory = 0;

        for (int i = 0; i <= 100; i++) {
            if (i == 1) {
                startTime = System.currentTimeMillis(); // Start timing after the first iteration
            }
            int[] sorted = HeapSort.sort(data);

            // Calculate memory usage after each iteration
            Runtime runtime = Runtime.getRuntime();
            long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
            totalMemory += memoryUsed;
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        double avgTime = (double) totalTime / 100;
        double avgMemory = (double) totalMemory / 100 / 1024; // Convert from bytes to kilobytes

        System.out.println("Average Memory Usage: " + avgMemory + " KB");
        System.out.println("Average Execution Time: " + avgTime + " ms");
    }
}
