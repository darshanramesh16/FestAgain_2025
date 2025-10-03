
import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        StringBuilder password = new StringBuilder();
        Random rand = new Random();

        int length = 12; // password length
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(chars.length());
            password.append(chars.charAt(index));
        }

        System.out.println("Generated Password: " + password);
    }
}
