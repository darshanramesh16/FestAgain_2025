import java.util.*;

public class FindNeg {
    public static long[] printFirstNegativeInteger(long A[], int n, int k) {
        long[] ans = new long[n - k + 1];
        Queue<Integer> q = new LinkedList<>();// Instead of queue, we can also use arraylist.............
        for (int i = 0; i < n; i++) {// finding the all negative numbers and storing their idx into queue, so that
                                     // first
                                     // negative out of them can be easily find......
            if (A[i] < 0) {
                q.add(i);
            }
        }
        int right = k - 1;// taking left and right for the window.........
        int left = 0;
        int j = 0;// for storing answer.............
        while (right < n) {
            if (q.isEmpty())// if queue containing negative number's idx is empty................then break
                            // the loop.........
                break;
            if (q.peek() >= left && q.peek() <= right) {// if the negative number stored in queue is b/w left and
                                                        // right..........
                ans[j++] = A[q.peek()];
            } else if (q.peek() > right) {// if it is out of range.............then store 0...........
                ans[j++] = 0;
            } else if (q.peek() < left) {// if window's idx is greater than negative number's idx.......then delete the
                                         // queue's current element and check the other negative number by continueing
                                         // the
                                         // process without incresing the
                                         // window.......
                q.remove();
                continue;
            }
            left++;// shift the window.......
            right++;
        }
        while (j < ans.length) {// if there are no negative numbers left in queue but there are elements left in
                                // the array so store 0 in ans.......
            ans[j++] = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        long A[] = { -8, 2, 3, -6, 10 };// -8 , 0, -6 , -6 expected........
        int n = A.length;
        int k = 2;
        long[] ans = printFirstNegativeInteger(A, n, k);
        for (var elem : ans)
            System.out.print(elem + " ");
    }
}