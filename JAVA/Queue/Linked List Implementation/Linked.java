class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class Queue {
    private Node head;
    private Node tail;
    private int size = 0;

    public void add(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public int remove() throws Error {
        if (head == null)
            throw new Error("Underflow !");
        int x = head.data;
        head = head.next;
        size--;
        return x;
    }

    public int peek() throws Error {
        if (head == null) {
            throw new Error("Underflow !");
        }
        return head.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {// using helper function to print the elmenets...........
        print(head);
        System.out.println();
    }

    public void print(Node head) {// using recursion because it is not possible to print the elements through
                                  // iteration.........
        if (head == null)
            return;
        System.out.print(head.data + " ");
        print(head.next);
    }
}

public class Linked {
    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.isEmpty());
        q.size();
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        q.display();
        System.out.println(q.peek());
        q.remove();
        q.display();
        System.out.println(q.peek());
    }
}