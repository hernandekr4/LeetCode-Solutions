import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Instantiate the Solution class
        Solution solution = new Solution();

        // Example array of numbers
        int[] nums1 = {2, 7, 11, 15};

        // Target sum we are looking for
        int target1 = 9;
        // Call the twoSum method and store the result
        int[] result1 = solution.twoSum(nums1, target1);

        // Output the indices of the two numbers that add up to the target sum
        System.out.println("Indices at target " + target1 + ":  [" + result1[0] + " , " + result1[1] + " ]");
    }
}

class Solution {
    // Method to find two indices such that the numbers at those indices add up to a specific target
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store number and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // Calculate complement of current element
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If it exists, return the indices of the current element and the complement
                return new int[]{map.get(complement), i};
            }

            // If not, put the current element and its index in the map
            map.put(nums[i], i);
        }

        // Return an empty array if no two sum solution is found
        return new int[]{};
    }
}



/*Create an Instance: Create an instance of the Solution class.
* Define Input Array and Target: Initialize an array nums1 and a target integer target1.
* Call twoSum Method: Use the twoSum method of the Solution class to find the indices of the two numbers that add up to target1.
* Print the Result: Print the indices of the two numbers that add up to the target.*/
