//
import java.util.Scanner;

public class AlarmClock {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Set alarm in seconds: ");
        int seconds = sc.nextInt();

        System.out.println("Alarm set. Waiting...");
        Thread.sleep(seconds * 1000);

        System.out.println("⏰ Alarm ringing! Time’s up!");
        sc.close();
    }
}
