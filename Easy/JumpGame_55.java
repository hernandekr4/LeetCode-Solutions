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

    public  boolean canJump2(int[] nums) {
        // Start the backtracking from the first index
        return canJumpFromIndex(0, nums);
    }


    private static boolean canJumpFromIndex(int index, int[] nums) {
        // Base Case: If we have reached or exceeded the last index
        if (index >= nums.length - 1) {
            return true;
        }

        // Calculate the farthest jump possible from the current index
        int maxJump = Math.min(index + nums[index], nums.length - 1);

        // Try every possible jump length from the current position
        for (int nextIndex = index + 1; nextIndex <= maxJump; nextIndex++) {
            // Recursively check if the last index is reachable from the next position
            if (canJumpFromIndex(nextIndex, nums)) {
                return true;
            }
        }

        // If no jump leads to the last index, return false
        return false;
    }

    public boolean canJump3(int[] nums){
        return canJumpFromIndex2(0, nums);
    }

    private static boolean canJumpFromIndex2(int index, int[] nums){
        //base case

        if(index >= nums.length){
            return true;
        }

        int maxJump = Math.min(index+ nums[index], nums.length-1);


        //try every possible jump from current position

        for(int nextIndex = index+1; nextIndex<= maxJump; nextIndex++){
            //check if last position is reachable 
            if(canJumpFromIndex2(index, nums)){
                return true;
            }
        }
        return false;
    }



    public static int canJump4(int[] nums){
        int jumps =0;
        int currentEnd = 0; 
        int farthest = 0;

        for(int i =0; i<nums.length -1; i++){
            farthest = Math.max(farthest, i+ nums[i]);

            if(i == currentEnd){
                currentEnd = farthest;
                jumps++;
            }


            //condition array once we reached the max 

            if(currentEnd >= nums.length-1){
                break;
            }
        }

        return jumps;
    }


    public class Main {
        public static void main(String[] args) {
            int[] nums1 = {2, 3, 1, 1, 4};
            int[] nums2 = {3, 2, 1, 0, 4};
    
            JumpGame_55 solution = new JumpGame_55();
    
            System.out.println("Test Case 1: " + solution.canJump4(nums1)); // Expected: true
            System.out.println("Test Case 2: " + solution.canJump4(nums2)); // Expected: false
        }
    }
    
}
