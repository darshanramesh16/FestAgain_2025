import java.util.Stack;

public class ValidStackSequence {
    public static boolean validateStackSequences(int[] arr1, int[] arr2) {// efficient and readable approach.........
        int n = arr1.length;
        int j = 0;
        Stack<Integer> st = new Stack<>();
        for (int val : arr1) {
            st.push(val);
            while (!st.empty() && st.peek() == arr2[j]) {
                st.pop();
                j++;
            }
        }
        if (st.empty())
            return true;
        else
            return false;
    }
    // public static boolean validateStackSequences(int[] arr1, int[] arr2)
    // {//efficient but confusing approach............
    // int n = arr1.length;
    // int i = 0;
    // int j = 0;
    // Stack<Integer> st = new Stack<>();
    // while (j < n) {
    // while (!st.empty() && st.peek() == arr2[j]) {// while peek and poped current
    // element is equal then pop and
    // // j++.....
    // st.pop();
    // j++;
    // }
    // if (i == n)// if i become greater than n then break the loop......
    // break;
    // if (i < n && st.empty()) {// if stack is empty.........
    // st.push(arr1[i++]);
    // } else {
    // st.push(arr1[i++]);// simply push.............
    // }
    // }
    // if (st.empty())
    // return true;
    // else
    // return false;
    // }

    public static void main(String[] args) {
        int[] pushed = { 1, 2, 3, 4, 5 };
        int[] poped = { 4, 5, 3, 2, 1 };
        boolean ans = validateStackSequences(pushed, poped);
        if (ans)
            System.out.println("Given poped sequence is a valid stack sequence of pushed");
        else
            System.out.println("Given poped sequence is not a vaild stack sequence of pushed");
    }
}
