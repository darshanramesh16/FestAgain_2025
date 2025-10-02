public class NextGreaterElement {
    public static long[] nextLargerElement(long[] arr, int n) {// traversing from last idx method.........
        Stack st = new Stack();
        long[] ans = new long[n];
        ans[n - 1] = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (st.empty())
                ans[i] = -1;
            else
                ans[i] = arr[st.peek()];
            st.push(i);
        }
        return ans;
    }

    public static long[] nextLargerElement1(long[] arr, int n) {// inplace method...........and traversing from first
                                                                // idx.......
        Stack st = new Stack();
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[i] > arr[st.peek()]) {
                arr[st.pop()] = arr[i];
            }
            st.push(i);
        }
        while (!st.empty()) {
            arr[st.pop()] = -1;
        }
        return arr;
    }

    public static void main(String[] args) {
        long[] arr = { 6, 8, 0, 1, 3 };
        long[] ans = nextLargerElement1(arr, arr.length);
        for (long i : ans)
            System.out.print(i + " ");
    }
}