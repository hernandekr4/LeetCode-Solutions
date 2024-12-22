package Hard;
/*Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5. */
public class Challenge4_MedianTwoSortedArrays {

    public static void main(String[] args) {
        Challenge4_MedianTwoSortedArrays solution = new Challenge4_MedianTwoSortedArrays();

        // Test Case 1: Odd total length
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double median1 = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median of nums1 and nums2: " + median1); // Expected: 2.0

        // Test Case 2: Even total length
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        double median2 = solution.findMedianSortedArrays(nums3, nums4);
        System.out.println("Median of nums3 and nums4: " + median2); // Expected: 2.5

        // Test Case 3: Unequal size arrays
        int[] nums5 = {1, 3, 8};
        int[] nums6 = {7, 9, 10, 12};
        double median3 = solution.findMedianSortedArrays(nums5, nums6);
        System.out.println("Median of nums5 and nums6: " + median3); // Expected: 8.0

        // Test Case 4: One array is empty
        int[] nums7 = {};
        int[] nums8 = {2, 3};
        double median4 = solution.findMedianSortedArrays(nums7, nums8);
        System.out.println("Median of nums7 and nums8: " + median4); // Expected: 2.5

        // Test Case 5: Arrays with the same elements
        int[] nums9 = {1, 1, 1};
        int[] nums10 = {1, 1};
        double median5 = solution.findMedianSortedArrays(nums9, nums10);
        System.out.println("Median of nums9 and nums10: " + median5); // Expected: 1.0

        // Test Case 6: Larger array sizes
        int[] nums11 = {1, 2, 3, 4, 5};
        int[] nums12 = {6, 7, 8, 9, 10};
        double median6 = solution.findMedianSortedArrays(nums11, nums12);
        System.out.println("Median of nums11 and nums12: " + median6); // Expected: 5.5
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length; // Length of the smaller array
        int n = nums2.length; // Length of the larger array
        int low = 0, high = m; // Binary search range on nums1

        while (low <= high) {
            int partition1 = (low + high) / 2; // Partition index for nums1
            int partition2 = (m + n + 1) / 2 - partition1; // Partition index for nums2

            // Edge values around the partitions
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            // Check if the partitions are valid
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If total length is even
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    // If total length is odd
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // Move partition1 to the left
                high = partition1 - 1;
            } else {
                // Move partition1 to the right
                low = partition1 + 1;
            }
        }

        // If no valid partition is found, throw an exception
        throw new IllegalArgumentException("Input arrays are not valid.");
    }
    
}
