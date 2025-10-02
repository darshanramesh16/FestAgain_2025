class Node {// LinkedList Implementation of Stack.................
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class Stack {
    Node head;
    int size = 0;
    Node tail;

    public void push(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public int pop() throws Error {
        if (head == null) {
            throw new Error("Vmro Underflow ho rha h!");
        } else if (head.next == null) {
            int x = head.data;
            head = null;
            size--;
            return x;
        }
        int x = tail.data;
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
        return x;
    }

    public int peek() throws Error {
        if (size == 0) {
            throw new Error("Vmro Underflow ho rha h!");
        }
        return tail.data;
    }

    public boolean empty() {
        return size == 0;
    }

    public void display() {
        Node temp = head;
        System.out.print("[");
        while (temp != null) {
            if (temp.next != null)
                System.out.print(temp.data + ",");
            else {
                System.out.print(temp.data);
            }
            temp = temp.next;
        }
        System.out.println("]");
    }
}

public class LLImp {
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
        st.push(4);
        st.push(5);
        st.display();
        reverseSt(st);
        st.display();
    }
}