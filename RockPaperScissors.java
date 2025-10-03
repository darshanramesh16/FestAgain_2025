// 
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random rand = new Random();

        System.out.print("Enter Rock, Paper, or Scissors: ");
        String userChoice = sc.nextLine();

        String computerChoice = choices[rand.nextInt(3)];
        System.out.println("Computer chose: " + computerChoice);

        if (userChoice.equalsIgnoreCase(computerChoice)) {
            System.out.println("It's a Tie!");
        } else if ((userChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors")) ||
                   (userChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock")) ||
                   (userChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper"))) {
            System.out.println("You Win! 🎉");
        } else {
            System.out.println("You Lose 😢");
        }

        sc.close();
    }
}
