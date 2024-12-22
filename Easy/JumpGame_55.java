package Easy;

public class JumpGame_55 {
    public boolean canJump(int[] nums){
        int maxReachable = 0; //tracks farthest reachable index

        //iterate through the array

        for(int i =0; i < nums.length;i++){
            if(i > maxReachable){
                //if the current index is beyond maxReachable, return false
                return false;
            }
            //Update the farthest reachable index, return larger of two values
            maxReachable = Math.max(maxReachable, i+ nums[i]);
        }

        //if the loop completes, the last index is reachable
        return true;

    }
    public class Main {
        public static void main(String[] args) {
            int[] nums1 = {2, 3, 1, 1, 4};
            int[] nums2 = {3, 2, 1, 0, 4};
    
            JumpGame_55 solution = new JumpGame_55();
    
            System.out.println("Test Case 1: " + solution.canJump(nums1)); // Expected: true
            System.out.println("Test Case 2: " + solution.canJump(nums2)); // Expected: false
        }
    }
    
}
