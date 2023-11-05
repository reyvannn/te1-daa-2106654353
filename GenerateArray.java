import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class GenerateArray {
    static void generate(String fileName, int length) {
        int[] result = new int[length];
        Random random = new Random();

        // Random
        for (int i = 0; i < length; i++) {
            result[i] = random.nextInt();
        }
        saveAsTxt(fileName + ".txt", result);

        // Sorted
        Arrays.sort(result);
        saveAsTxt(fileName + "_sorted.txt", result);

        // Reversed
        int start = 0;
        int end = result.length - 1;
        while (start < end) {
            // Swap elements at start and end positions
            int temp = result[start];
            result[start] = result[end];
            result[end] = temp;

            // Move the start and end positions towards the center
            start++;
            end--;
        }
        saveAsTxt(fileName + "_reversed.txt", result);
    }

    private static void saveAsTxt(String fileName, int[] A) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int value : A) {
                writer.write(Integer.toString(value));
                writer.newLine(); // Add a newline separator
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int[] readFromTxt(String fileName) {
        int[] result = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));

            // Determine the length of the array
            int length = (int) reader.lines().count();
            result = new int[length];

            // Reset the reader to read from the beginning of the file
            reader.close();
            reader = new BufferedReader(new FileReader(fileName));

            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                result[i] = Integer.parseInt(line);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
