package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class CountingSortFrequency {

    /**
     * The main method serves as the entry point for the program.
     * It demonstrates the usage of the countingSort method by
     * providing an example list and printing the result.
     */
    public static void main(String[] args) {
        // Example input list
        List<Integer> arr = List.of(2, 5, 3, 5, 2);

        // Call the countingSort method and store the result
        List<Integer> frequency = countingSort(arr);

        // Print the resulting frequency list
        System.out.println(frequency);
    }

    /**
     * The countingSort method calculates the frequency of integers in the input list.
     * 
     * Goal:
     * - Create a List of size 100 to represent the count of integers from 0 to 99.
     * - Iterate through the input list and update the frequency list for each number.
     * 
     * Explanation:
     * - The input numbers themselves act as indices in the frequency list.
     * - Each index stores the count of how many times that number appears in the input.
     * 
     * @param arr The input list of integers (all values in range 0 to 99).
     * @return A frequency list of size 100 where each index represents the count of a number.
     */
    public static List<Integer> countingSort(List<Integer> arr) {
        // Step 1: Initialize the frequency list with 100 elements, all set to 0
        List<Integer> frequency = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            frequency.add(0);
        }

        // Step 2: Iterate through the input list
        for (int num : arr) {
            // Increment the corresponding index in the frequency list
            frequency.set(num, frequency.get(num) + 1);
        }

        // Step 3: Return the completed frequency list
        return frequency;
    }
}
