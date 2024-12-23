package HackerRank;

import java.util.List;

public class DiagonalMatrixDifference {
    public static void main(String[] args) {
        // Test Case 1
        List<List<Integer>> matrix1 = List.of(
            List.of(11, 2, 4),
            List.of(4, 5, 6),
            List.of(10, 8, -12)
        );
        System.out.println("Test Case 1 Result: " + diagonalDifference(matrix1)); // Expected Output: 15

        // Test Case 2
        List<List<Integer>> matrix2 = List.of(
            List.of(1, 2, 3),
            List.of(4, 5, 6),
            List.of(7, 8, 9)
        );
        System.out.println("Test Case 2 Result: " + diagonalDifference(matrix2)); // Expected Output: 0

        // Test Case 3
        List<List<Integer>> matrix3 = List.of(
            List.of(1, 0, 0),
            List.of(0, 1, 0),
            List.of(0, 0, 1)
        );
        System.out.println("Test Case 3 Result: " + diagonalDifference(matrix3)); // Expected Output: 2

        // Test Case 4
        List<List<Integer>> matrix4 = List.of(
            List.of(3)
        );
        System.out.println("Test Case 4 Result: " + diagonalDifference(matrix4)); // Expected Output: 0 (Single-element matrix)
    }


    public static int diagonalDifference(List<List<Integer>> a){

        int n = a.size(); //size of matrix 
        int leftToRightDiagonal =0;
        int rightToLeftDiagonal =0;


        for(int i =0; i< n;i++){
            leftToRightDiagonal += a.get(i).get(i);
            rightToLeftDiagonal += a.get(i).get(n-i-1);
        }

        return Math.abs(rightToLeftDiagonal - leftToRightDiagonal);

    }
}
