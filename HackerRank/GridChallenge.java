package HackerRank;

import java.util.*;

public class GridChallenge {


    public static void main(String[] args) {

        Solution solution = new Solution();
        // Hardcoded test cases
        List<String> grid1 = Arrays.asList("abc", "ade", "efg");
        List<String> grid2 = Arrays.asList("zyx", "wvu", "tsr");
        List<String> grid3 = Arrays.asList("a", "b", "c");

        // Test case 1
        System.out.println("Test case 1: " + solution.gridChallengeMethod(grid1)); // Should print "YES"
        
        // Test case 2
        System.out.println("Test case 2: " + solution.gridChallengeMethod(grid2)); // Should print "NO"
        
        // Test case 3
        System.out.println("Test case 3: " + solution.gridChallengeMethod(grid3)); // Should print "YES"
    }

    
}

     /**
     * Checks if a grid of strings can be rearranged such that
     * the columns are lexicographically sorted after sorting each row.
     *
     * @param grid A list of strings representing the grid
     * @return "YES" if columns are sorted after row-wise sorting, otherwise "NO"
     */
class Solution{
     public String gridChallengeMethod(List<String> grid){

    
        // A new list to hold the sorted rows
        List<String> sortedGrid = new ArrayList<>();

        // Sort each string in the grid lexicographically and add to sortedGrid
        for (String stringItem : grid) {
            char[] charList = stringItem.toCharArray(); // Convert string to character array
            Arrays.sort(charList);                     // Sort the character array
            sortedGrid.add(new String(charList));      // Convert back to string and add to list
        }

        // Determine the number of rows and columns in the grid
        int numRows = sortedGrid.size();               // Total rows
        int numCols = sortedGrid.get(0).length();      // Length of the first string (number of columns)

        // Validate that all columns are sorted
        for (int col = 0; col < numCols; col++) {      // Loop through each column
            for (int row = 1; row < numRows; row++) {  // Compare each character with the one above
                if (sortedGrid.get(row).charAt(col) < sortedGrid.get(row - 1).charAt(col)) {
                    return "NO";                      // If any column is unsorted, return "NO"
                }
            }
        }
        
        // If all columns are sorted, return "YES"
        return "YES";
    
     }
}


