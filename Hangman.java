// 
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String word = "JAVA";
        char[] guessed = new char[word.length()];
        for (int i = 0; i < guessed.length; i++) guessed[i] = '_';

        Scanner sc = new Scanner(System.in);
        int attempts = 6;

        while (attempts > 0) {
            System.out.println("Word: " + String.valueOf(guessed));
            System.out.print("Guess a letter: ");
            char c = sc.next().toUpperCase().charAt(0);

            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    guessed[i] = c;
                    found = true;
                }
            }

            if (!found) attempts--;

            if (String.valueOf(guessed).equals(word)) {
                System.out.println("🎉 You guessed the word!");
                break;
            }
            System.out.println("Attempts left: " + attempts);
        }

        if (attempts == 0) System.out.println("😢 Game Over! The word was: " + word);
        sc.close();
    }
}
