public class CountInversionM2 {
    static long MergeKaro(long[] arr, int st, int mid, int end) {
        long[] arr1 = new long[mid - st + 1];
        long[] arr2 = new long[end - mid];
        for (int i = 0; i < arr1.length; i++)
            arr1[i] = arr[i + st];
        for (int i = 0; i < arr2.length; i++)
            arr2[i] = arr[mid + 1 + i];
        int i = 0, j = 0;
        int count = 0;
        int k = st;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                count += arr1.length - i;// calculated during merging.......................
                arr[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            arr[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr[k++] = arr2[j++];
        }
        return count;
    }

    static long MergeCount(long[] arr, int st, int end) {
        long count = 0;
        if (st >= end) {
            return count;
        }
        int mid = st + (end - st) / 2;
        count += MergeCount(arr, st, mid);
        count += MergeCount(arr, mid + 1, end);
        count += MergeKaro(arr, st, mid, end);
        return count;
    }

    static long inversionCount(long arr[]) {
        return MergeCount(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        long[] arr = { 8, 2, 5, 3, 1, 4 };
        System.out.println(inversionCount(arr));
    }
}
