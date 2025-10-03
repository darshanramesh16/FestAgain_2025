// MultithreadingExample.java
// Demonstrates basic multithreading in Java

class MyThread extends Thread {
    private String threadName;

    MyThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " - Count: " + i);
            try {
                Thread.sleep(500); // Pause for half a second
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
        }
        System.out.println(threadName + " finished.");
    }
}

class MyRunnable implements Runnable {
    private String taskName;

    MyRunnable(String name) {
        this.taskName = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " - Step: " + i);
            try {
                Thread.sleep(700); // Pause for 0.7 seconds
            } catch (InterruptedException e) {
                System.out.println(taskName + " interrupted.");
            }
        }
        System.out.println(taskName + " finished.");
    }
}

public class MultithreadingExample {
    public static void main(String[] args) {
        // Using Thread class
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");

        // Using Runnable interface
        Thread r1 = new Thread(new MyRunnable("Runnable-1"));
        Thread r2 = new Thread(new MyRunnable("Runnable-2"));

        System.out.println("Starting threads...");

        t1.start();
        t2.start();
        r1.start();
        r2.start();

        try {
            t1.join();
            t2.join();
            r1.join();
            r2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("All threads finished execution.");
    }
}
