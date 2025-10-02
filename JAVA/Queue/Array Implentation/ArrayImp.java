class Queue {
    private int front = 0;
    private int rear = 0;
    private int size = 0;
    private int[] arr = new int[5];

    public void add(int val) throws Error {
        if (rear == arr.length) {
            throw new Error("Queue Overflow ho rha h");
        }
        arr[rear++] = val;
        size++;
    }

    public void remove() throws Error {
        if (front == rear) {
            throw new Error("Underflow ho rha h");
        }
        front++;
        size--;
    }

    public int peek() {
        if (front == rear) {
            throw new Error("Underflow ho rha h");
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void size() {
        System.out.println(size);
    }

    public void display() {
        for (int i = front; i < rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class ArrayImp {
    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.isEmpty());
        q.size();
        q.add(0);
        q.add(1);
        q.display();
        q.isEmpty();
        System.out.println(q.isEmpty());
        q.add(4);
        q.add(0);
        q.add(0);
        q.size();
    }
}