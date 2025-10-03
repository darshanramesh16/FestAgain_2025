import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock {
    public static void main(String[] args) {
        while (true) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            System.out.print("\rCurrent Time: " + formatter.format(date));
            try {
                Thread.sleep(1000); // update every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
