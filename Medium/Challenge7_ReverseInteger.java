package Medium;

public class Challenge7_ReverseInteger {
    public static void main(String[] args) {
        Reverse solution = new Reverse();
        
        // Test cases
        int[] testCases = {123, -123, 120, 0, 1534236469, -2147483412};

        for (int x : testCases) {
            System.out.println("Input: " + x + " | Output: " + solution.reverse(x));
        }
    }
}


class Reverse {
    
    public int reverse(int x){

        int reversed= 0;

        while(x !=0){
            //extract last digit 
            int lastDigit = x%10;
            //remove last digit 
            x = x/10;

            //check for overflow 32 bit 
            if(reversed> Integer.MAX_VALUE || (reversed == Integer.MAX_VALUE && lastDigit > 7)){
                return 0;
            }

            //check for underflow 32 bit 
            if(reversed < Integer.MIN_VALUE || (reversed == Integer.MIN_VALUE && lastDigit < -8)){
                return 0;
            }

            //update reversed
            reversed = reversed *10 + lastDigit;

       }
      return reversed;
    }
}
