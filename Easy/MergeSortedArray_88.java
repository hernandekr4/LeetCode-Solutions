package Easy;

import java.util.Arrays;

public class MergeSortedArray_88 {
    

    /*Merge two arrays and sorts resultant array, not optimal takes O((m+n )log(m+n)) complexity 
     * Time Complexity: 
𝑂((𝑚+𝑛)log(𝑚+𝑛))
O((m+n)log(m+n)) due to sorting.
Space Complexity: 𝑂(1)O(1) as the merging happens in-place.
    */
    public void mergeApproach01(int[] nums1, int m, int[] nums2, int n){
        //copy elements from nums2 to nums1

        for(int i =0; i < n; i++){
            nums1[m+i] = nums2[i];
        }

        //sort nums1
        Arrays.sort(nums1);


    }
    /*Merge into temporary array , then copy elements back to nums1 
     * Time Complexity: 
𝑂(𝑚+𝑛)O(m+n) since we traverse both arrays once.
Space Complexity: 
𝑂(𝑚+𝑛)
O(m+n) due to the temporary array.
Uses extra space for a temporary array.

    */
    public void mergeApproach02(int[] nums1, int m, int[] nums2, int n){
        int[] temp = new int[m+n];
        int i =0, j=0, k =0;

        //Merge nums1 and nums2 into temp 
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }

        }

        //Copy remaining elements from nums1
        while(i < m ){
            temp[k++] = nums1[i++];
        }

        //cope remaining elements from nums 2

        while(j < n){
            temp[k++] = nums2[i++];
        }

        //copy temp back to temp1

        System.arraycopy(temp,0,nums1,0,m+n);


    }


    /*This approach merges the arrays directly in nums1 starting from the back, avoiding the need for additional space.
     * Time Complexity: 𝑂(𝑚+𝑛)
O(m+n) since each element is processed exactly once.
Space Complexity: 𝑂(1)O() as everything is done in-place.
Most efficient, no extra space used.
     */
    public void mergeApproach03(int[] nums1, int m, int[] nums2, int n){
        int p1 = m-1; //pointer for nums1 actual elements
        int p2 = n-1; //pointer for nums2 
        int p = m+n -1;// pointer for merged array(total length -1)

        //Merge nums 1 and nums2 from the back 
        //process arrays from end to the beginning 
        while(p1>=0 && p2>=0){
            //compare elements 
            if(nums1[p1]> nums2[p2]){
                //if nums1's element is larger, place current position in nums1
                nums1[p] = nums1[p1];
                p1--; //move pointer p1 to the left
            } else{
                //if nums2 element is larger or equal, place it at the current position
                nums1[p] = nums2[p2];
                p2--; //move the pointer p2 to the left 
            }
            p--; //Move the merge pointer to the left
        }

        //if nums2 still has elements left(nums1 elements are already in place)
        while(p2>=0){
            nums1[p] =nums2[p2];
            p2--; //move pointer p2 to the left
            p--;    // move the merge pointer to the left

        }

        //No need to handle the case where nums1 has remaining elements
        //as they are already in the correct place


    }



    public static void main(String[] args){
        // Test case 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        // Create an instance of the MergeSortedArrayInPlace class
        MergeSortedArray_88 merger = new MergeSortedArray_88();
        
        // Call the merge method
        merger.mergeApproach03(nums1, m, nums2, n);

        // Print the result
        System.out.print("Test Case 1 Result: ");
        printArray(nums1);

        // Test case 2
        int[] nums1_2 = {1};
        int m2 = 1;
        int[] nums2_2 = {};
        int n2 = 0;

        merger.mergeApproach03(nums1_2, m2, nums2_2, n2);
        System.out.print("Test Case 2 Result: ");
        printArray(nums1_2);

        // Test case 3
        int[] nums1_3 = {0};
        int m3 = 0;
        int[] nums2_3 = {1};
        int n3 = 1;

        merger.mergeApproach03(nums1_3, m3, nums2_3, n3);
        System.out.print("Test Case 3 Result: ");
        printArray(nums1_3);
    }

    // Helper method to print the array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

    }


}
