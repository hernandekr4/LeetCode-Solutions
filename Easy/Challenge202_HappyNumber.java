package Easy;

import java.util.HashSet;
import java.util.Set;

public class Challenge202_HappyNumber {
    
    public boolean isHappy(int n){
        Set<Integer> mySet = new HashSet<>();
        
        while(n !=1 && !mySet.contains(n)){
            mySet.add(n);
            n = calcSquareSum(n);
        }

        return n ==1;
        
    }


    public int calcSquareSum(int n ){
            int sum =0;

            while(n>0){
                int digit = n %10; //take last digit 
                sum += digit * digit; //and multiply it by itself
                n = n/10; //remove last digit
            }
           return sum;
    }


    public static void main(String[] args){
        Challenge202_HappyNumber solution = new Challenge202_HappyNumber();

        int[] testCases = {1, 7, 10, 56, 32, 19};

        for(int n: testCases){
            System.out.println("Input "+ n + " is Happy? "+ solution.isHappy(n));
        }
    }

}
