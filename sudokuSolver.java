import java.util.Arrays;
//using backtracking

public class sudokuSolver {
    public static void main(String[] args) {
        char[][] sudoku = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        if (helper(sudoku, 0, 0)) {
            print(sudoku);
        } else {
            System.out.println("Solution does not exist!!!");
        }
    }

    private static void print(char[][] sudoku) {
        for (char[] row : sudoku) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static boolean helper(char[][] sudoku, int row, int col) {

        // If we've reached the end of the row, the puzzle is solved
        if (row == 9) {
            return true;
        }

        // If col == 9, move to the next row
        if (col == 9) {
            return helper(sudoku, row + 1, 0);
        }

        // If the current cell is already filled, move to the next cell
        if (sudoku[row][col] != '.') {
            return helper(sudoku, row, col + 1);
        }

        // Try placing digits from 1 to 9 in the current cell
        for (int k = 1; k <= 9; k++) {
            char ch = (char) (k + '0');
            if (isSafe(sudoku, row, col, ch)) {
                sudoku[row][col] = ch;
                if (helper(sudoku, row, col + 1)) {
                    return true;
                }
                sudoku[row][col] = '.';
            }
        }

        return false;
    }

    private static boolean isSafe(char[][] sudoku, int row, int col, char ch) {

        // Check the row
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == ch) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == ch) {
                return false;
            }
        }

        // Check the 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == ch) {
                    return false;
                }
            }
        }

        return true;
    }
}















