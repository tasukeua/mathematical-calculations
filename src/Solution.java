import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow();
    }

    private static int findMin(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow();
    }

    public static double findMedian(List<Integer> numbers) {
        int size = numbers.size();
        if (size % 2 == 0) {
            int middle1 = numbers.get(size / 2 - 1);
            int middle2 = numbers.get(size / 2);
            return (middle1 + middle2) / 2.0;
        } else {
            return numbers.get(size / 2);
        }
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static List<Integer> findLargestSeq(List<Integer> numbers) {
        int start = 0;
        int maxLength = 1;
        int currentStart = 0;
        int currentLength = 1;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > numbers.get(i - 1)) {
                currentLength++;
            } else {
                currentStart = i;
                currentLength = 1;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
                start = currentStart;
            }
        }
        return new ArrayList<>(numbers.subList(start, start + maxLength));
    }

    public static List<Integer> findSmallestSeq(List<Integer> numbers) {
        int start = 0;
        int minLength = 1;
        int currentStart = 0;
        int currentLength = 1;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < numbers.get(i - 1)) {
                currentLength++;
            } else {
                currentStart = i;
                currentLength = 1;
            }

            if (currentLength > minLength) {
                minLength = currentLength;
                start = currentStart;
            }
        }
        return new ArrayList<>(numbers.subList(start, start + minLength));
    }

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        try (
                BufferedReader reader = new BufferedReader(new FileReader("10m.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("mmmals.txt"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line.trim());
                numbers.add(number);
            }

            writer.write("Max: " + findMax(numbers));
            writer.newLine();
            writer.write("Min: " + findMin(numbers));
            writer.newLine();
            writer.write("Median: " + findMedian(numbers));
            writer.newLine();
            writer.write("Average: " + findAverage(numbers));
            writer.newLine();
            writer.write("Largest Sequence: " + findLargestSeq(numbers));
            writer.newLine();
            writer.write("Smallest Sequence: " + findSmallestSeq(numbers));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}