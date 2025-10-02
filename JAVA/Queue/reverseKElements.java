import java.util.Stack;

public class reverseKElements {
    public static Queue reversefirstKelem(Queue q, int k) {
        Stack<Integer> st = new Stack<>();
        int x = q.size() - k;
        while (k > 0) {
            st.push(q.remove());
            k--;
        }
        while (!st.empty()) {
            q.add(st.pop());
        }
        while (x > 0) {
            q.add(q.remove());
            x--;
        }
        return q;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        int k = 2;
        reversefirstKelem(q, k);
        q.display();
    }
}
