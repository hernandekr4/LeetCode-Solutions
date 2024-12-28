package Easy;


/*
 * Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed 
because you must buy before you sell.
 */


public class Challenge121_BestTimeToBuySellStock {
    
    public static void main(String[] args) {


        // Test case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit (Test Case 1): " + maxProfit(prices1)); // Output: 5

        // Test case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Maximum Profit (Test Case 2): " + maxProfit(prices2)); // Output: 0

        // Test case 3
        int[] prices3 = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println("Maximum Profit (Test Case 3): " + maxProfit(prices3)); // Output: 4

        // Test case 4
        int[] prices4 = {1, 2, 3, 4, 5};
        System.out.println("Maximum Profit (Test Case 4): " + maxProfit(prices4)); // Output: 4
    }

    public static int maxProfit(int[] prices){
        int minPrice =Integer.MAX_VALUE; 
        int maxProfit=0;

        for(int currentPrice: prices){
            if(currentPrice < minPrice){
                minPrice = currentPrice;
            }else if(currentPrice - minPrice > maxProfit){
                maxProfit = currentPrice - minPrice;
            }
                
        }
        return maxProfit;


    }
}

