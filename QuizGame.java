// 
import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "Which language is platform independent? (a) Java (b) C++ (c) Python",
            "Who invented Java? (a) James Gosling (b) Dennis Ritchie (c) Bjarne Stroustrup",
            "What does JVM stand for? (a) Java Virtual Machine (b) Java Variable Method (c) Joint Virtual Module"
        };

        char[] answers = {'a', 'a', 'a'};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("Your answer: ");
            char ans = sc.next().charAt(0);

            if (ans == answers[i]) {
                score++;
                System.out.println("Correct ✅\n");
            } else {
                System.out.println("Wrong ❌\n");
            }
        }

        System.out.println("Your final score: " + score + "/" + questions.length);
        sc.close();
    }
}
