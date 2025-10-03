// 
import java.util.Random;

public class MazeGenerator {
    public static void main(String[] args) {
        int rows = 10, cols = 20;
        char[][] maze = new char[rows][cols];
        Random rand = new Random();

        // fill maze
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = (rand.nextInt(4) == 0) ? '#' : ' '; // 25% walls
            }
        }

        maze[0][0] = 'S'; // start
        maze[rows - 1][cols - 1] = 'E'; // exit

        // print maze
        for (char[] row : maze) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
