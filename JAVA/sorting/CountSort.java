public class CountSort {
    public static void SortCount(int[] arr) {
        int[] freqarr = new int[10];
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            freqarr[arr[i]]++;
        }
        for (int i = 1; i < freqarr.length; i++) {
            freqarr[i] += freqarr[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            ans[freqarr[arr[i]] - 1] = arr[i];
            freqarr[arr[i]]--;
        }
        for (int i = 0; i < arr.length; i++)
            arr[i] = ans[i];
    }

    public static void main(String[] args) {
        int[] arr = { 6, 1, 9, 0, 1, 5, 2, 1, 7, 1 };
        SortCount(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
