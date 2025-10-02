public class MazPath {// Calculates the no. of ways to reach destination.........................
    public static long ReachDesPatterns(int i, int j, int n) {
        if (i == n && j == n) {
            return 1;
        } else if (i == n) {
            return ReachDesPatterns(i, j + 1, n);
        } else if (j == n) {
            return ReachDesPatterns(i + 1, j, n);
        }
        long TotalPathFromDown = ReachDesPatterns(i + 1, j, n);
        long TotalPathFromRight = ReachDesPatterns(i, j + 1, n);
        return TotalPathFromDown + TotalPathFromRight;
    }

    public static void main(String[] args) {
        int n = 19;
        int i = 1;
        int j = 1;
        System.out.println("Total no. of ways to reach destination are : " + ReachDesPatterns(i, j, n));
    }
}
