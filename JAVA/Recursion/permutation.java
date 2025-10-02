import java.util.*;

public class permutation {
    public static ArrayList<String> PrintPermutation(String str, String ans, ArrayList<String> list) {
        if (str.length() == 0) {
            list.add(ans);
            return list;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            String real = left + right;
            PrintPermutation(real, ans + str.charAt(i), list);
        }
        return list;
    }

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> ans = new ArrayList<>();
        System.out.println(PrintPermutation(str, "", ans));
    }
}
