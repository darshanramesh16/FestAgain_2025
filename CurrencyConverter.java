// 
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double usdToInr = 83.0; // fixed rate for demo
        double usdToEur = 0.94;

        System.out.print("Enter amount in USD: ");
        double usd = sc.nextDouble();

        System.out.println(usd + " USD = " + (usd * usdToInr) + " INR");
        System.out.println(usd + " USD = " + (usd * usdToEur) + " EUR");

        sc.close();
    }
}
