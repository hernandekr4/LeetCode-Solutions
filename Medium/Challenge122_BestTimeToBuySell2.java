package Medium;

public class Challenge122_BestTimeToBuySell2 {
     /**
     * Approach 1: Greedy Approach
     * Steps:
     * 1. Iterate through the prices array.
     * 2. Whenever prices[i] > prices[i - 1], add the difference to the profit.
     * 3. Return the total profit after the loop.
     */
    public static int maxProfitGreedy(int[] prices) {
        int profit = 0;

        // Iterate through the prices array
        for (int i = 1; i < prices.length; i++) {
            // Add profit for every price increase
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        // Return the total accumulated profit
        return profit;
    }

    /**
     * Approach 2: Peak and Valley Approach
     * Steps:
     * 1. Identify all valleys (local minima) and peaks (local maxima).
     * 2. Add the difference between each peak and valley to the total profit.
     * 3. Return the total profit after processing all valleys and peaks.
     */
    public static int maxProfitPeakValley(int[] prices) {
        int profit = 0;
        int i = 0;

        // Traverse the prices array to find valleys and peaks
        while (i < prices.length - 1) {
            // Find the next valley (local minimum)
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            int valley = prices[i]; // Record the valley

            // Find the next peak (local maximum)
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            int peak = prices[i]; // Record the peak

            // Add the difference between peak and valley to profit
            profit += peak - valley;
        }

        // Return the total accumulated profit
        return profit;
    }

    /**
     * Approach 3: Dynamic Programming
     * Steps:
     * 1. Define two variables:
     *    - hold: Max profit if holding stock at the end of the day.
     *    - cash: Max profit if not holding stock at the end of the day.
     * 2. Transition:
     *    - hold = max(hold, cash - prices[i])
     *    - cash = max(cash, hold + prices[i])
     * 3. Return cash, as it's optimal to not hold stock at the end.
     */
    public static int maxProfitDP(int[] prices) {
        int hold = Integer.MIN_VALUE; // Profit when holding a stock
        int cash = 0;                 // Profit when not holding a stock

        // Traverse the prices array
        for (int price : prices) {
            // Transition: Update hold and cash
            hold = Math.max(hold, cash - price); // Buy stock or keep holding
            cash = Math.max(cash, hold + price); // Sell stock or do nothing
        }

        // Return the maximum profit when not holding stock
        return cash;
    }

    public static void main(String[] args) {
        // Test cases
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {1, 2, 3, 4, 5};
        int[] prices3 = {7, 6, 4, 3, 1};

        // Test each approach
        System.out.println("Greedy Approach:");
        System.out.println("Test Case 1: " + maxProfitGreedy(prices1)); // Output: 7
        System.out.println("Test Case 2: " + maxProfitGreedy(prices2)); // Output: 4
        System.out.println("Test Case 3: " + maxProfitGreedy(prices3)); // Output: 0

        System.out.println("\nPeak and Valley Approach:");
        System.out.println("Test Case 1: " + maxProfitPeakValley(prices1)); // Output: 7
        System.out.println("Test Case 2: " + maxProfitPeakValley(prices2)); // Output: 4
        System.out.println("Test Case 3: " + maxProfitPeakValley(prices3)); // Output: 0

        System.out.println("\nDynamic Programming Approach:");
        System.out.println("Test Case 1: " + maxProfitDP(prices1)); // Output: 7
        System.out.println("Test Case 2: " + maxProfitDP(prices2)); // Output: 4
        System.out.println("Test Case 3: " + maxProfitDP(prices3)); // Output: 0
    }
}


