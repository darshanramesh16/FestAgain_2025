public class LogarithmApowB {
    public static int FindApowB(int a, int b) {
        if (b == 0)
            return 1;
        if (b % 2 == 0) {
            return FindApowB(a, b / 2) * FindApowB(a, b / 2);
        } else {
            return FindApowB(a, b / 2) * FindApowB(a, b / 2) * a;
        }
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 5;
        System.out.println(FindApowB(a, b));
    }
}