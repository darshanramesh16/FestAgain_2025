// 
import java.util.Random;

public class WeatherSimulator {
    public static void main(String[] args) {
        String[] conditions = {"Sunny", "Cloudy", "Rainy", "Stormy", "Snowy"};
        Random rand = new Random();

        int temp = rand.nextInt(35) + 5; // 5°C to 40°C
        String condition = conditions[rand.nextInt(conditions.length)];

        System.out.println("Weather Forecast: " + condition + ", " + temp + "°C");
    }
}
