package HackerRank;

public class RecursiveDigitSum {
    public static void main(String[] args) {


        Solution2 solution = new Solution2();
        // Test case 1: Example from the problem statement
        String n1 = "9875";
        int k1 = 4;
        System.out.println("Test case 1: " + solution.superDigit2(n1, k1)); // Expected: 8

        // Test case 2: Single digit input
        String n2 = "5";
        int k2 = 3;
        System.out.println("Test case 2: " + solution.superDigit2(n2, k2)); // Expected: 5

        // Test case 3: Large input with repetitive digits
        String n3 = "123";
        int k3 = 3;
        System.out.println("Test case 3: " + solution.superDigit2(n3, k3)); // Expected: 9

        // Test case 4: Edge case with a very large `n`
        String n4 = "987654321987654321987654321987654321";
        int k4 = 1;
        System.out.println("Test case 4: " + solution.superDigit2(n4, k4)); // Expected: 9

        // Test case 5: Large `k` value
        String n5 = "1";
        int k5 = 100000;
        System.out.println("Test case 5: " + solution.superDigit2(n5, k5)); // Expected: 1

        // Test case 6: Edge case with `n` consisting of all zeros (invalid for this problem, but useful for robustness testing)
        String n6 = "0";
        int k6 = 10;
        System.out.println("Test case 6: " + solution.superDigit2(n6, k6)); // Expected: 0
    }
}


class Solution2{

    public int superDigit(String n, int k ){
        //calc initial sum of digits
        long sum = 0;
        for(char c: n.toCharArray()){
            sum+= Character.getNumericValue(c);
        }

        //mulitple by k, as n  is concateneted k times
        sum*=k;

        return getSuperDigit(sum);
    }

    private static int getSuperDigit(long num){
        if(num < 10){
            return (int) num; //base case  single digit number 
        }
        long nextSum = 0;
        while(num > 0){
            nextSum +=num%10; //extract last digit 
            num = num/10;    //remove last digit 
        }
        return getSuperDigit(nextSum);


        

    }


    public int superDigit2(String n, int k){
        int sum =0;

        for(char c: n.toCharArray()){
            sum+= Character.getNumericValue(c);
        }

        //concatenate it 
        sum*=k;

        return getSuperDigit2(sum);
    }


    public static int getSuperDigit2(long num){
        //base case 
        if(num< 10){
            return (int)num;
        }

        long nextSum =0;

        while (num>0){
            //extract the last digit 
            nextSum += num%10;
            //remove last digit 
            num = num/10;
        }

        return getSuperDigit2(nextSum);

    }


}
