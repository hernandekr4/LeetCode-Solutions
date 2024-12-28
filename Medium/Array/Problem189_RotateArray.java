package Medium.Array;

/**
 * 12/25/2024 12:16AM
 * This program rotates an integer array to the right by k steps.
 * 
 * Approach:
 * 1. The program uses an auxiliary array to rearrange elements.
 * 2. For each element in the input array, its new position is calculated as (i + k) % n, 
 *    where n is the length of the array.
 * 3. The rearranged elements are copied back to the original array, modifying it in place.
 * 
 * Complexity:
 * - Time Complexity: O(n), where n is the length of the array.
 * - Space Complexity: O(n), due to the use of an auxiliary array.
 * 
 * Example:
 * Input: nums = [1, 2, 3, 4, 5, 6, 7], k = 3
 * Output: nums = [5, 6, 7, 1, 2, 3, 4]
 */


public class Problem189_RotateArray {
    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 5;

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;

        // Test and print results
        System.out.println("Original Array 1: " + arrayToString(nums1));
        rotate(nums1, k1);
        System.out.println("Rotated Array 1:  " + arrayToString(nums1));
        System.out.println();

        System.out.println("Original Array 2: " + arrayToString(nums2));
        rotate(nums2, k2);
        System.out.println("Rotated Array 2:  " + arrayToString(nums2));
    }

     // Helper method to convert an array to a string for display
     public static String arrayToString(int[] nums) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i < nums.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public static void rotate(int[] nums, int k) {
        //get size
        int n= nums.length;

        int[] temp = new int[n];
        //place elements into temp array with correct shifted index
        for(int i =0; i< n;i++){
            temp[(i+k)%n] = nums[i];
        }

        //copy rearraged elements back 
        for(int i =0; i<n;i++){
            nums[i] = temp[i];
        }

    }




}
