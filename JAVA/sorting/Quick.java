public class Quick {
    static int FindPivot(int[] arr, int st, int end) {
        int piv = st;
        int count = st;
        for (int i = 1; i + piv < arr.length; i++) {
            if (arr[piv + i] < arr[piv]) {
                count++;
            }
        }
        piv = count;
        int temp = arr[st];
        arr[st] = arr[count];
        arr[count] = temp;
        int i = st;
        int j = end;
        while (i < piv && j > piv) {
            if (arr[i] >= arr[piv] && arr[j] < arr[piv]) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            } else if (arr[i] < arr[piv]) {
                i++;
            } else {
                j--;
            }
        }
        return piv;
    }

    static void quickKaro(int[] arr, int st, int end) {
        if (st >= end) {
            return;
        }
        int pivot = FindPivot(arr, st, end);
        quickKaro(arr, st, pivot - 1);
        quickKaro(arr, pivot + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 8, 2, 5, 1, 5, 1, 3, 1, 3, 1, 5, 4, 5 };
        quickKaro(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}