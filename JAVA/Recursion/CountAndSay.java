public class CountAndSay {
    public static String compress(String s) {
        int count = 0;
        int i = 0, j = 0;
        StringBuilder str = new StringBuilder();
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                count++;
                j++;
            } else {
                str.append(count);
                str.append(s.charAt(i));
                count = 0;
                i = j;
            }
        }
        str.append(count);
        str.append(s.charAt(i));
        return str.toString();
    }

    public static String CountKaro(int n, StringBuilder ans) {
        if (n == 1) {
            ans.append("1");
            return ans.toString();
        }
        return compress(CountKaro(n - 1, ans));
    }

    public static void main(String[] args) {
        int n = 4;
        StringBuilder ans = new StringBuilder();
        System.out.println(CountKaro(n, ans));
    }
}
