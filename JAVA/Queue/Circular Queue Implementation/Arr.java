class CircularQueue {
    private int[] arr = new int[6];
    private int size = 0;
    private int front = 0;
    private int rear = 0;

    public void add(int x) throws Error {
        if (size == arr.length) {
            throw new Error("Overflow ho rha h");
        } else if (rear == arr.length) {
            rear = 0;
        } else if (front == rear && size == 0) {
            arr[rear++] = x;
            size++;
            return;
        }
        arr[rear++] = x;
        size++;
    }

    public int remove() throws Error {
        if (front == rear && size == 0) {
            throw new Error("Underflow condition.......");
        }
        int x = arr[front];
        if (front == arr.length - 1) {
            front = 0;
            size--;
        } else {
            front++;
            size--;
        }
        return x;
    }

    public void display() {
        if (rear <= front) {
            for (int i = front; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            for (int i = 0; i < rear; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            for (int i = front; i < rear; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public int peek() throws Error {
        if (front == rear && size == 0) {
            throw new Error("Underflow condition.......");
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class Arr {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue();
        System.out.println(q.isEmpty());
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.display();
        System.out.println(q.peek() + " is peek");
        System.out.println(q.remove() + " is removed");
        System.out.println(q.peek() + " is peek");
        System.out.println(q.remove() + " is removed");
        System.out.println(q.isEmpty());
        q.display();
        System.out.println(q.peek() + " is peek");
        q.add(7);
        q.display();
        System.out.println(q.remove() + " is removed");
        q.add(8);
        q.display();
        q.add(9);
        q.display();
        System.out.println(q.isEmpty());
    }
}