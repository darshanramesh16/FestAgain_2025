public class IncreasingSeqOfLenK {// in this code we will print the increasing sequence of n natural numbers of
                                  // length k........
    public static void PrintSeq(int i, int n, String ans, int k) {
        if (i > n) {
            if (ans.length() == k)
                System.out.println(ans);
            return;
        }
        if (ans.length() == k) {
            System.out.println(ans);
            return;
        }
        String str = i + "";
        PrintSeq(i + 1, n, ans + str, k);
        PrintSeq(i + 1, n, ans, k);
    }

    public static void main(String[] args) {
        int i = 1;
        int n = 6;
        int k = 4;
        PrintSeq(i, n, "", k);
    }
}
