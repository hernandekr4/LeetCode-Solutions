package Medium;
import java.util.*;

public class Challenge36_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        
        //create 3 sets 
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        //initialize the buckets 

        for(int i =0; i< 9; i++){
            rows[i] = new HashSet<>();
            cols[i]= new HashSet<>();
            boxes[i] = new HashSet<>();
        }


        //Traverse 

        for(int i = 0; i< 9; i++){
            for(int j = 0; j < 9; j++){
                char current = board[i][j];

                //skip empty cells 
                if(current =='.'){
                    continue;
                }

                //calc box index
                // 1/3 =0*3 =0+1/3=0
                int boxIndex = (i/3)*3 + j/3;

                //check uniqueness 
                if(rows[i].contains(current)|| cols[j].contains(current)|| boxes[boxIndex].contains(current)){
                    return false;
                }
                // Add the current number to the respective row, column, and box sets

                rows[i].add(current);
                cols[j].add(current);
                boxes[boxIndex].add(current);

            }
        }


        return true;

    }










    public static void main(String[] args) {
        Challenge36_ValidSudoku validator = new Challenge36_ValidSudoku();
        
        char[][] board1 = {
            {'1','2','.','.','3','.','.','.','.'},
            {'4','.','.','5','.','.','.','.','.'},
            {'.','9','8','.','.','.','.','.','3'},
            {'5','.','.','.','6','.','.','.','4'},
            {'.','.','.','8','.','3','.','.','5'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','.','.','.','.','.','2','.','.'},
            {'.','.','.','4','1','9','.','.','8'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        char[][] board2 = {
            {'1','2','.','.','3','.','.','.','.'},
            {'4','.','.','5','.','.','.','.','.'},
            {'.','9','1','.','.','.','.','.','3'},
            {'5','.','.','.','6','.','.','.','4'},
            {'.','.','.','8','.','3','.','.','5'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','.','.','.','.','.','2','.','.'},
            {'.','.','.','4','1','9','.','.','8'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        
        System.out.println("Board 1 is valid: " + validator.isValidSudoku(board1)); // true
        System.out.println("Board 2 is valid: " + validator.isValidSudoku(board2)); // false
    }
}
