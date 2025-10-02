import java.util.Stack;

public class Method1 {// this could also be done by nested loop(two for loops) in O(n^2) time
                      // complexity but that will show time limit error.....
    public static int[] canSeePersonsCount(int[] arr) {// this is a inefficient straight forward method1...........
        int n = arr.length;
        if (n == 1) {
            arr[0] = 0;
            return arr;
        }
        int count;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        int[] Nge = new int[n];
        int[] Pge = new int[n];
        for (int i = n - 1; i >= 0; i--) {// calculate Nge......
            while (!st.empty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (st.empty()) {
                Nge[i] = -1;
            } else {
                Nge[i] = st.peek();
            }
            st.push(i);
        }
        while (!st.empty()) {
            st.pop();
        }
        for (int i = 0; i < n; i++) {// calculate Pge.........
            while (!st.empty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (st.empty()) {
                Pge[i] = -1;
            } else {
                Pge[i] = st.peek();
            }
            st.push(i);
        }
        while (!st.empty()) {
            st.pop();
        }
        for (int i = 0; i < n; i++) {// calculate the answer.......
            if (Pge[i] != -1) {// if previous greater element is present then mark plus one in that 'cause pge
                               // can see the current element.....
                ans[Pge[i]]++;
            }
            if (Nge[i] != -1) {// if next greater element is present then mark current element as plus one
                               // 'cause current element can see the nge....
                ans[i]++;
            } // else skip......................
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 6, 8, 5, 11, 9 };
        arr = canSeePersonsCount(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}