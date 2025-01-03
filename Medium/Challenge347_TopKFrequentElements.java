package Medium;

import java.util.*;

public class Challenge347_TopKFrequentElements {

    /* 
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // Example for nums = [1, 2, 2, 3, 3, 3]:
        // freqMap = {1=1, 2=2, 3=3}

        // Step 2: Create buckets
        // Array of lists where index represents frequency
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 3: Fill buckets
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].add(num); // Add the number to its frequency bucket
        }
        // Example:
        // buckets = [[], [1], [2], [3], [], ...]

        // Step 4: Collect the top k frequent elements
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            for (int num : buckets[i]) {
                result.add(num); // Add numbers from the bucket
                if (result.size() == k) {
                    break; // Stop when we have collected k elements
                }
            }
        }

        // Convert result to array and return
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
*/
    

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 2, 2, 3, 3, 3};
        int k1 = 2;
        System.out.println(Arrays.toString(new Challenge347_TopKFrequentElements().topKFrequent3(nums1, k1)));
        // Output: [2, 3] (order may vary)

        // Test case 2
        int[] nums2 = {7, 7};
        int k2 = 1;
        System.out.println(Arrays.toString(new Challenge347_TopKFrequentElements().topKFrequent3(nums2, k2)));
        // Output: [7]
    }


    public int[] topKFrequent2(int[] nums, int k) {
        
        //count the frequency 
        Map<Integer, Integer> freqMap2 = new HashMap<>();

        for(int num: nums ){

            //for num we are going to put the current value of frequencies +1 or return 0 and add 1
            freqMap2.put(num, freqMap2.getOrDefault(num, 0)+1);
        }

        //step 2 initiliaze buckets 
        //It’s one array (buckets).Each slot in this array (buckets[i]) will eventually hold an individual list (like an ArrayList).
       // The buckets variable is an array of lists, where each list is specifically a List<Integer> that can store integers.
        List<Integer>[] buckets = new List[nums.length+1];

        for(int i =0; i<= nums.length;i++){
            buckets[i] = new ArrayList<>();
        }

        //step 3 fill the arrays 
        //Iterate over the key-value pairs of a map, and Provides a way to access both the key and the value for each entry.

        for(Map.Entry<Integer, Integer> entry: freqMap2.entrySet()){
            int num = entry.getKey();
            int frequency = entry.getValue();

            buckets[frequency].add(num);
        }


        //step 4 extract top K elements 
        //start from the highest frequency and the highest and first added to result will be our answer
        List<Integer> result = new ArrayList<>();
        for(int i = buckets.length-1; i>=0 && result.size()<k; i--){
            for(int num: buckets[i]){
                result.add(num);
                if(result.size() ==k){
                    break;
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }



    public int[] topKFrequent3(int[] nums, int k) {

        //step 1 get the frequencies 
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            //(Number, frequency) key pair
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        

        //inititalize the empty buckets 
        List<Integer>[] buckets = new List[nums.length+1];
        for(int i =0; i<= nums.length; i++){
            buckets[i] = new ArrayList<>();
        }


        //step 3 fill the buckets 
        //the index is frequency for the bucket inside these buckets are nums that have the same frequency
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            int num = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].add(num);
        }

        //step 4 get Top K most frequent numbers 
        List<Integer> result = new ArrayList<>();
        for(int i = buckets.length-1; i>=0 && result.size() < k; i-- ){
            for(int num: buckets[i]){
                result.add(num);
                if(result.size() ==k ){
                    break;
                }
            }
        }

        return result.stream().mapToInt(Integer:: intValue).toArray();


    }

}
