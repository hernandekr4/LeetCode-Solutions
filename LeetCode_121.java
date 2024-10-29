public class LeetCode_121{

    public static void main(String[] args){
        Solution solution = new Solution();

        int[] prices1 ={7, 1, 5, 3, 6, 4};
        int result1 = solution.maxProfit(prices1);

        System.out.println("Max Profit for test case 1: "+ result1);

        int[] prices2 = {7, 6, 4, 3, 1};

        int result2 = solution.maxProfit(prices2);

        System.out.println("Max Profit for test case 2: "+ result2);



    }

}


class Solution{
    public int maxProfit(int[] prices){
        int maxProfit =0; //initialize maxProfit to zero
        int minPrice = Integer.MAX_VALUE; //Start with the highest possible price

        //Iterate through each price in the prices array
        for(int i =0; i< prices.length; i++){
            if(prices[i] < minPrice){
                //update the minimum price to the current price if its lower 
                minPrice = prices[i];
            }else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }

        }
        return maxProfit;


    }
}