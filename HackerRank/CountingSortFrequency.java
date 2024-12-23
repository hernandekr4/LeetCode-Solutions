package HackerRank;

public class CountingSortFrequency {
    /**
     * The main method serves as the entry point for the program.
     * It demonstrates the usage of the countingSort method by
     * providing an example array and printing the result.
     */
    public static void main(String[] args) {
        // Example input array
        int[] arr = {2, 5, 3, 5, 2};

        // Call the countingSort method and store the result
        int[] frequency = countingSort(arr);

        // Print the resulting frequency array
        for (int count : frequency) {
            System.out.print(count + " ");
        }
    }

    /**
     * The countingSort method calculates the frequency of integers in the input array.
     * 
     * Goal:
     * - Create an array of size 100 to represent the count of integers from 0 to 99.
     * - Iterate through the input array and update the frequency array for each number.
     * 
     * Explanation:
     * - The input numbers themselves act as indices in the frequency array.
     * - Each index stores the count of how many times that number appears in the input.
     * 
     * @param arr The input array of integers (all values in range 0 to 99).
     * @return A frequency array of size 100 where each index represents the count of a number.
     */
    public static int[] countingSort(int[] arr) {
        // Step 1: Initialize the frequency array with 100 elements, all set to 0
        int[] frequency = new int[100];

        // Step 2: Iterate through the input array
        for (int num : arr) {
            // Increment the corresponding index in the frequency array
            frequency[num]++;
        }

        // Step 3: Return the completed frequency array
        return frequency;
    }
}
