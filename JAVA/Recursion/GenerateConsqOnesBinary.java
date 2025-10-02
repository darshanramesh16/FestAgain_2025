public class GenerateConsqOnesBinary {// this code generates the binary string which has'nt consequtive one's.........
    public static void GenerateString(int n, String ans) {
        if (ans.length() == n) {
            System.out.println(ans);
            return;
        }
        GenerateString(n, ans + '0');// if 0 choose to come
        if (ans.length() == 0 || ans.charAt(ans.length() - 1) != '1')// if length is 0 or ans does'nt contain the 1 at
                                                                     // last spotted idx.......
            GenerateString(n, ans + '1');// if 1 choose to come
    }

    public static void main(String[] args) {
        int n = 3;
        String ans = "";
        GenerateString(n, ans);
    }
}
