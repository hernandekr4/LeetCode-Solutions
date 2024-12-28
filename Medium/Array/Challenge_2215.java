package Medium.Array;

import java.util.*;

public class Challenge_2215 {


    public static void main(String[] args){
        Solution sol1 = new Solution();

        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {1, 1, 2, 2};

        List<List<Integer>> result = sol1.findDifference(nums1, nums2);

        System.out.println(result);
    }
    
}


class Solution{
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2){

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2= new HashSet<>();

        for(int num: nums1) set1.add(num);
        for(int num: nums2) set2.add(num);

        //prepare the answers lists

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();


        // Find numbers in nums1 not in nums2

        for(int num : set1){
            if(!set2.contains(num)){
                list1.add(num);
            }

        }

        //Find numbers in nums2 not in nums2

        for(int num: set1){
            if(!set1.contains(num)){
                list2.add(num);
            }
        }


        //prepare final answer list of lists

        List<List<Integer>> answer = new ArrayList<>();

        answer.add(list1);
        answer.add(list2);

        return answer;

    }
}
