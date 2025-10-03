// 
import java.util.Random;

public class SudokuGenerator {
    public static void main(String[] args) {
        int[][] board = new int[9][9];
        Random rand = new Random();

        // Fill diagonal 3x3 boxes with random numbers
        for (int k = 0; k < 9; k += 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int num;
                    do {
                        num = rand.nextInt(9) + 1;
                    } while (containsInBox(board, k, k, num));
                    board[i + k][j + k] = num;
                }
            }
        }

        // Print the Sudoku grid
        for (int[] row : board) {
            for (int n : row) {
                System.out.print((n == 0 ? "." : n) + " ");
            }
            System.out.println();
        }
    }

    static boolean containsInBox(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + row][j + col] == num) return true;
            }
        }
        return false;
    }
}
