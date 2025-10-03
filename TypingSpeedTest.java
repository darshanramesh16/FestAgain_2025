// 
import java.util.Scanner;

public class TypingSpeedTest {
    public static void main(String[] args) {
        String text = "Java is a powerful object-oriented programming language.";
        System.out.println("Type this sentence:");
        System.out.println(text);
        
        Scanner sc = new Scanner(System.in);
        long start = System.currentTimeMillis();
        String input = sc.nextLine();
        long end = System.currentTimeMillis();

        if (input.equals(text)) {
            long timeTaken = (end - start) / 1000; // in seconds
            System.out.println("Correct! Time taken: " + timeTaken + " seconds");
            double wpm = (text.split(" ").length / (timeTaken / 60.0));
            System.out.printf("Typing Speed: %.2f WPM\n", wpm);
        } else {
            System.out.println("Text does not match! Try again.");
        }

        sc.close();
    }
}
