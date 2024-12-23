package HackerRank;

// For each cell (i, j) in the top-left quadrant of the matrix, we calculate the maximum value among 
// its symmetric counterparts in the other three quadrants. The symmetric cells are determined using 
// their indices: (i, j) in the top-left quadrant, (i, 2 * n - j - 1) in the top-right quadrant, 
// (2 * n - i - 1, j) in the bottom-left quadrant, and (2 * n - i - 1, 2 * n - j - 1) in the 
// bottom-right quadrant. We use nested Math.max calls to compute the maximum value from these 
// four cells and add it to the total sum, iterating only over the n x n cells of the top-left quadrant.
//12/23/2024 

import java.util.*;

public class FlippingMatrix {

    public static int flippingMatrix(List<List<Integer>> matrix, int n) {
        int maxSum = 0;

        // Iterate through the upper-left quadrant
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Find the maximum value that can be placed in the cell (i, j)
                maxSum += Math.max(
                    Math.max(matrix.get(i).get(j), matrix.get(i).get(2 * n - j - 1)),
                    Math.max(matrix.get(2 * n - i - 1).get(j), matrix.get(2 * n - i - 1).get(2 * n - j - 1))
                );
            }
        }

        return maxSum;
    }

    public static void outputQuadrant(List<List<Integer>> matrix, int n ){

        for(int i =0; i< n; i++){
            for(int j =0; j< n; j++){
                //output top right element 

            


                System.out.print(" top rigt "+ matrix.get(i).get(j));
                System.out.print(" top left "+ matrix.get(i).get(2*n-j-1));
                System.out.print(" bot left "+ matrix.get(2*n-i-1).get(j));
                System.out.print(" bot right "+ matrix.get(2*n-i-1).get(2*n-j-1));

                System.out.print("\n");

            }
        }

    }

    public static void quadrantOutput2(List<List<Integer>> matrix, int n ){
//i=x j =y
//otherwise x = row & y = col
        for(int i =0; i< n ; i++){
            for(int j =0; j< n;j++){
                System.out.print(" Top right "+ matrix.get(i).get(j)); //[0,0]
                System.out.print(" Top Left" + matrix.get(i).get(2*n-j-1));  //[0,3]
                System.out.print(" Bot left "+ matrix.get(2*n-i-1).get(j)); //[3, 0]
                System.out.print(" Bot right "+ matrix.get(2*n-i-1).get(2*n-j-1)); //[3, 3]

                System.out.println("\n");
            }
        }

    }



    public static void main(String[] args) {
         // Hardcoded queries for testing
         List<List<Integer>> query1 = List.of(
            List.of(1, 2, 3, 4),
            List.of(5, 6, 7, 8),
            List.of(9, 10, 11, 12),
            List.of(13, 14, 15, 16)
        );

        

        List<List<Integer>> query2 = List.of(
            List.of(1, 2),
            List.of(3, 4)
        );

        // Test cases
        System.out.println("Testing hardcoded queries:");

        /*  First Query: n = 2
        int n1 = 2;
        int result1 = flippingMatrix(query1, n1);
        System.out.println("Maximum sum for Query 1: " + result1);
        */
        // Second Query: n = 1
        /* 
        int n2 = 1;
        int result2 = flippingMatrix(query2, n2);
        System.out.println("Maximum sum for Query 2: " + result2);
        */

        //testing query 
        int n3 = 2;
        quadrantOutput2(query1, n3);



    
    }
}
