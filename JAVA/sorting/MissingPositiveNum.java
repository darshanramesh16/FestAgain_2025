public class MissingPositiveNum {
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;
        int i = 0;
        while (i < n) {// if duplicates found or elm>n or elem is negative or element is in its corrent
                       // position then skip.....
            if (arr[i] == i + 1 || arr[i] <= 0 || (arr[i] > 0 && arr[i] <= n && arr[i] == arr[arr[i] - 1])

                    || arr[i] > n) {
                i++;
            } else {// else swap the elements..........
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }
        for (i = 0; i < n; i++) {// if any element is not equals to i+1 (its correct position then) return the
                                 // element........
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, -1, 1 };
        System.out.println("The missing positive integer is : " + firstMissingPositive(arr));
    }
}
