import java.util.*;

public class Subsets {
    public static void PrintSubset(int[] arr, int i, ArrayList<Integer> ans) {
        if (i == arr.length) {
            System.out.println(ans);
            return;
        }
        ans.add(arr[i]);
        PrintSubset(arr, i + 1, ans);
        ans.remove(ans.size() - 1);
        PrintSubset(arr, i + 1, ans);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        PrintSubset(arr, 0, new ArrayList<>());
    }
}
