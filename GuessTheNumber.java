// 
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int number = rand.nextInt(100) + 1; // 1 to 100
        int guess, attempts = 0;

        System.out.println("Guess a number between 1 and 100:");

        do {
            guess = sc.nextInt();
            attempts++;
            if (guess < number) {
                System.out.println("Too low! Try again.");
            } else if (guess > number) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts.");
            }
        } while (guess != number);

        sc.close();
    }
}
