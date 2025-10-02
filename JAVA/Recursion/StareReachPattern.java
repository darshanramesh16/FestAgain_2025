public class StareReachPattern {
    public static int FindPatterns(int i, int n) {
        int count = 0;
        if (i > n)// if reach outside then return......
            return 0;
        if (i == n) {// if reach destination then print the pattern....
            return 1;
        }
        if (i == n - 1) {// if n-1 then can go only 1 position forward..........
            return FindPatterns(i + 1, n);
        }
        int a = FindPatterns(i + 1, n);// move 1 step..........
        int b = FindPatterns(i + 2, n);// move 2 step................
        return a + b;
    }

    public static void main(String[] args) {
        int n = 5;
        int i = 0;
        System.out.println(FindPatterns(i, n));
    }
}
