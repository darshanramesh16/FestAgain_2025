public class StareReachPattern2 {// Calculates the No. of ways to reach the destination method 2.......
    public static int FindPatterns(int n) {
        if (n < 0)// or a single condition that is if(n<=2)return n;
            return 0;
        if (n == 0)
            return 1;
        if (n == 1)
            return FindPatterns(n - 1);
        return FindPatterns(n - 1) + FindPatterns(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(FindPatterns(n));
    }
}
