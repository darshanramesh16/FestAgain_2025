import java.util.*;

public class SlidingWindow {// it can also be done in O(n*k) brute force approach time complexity....using
                            // nested loops....
    public static int[] maxSlidingWindow(int[] arr, int k) {// efficient approach using queue...........
        if (arr.length == 1 || k == 1)// edge case such as if window size is one.........
            return arr;
        int i = 0;
        int n = arr.length;
        int[] ans = new int[n - k + 1];// taking answer array to store answer.............
        int idx = 0;
        Deque<Integer> q = new LinkedList<>();// using double ended queue to approach problem efficiently.........
        for (i = 0; i <= k - 1; i++) {// loop for the whole size of first window............
            while (!q.isEmpty() && arr[q.peekLast()] <= arr[i]) {
                q.pollLast();
            }
            q.addLast(i);
        }
        ans[idx++] = arr[q.peekFirst()];// storing the answer for first window..........
        for (i = 1; i <= k - 1 + i && k - 1 + i < n; i++) {// loop starting from first shifted window..........
            if (!q.isEmpty() && q.peekFirst() < i) {// checking whether an element is deque is out of range.......
                q.pollFirst();// if yes then pop...........
            }
            while (!q.isEmpty() && arr[q.peekLast()] <= arr[k - 1 + i]) {// comparing the last elements of window
                                                                         // ('cause
                                                                         // initial elements have been checked by our
                                                                         // first window loop......) Or maintaing
                                                                         // decreasing order.......
                q.pollLast();// if elements from the end of the queue are less than the current last element
                             // of the window then pop.........
            }
            q.addLast(k - 1 + i);// store the current last element of the window............
            ans[idx++] = arr[q.peekFirst()];// store the answer which is the first element of the deque (cause we
                                            // maintained decreasing order so first element would be greatest one......)
        }
        return ans;
    }

    // public static int[] maxSlidingWindow2(int[] arr, int k) {// brute force
    // approach using NGE array......and loop......
    // int n = arr.length;
    // if (n == 1 || k == 1)
    // return arr;
    // int[] Nge = new int[n];
    // Stack<Integer> st = new Stack<>();
    // for (int i = n - 1; i >= 0; i--) {
    // while (!st.empty() && arr[i] >= arr[st.peek()]) {
    // st.pop();
    // }
    // if (st.empty()) {
    // Nge[i] = n;
    // } else {
    // Nge[i] = st.peek();
    // }
    // st.push(i);
    // }
    // int[] ans = new int[n - k + 1];
    // int left = 0;
    // int right = k - 1;
    // int i = 0;
    // int great = 0;
    // while (right < n) {
    // great = left;
    // if (Nge[left] >= left && Nge[left] <= right) {
    // great = Nge[left];
    // }
    // if (Nge[great] > right) {
    // ans[i++] = arr[great];
    // } else {
    // while (Nge[great] <= right) {
    // great = Nge[great];
    // }
    // ans[i++] = arr[great];
    // }
    // left++;
    // right++;
    // }
    // return ans;
    // }

    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };// expected : 3 3 5 5 6 7
        int k = 3;
        arr = maxSlidingWindow(arr, k);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}