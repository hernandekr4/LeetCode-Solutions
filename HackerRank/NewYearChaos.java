package HackerRank;
import java.util.*;
import java.util.stream.*;


public class NewYearChaos {
    public static void main(String[] args) {
        // Test cases
        List<Integer> testCase1 = Arrays.asList(2, 1, 5, 3, 4); // Expected: 3
        List<Integer> testCase2 = Arrays.asList(2, 5, 1, 3, 4); // Expected: Too chaotic
        List<Integer> testCase3 = Arrays.asList(1, 2, 3, 4, 5); // Expected: 0
        List<Integer> testCase4 = Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4); // Expected: 7

        // Print and test Approach 1: Brute Force
        System.out.println("Approach 1: Brute Force");
        System.out.println("Test Case 1:");
        minimumBribesBruteForce(testCase1);
        System.out.println("Test Case 2:");
        minimumBribesBruteForce(testCase2);
        System.out.println("Test Case 3:");
        minimumBribesBruteForce(testCase3);
        System.out.println("Test Case 4:");
        minimumBribesBruteForce(testCase4);

        // Print and test Approach 2: Bubble Sort Simulation
        System.out.println("\nApproach 2: Bubble Sort Simulation");
        System.out.println("Test Case 1:");
        minimumBribesBubbleSort2(testCase1);
        System.out.println("Test Case 2:");
        minimumBribesBubbleSort2(testCase2);
        System.out.println("Test Case 3:");
        minimumBribesBubbleSort2(testCase3);
        System.out.println("Test Case 4:");
        minimumBribesBubbleSort2(testCase4);
    }


    /**
 * Approach 2: Bubble Sort Simulation
 * Mechanics:
 * 1. Simulate a limited bubble sort to count the total number of swaps (bribes).
 * 2. Loop through the queue from the end to the start:
 *    - If a person has moved more than 2 positions forward, print "Too chaotic" and exit.
 *    - Only compare the current person with the last 2 possible positions they could have bribed.
 * 3. Count how many times someone with a higher sticker number (q[j]) is ahead of the current person (q[i]).
 * 4. Return the total number of swaps (bribes) at the end.
 */
public static void minimumBribesBubbleSort(List<Integer> q) {
    int totalBribes = 0; // Tracks the total number of bribes

    // Loop backward through the queue
    for (int i = q.size() - 1; i >= 0; i--) {
        // Check if this person has moved more than 2 positions forward
        if (q.get(i) - (i + 1) > 2) {
            System.out.println("Too chaotic"); // Invalid state
            return;
        }

        // Count how many bribes this person received
        // Only check the last 2 positions they could have bribed
        for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
            if (q.get(j) > q.get(i)) {
                totalBribes++; // Increment bribe count when someone overtakes them
            }
        }
    }

    // Print the total number of bribes
    System.out.println(totalBribes);
}

public static void minimumBribesBubbleSort2(List<Integer> list){
    int totalBrides2 =0;

    //start from the end of the queue

    for(int i =list.size()-1;i>=0;i-- ){
        //check if person has moved for more than two positions 

        if(list.get(i) - (i+1) > 2){
            System.out.println("Too chaotic"); // Invalid state
            return;
        }

        for(int j = Math.max(0, list.get(i)-2); j<i;j++){
            if(list.get(j)> list.get(i)){
                totalBrides2++;
            }
        }
    }
}



/**
 * Approach 1: Brute Force
 * Mechanics:
 * 1. Loop through the queue and check if any person has moved more than 2 positions forward.
 *    - If yes, print "Too chaotic" and exit.
 * 2. For each person in the queue:
 *    - Count how many people with higher sticker numbers (q[j] > q[i]) are in front of them.
 *    - Only check the last 2 possible positions where bribes could have occurred.
 * 3. Return the total number of bribes at the end.
 */
public static void minimumBribesBruteForce(List<Integer> q) {
    int totalBribes = 0; // Tracks the total number of bribes

    // Loop through each person in the queue
    for (int i = 0; i < q.size(); i++) {
        // Check if this person has moved more than 2 positions forward
        if (q.get(i) - (i + 1) > 2) {
            System.out.println("Too chaotic"); // Invalid state
            return;
        }

        // Count the number of bribes this person received
        // We only check from their original position - 2 (or 0 if out of bounds) to their current position
        for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
            if (q.get(j) > q.get(i)) {
                totalBribes++; // Increment bribe count when someone overtakes them
            }
        }
    }

    // Print the total number of bribes
    System.out.println(totalBribes);
}


}


