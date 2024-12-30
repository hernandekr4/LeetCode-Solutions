package Medium;

public class Challeneg238_ProductOfArrayExceptSelf {

    public static int[] productExceptSelfOptimized(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Compute prefix products
        result[0] = 1; // No left product for the first element
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
    
        // Compute suffix products on the fly and update result
        int suffix = 1; // No right product for the last element
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix; // Multiply the current result with the suffix product
            suffix *= nums[i]; // Update the suffix product
        }
    
        return result;
    }


    public static int[] productExceptSelfWithTwoArrays(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];
    
        // Build prefix product
        prefix[0] = 1; // No left product for the first element
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
    
        // Build suffix product
        suffix[n - 1] = 1; // No right product for the last element
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
    
        // Compute result
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }
    
        return result;
    }



    public static int[] productExceptSelfWithTwoArrays2(int[] nums){
        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];


        prefix[0] =1;
        for(int i =1; i< n;i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }


        suffix[n-1]=1; //setting last element as val of 1 

        for(int i = n-2 ; i>=0; i--){
            suffix[i] =suffix[i+1] *nums[i+1];
        }

        //compute result 

        for(int i = 0; i < n;i++){
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }


    public static int[] productExceptSelfWithTwoArrays3(int[] nums){
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        left[0]= 1;

        for(int i =1; i< n; i++){
            left[i] = left[i-1]* nums[i-1];
        }

        right[nums.length-1] =1;

        for(int i = nums.length -2; i>-1; i--){
            right[i] = right[i+1]* nums[i+1];
        }


        for(int i =0; i<n;i++){
            result[i] = left[i]* right[i];
        }

        return result;





    }

    

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {-1, 1, 0, -3, 3};
    
        System.out.println("Testing Approach 1 (Two Arrays):");
        System.out.println("Input: [1, 2, 3, 4]");
        printArray(productExceptSelfWithTwoArrays(nums1)); // Output: [24, 12, 8, 6]
        System.out.println("Input: [-1, 1, 0, -3, 3]");
        printArray(productExceptSelfWithTwoArrays(nums2)); // Output: [0, 0, 9, 0, 0]
    
        System.out.println("\nTesting Approach 2 (Optimized Space):");
        System.out.println("Input: [1, 2, 3, 4]");
        printArray(productExceptSelfOptimized(nums1)); // Output: [24, 12, 8, 6]
        System.out.println("Input: [-1, 1, 0, -3, 3]");
        printArray(productExceptSelfOptimized(nums2)); // Output: [0, 0, 9, 0, 0]
    }
    
    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    


}
