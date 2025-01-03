package Easy;

import java.util.ArrayList;
import java.util.List;



public class Challenge1431_KidsWithGreatestCandles {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // Step 1: Find the maximum candy count
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        // Step 2: Determine if each kid can have the greatest number of candies
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        // Step 3: Return the result
        return result;
    }


public static List<Boolean> kidsWithCandies2(int[] candies, int extraCandies){
    int maxCandies=0;

    for(int candy: candies){
        maxCandies = Math.max(maxCandies, candy);
    }

    List<Boolean> result = new ArrayList<>();

    for(int candy: candies){
        result.add(candy+ extraCandies >= maxCandies);
    }

    return result;

}

    public static void main(String[] args) {
        // Test cases
        System.out.println(kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3)); // Output: [true, true, true, false, true]
        System.out.println(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1)); // Output: [true, false, false, false, false]
        System.out.println(kidsWithCandies(new int[]{12, 1, 12}, 10));    // Output: [true, false, true]
    }
}
