public class GenerateParenthesis {
    public static void Generate(int n, String ans, int open, int close) {
        if (ans.length() == 2 * n) {
            if (open == close)
                System.out.println(ans);
            return;
        }
        if (open < n) {
            Generate(n, ans + "(", open + 1, close);
        }
        if (close < open) {
            Generate(n, ans + ")", open, close + 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        String ans = "";
        int open = 0;
        int close = 0;
        Generate(n, ans, open, close);
    }
}
