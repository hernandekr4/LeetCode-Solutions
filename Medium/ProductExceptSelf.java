package Medium;
import java.util.*;
public class ProductExceptSelf {



    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];

        //fill in the prefix products, and start with first index as 1 

        //prefix[1] should equal the product of prefix[0]* nums[0];
        prefix[0]=1;
        for(int i =1; i< n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        //set the last index as 1 
        suffix[n-1]= 1;
        //suffix[2]= last num in nums, * the last value in suffix which we defaulted to 1
        //first cycle j =2; we want suffix[2]= nums[3]*suffix[3] 
        //j =1
        // j =0;
        for(int j =nums.length-2; j>=0 ; j--){
            suffix[j] = nums[j+1]* suffix[j +1];
        }

        //populate result 
        //we want to multiple suffix[n]* prefix[n] = product of index n 
        //four iterations 
        //first cycle i =0; prefix[0]* suffix[0]
        //i=1;
        //i=2;
        //stops at i=3
        for(int i=0; i< nums.length; i++){  
            result[i]= prefix[i] * suffix[i];
        }  
        return result;

    }


    public static void main(String[] args){
        int[] arr = {1, 2, 4, 6,};
        int[] result = productExceptSelf(arr);
        System.out.print(Arrays.toString(result));
    }
}
