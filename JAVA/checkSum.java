package JAVA;
import java.io.*;

class Crc {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] data;
        int[] div;
        int[] divisor;
        int[] rem;
        int[] crc;
        int data_bits, divisor_bits, tot_length;

        // ----- INPUT DATA BITS -----
        System.out.println("Enter number of data bits: ");
        data_bits = Integer.parseInt(br.readLine());
        data = new int[data_bits];

        System.out.println("Enter data bits: ");
        for (int i = 0; i < data_bits; i++)
            data[i] = Integer.parseInt(br.readLine());

        // ----- INPUT DIVISOR -----
        System.out.println("Enter number of bits in divisor: ");
        divisor_bits = Integer.parseInt(br.readLine());
        divisor = new int[divisor_bits];

        System.out.println("Enter divisor bits: ");
        for (int i = 0; i < divisor_bits; i++)
            divisor[i] = Integer.parseInt(br.readLine());

        // ----- CALCULATE TOTAL LENGTH -----
        tot_length = data_bits + divisor_bits - 1;
        div = new int[tot_length];
        rem = new int[tot_length];
        crc = new int[tot_length];

        // ----- CRC GENERATION -----
        for (int i = 0; i < data.length; i++)
            div[i] = data[i];

        System.out.print("Dividend (after appending 0's) is: ");
        for (int i = 0; i < div.length; i++)
            System.out.print(div[i]);
        System.out.println();

        // Copy dividend into remainder array
        for (int j = 0; j < div.length; j++)
            rem[j] = div[j];

        // Perform division
        rem = divide(div, divisor, rem);

        // Append remainder to dividend → Generate CRC code
        for (int i = 0; i < div.length; i++)
            crc[i] = (div[i] ^ rem[i]);

        System.out.println("\nCRC Code: ");
        for (int i = 0; i < crc.length; i++)
            System.out.print(crc[i]);
        System.out.println();

        // ----- ERROR DETECTION -----
        System.out.println("\nEnter received code of " + tot_length + " bits: ");
        for (int i = 0; i < crc.length; i++)
            crc[i] = Integer.parseInt(br.readLine());

        for (int j = 0; j < crc.length; j++)
            rem[j] = crc[j];

        rem = divide(crc, divisor, rem);

        // Check if remainder is all zeros
        boolean error = false;
        for (int i = 0; i < rem.length; i++) {
            if (rem[i] != 0) {
                error = true;
                break;
            }
        }

        if (error)
            System.out.println("Error detected in received code!");
        else
            System.out.println("No Error detected in received code.");
    }

    // ----- DIVISION FUNCTION -----
    static int[] divide(int div[], int divisor[], int rem[]) {
        int cur = 0;
        while (true) {
            for (int i = 0; i < divisor.length; i++)
                rem[cur + i] = (rem[cur + i] ^ divisor[i]);

            while (cur < rem.length && rem[cur] == 0 && cur != rem.length - 1)
                cur++;

            if ((rem.length - cur) < divisor.length)
                break;
        }
        return rem;
    }
}
