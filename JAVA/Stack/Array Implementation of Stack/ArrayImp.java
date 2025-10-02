class Stack {// Array Implementation of Stack..................
    private int[] arr = new int[1000000];
    private int size = 0;
    private int idx = -1;

    public void push(int val) throws Error {
        if (size == arr.length) {
            throw new Error("Stack Overflow ho rha h vmro!");
        }
        arr[++idx] = val;
        size++;
    }

    public int pop() throws Error {
        if (size == 0) {
            throw new Error("Stack Underflow ho rha h vmro!");
        }
        int x = arr[idx];
        idx--;
        size--;
        return x;
    }

    public int peek() throws Error {
        if (size == 0) {
            throw new Error("Stack Underflow ho rha h vmro!");
        }
        return arr[idx];
    }

    public boolean empty() {
        return size == 0;
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i <= idx; i++) {
            if (i != idx)
                System.out.print(arr[i] + ", ");
            else
                System.out.print(arr[i]);
        }
        System.out.println("]");
    }
}

public class ArrayImp {
    public static void pushAtBottom(Stack st, int x) {
        Stack helper = new Stack();
        while (!st.empty()) {
            helper.push(st.pop());
        }
        st.push(x);
        while (!helper.empty()) {
            st.push(helper.pop());
        }
    }

    public static void reverseSt(Stack st) {
        if (st.empty()) {
            return;
        }
        int x = st.pop();
        reverseSt(st);
        pushAtBottom(st, x);
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        System.out.println(st.empty());
        st.push(1);
        st.push(2);
        st.push(3);
        st.display();
        reverseSt(st);
        st.display();
    }
}