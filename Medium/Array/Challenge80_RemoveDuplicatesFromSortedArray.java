package Medium.Array;

public class Challenge80_RemoveDuplicatesFromSortedArray {
    


    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] nums3 = {1, 1, 2, 2, 2, 3, 3, 3, 4};
        
        // Test the method and print results
        test(nums1);
        test(nums2);
        test(nums3);
    }

    // Method to test the sliding window approach
    public static void test(int[] nums) {
        System.out.println("Original Array: " + arrayToString(nums));
        
        // Call the removeDuplicates method
        int newLength = removeDuplicates(nums);
        
        // Print the modified array and the new length
        System.out.println("Modified Array: " + arrayToString(nums, newLength));
        System.out.println("New Length: " + newLength);
        System.out.println("--------------------------------");
    }

    // Helper method to convert the array to a string for easier visualization
    public static String arrayToString(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i < nums.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Helper method to display the array up to the given length
    public static String arrayToString(int[] nums, int length) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < length; i++) {
            sb.append(nums[i]);
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public static int removeDuplicates(int[] nums){
        int i =0;

        for(int num : nums){
            if(i<2 || nums[i-2]!= num ){
                nums[i++] = num;
                i++;

            }
        }
        return i;


    }
    
}
