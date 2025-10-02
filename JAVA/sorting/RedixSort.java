public class RedixSort {
    public static void Sort(int[] arr, int dig) {
        int[] freqarr = new int[10];
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int x = (arr[i] / dig) % 10;
            freqarr[x]++;
        }
        for (int i = 1; i < freqarr.length; i++) {
            freqarr[i] += freqarr[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int x = (arr[i] / dig) % 10;
            ans[freqarr[x] - 1] = arr[i];
            freqarr[x]--;
        }
        for (int i = 0; i < arr.length; i++)
            arr[i] = ans[i];
    }

    public static void SortRedix(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        for (int dig = 1; max / dig > 0; dig *= 10) {
            Sort(arr, dig);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 34, 532, 124345, 345, 3421, 4 };
        SortRedix(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
