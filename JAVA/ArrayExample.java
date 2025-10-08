import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input array size
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        // Step 2: Declare array
        int[] arr = new int[n];

        // Step 3: Input array elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Step 4: Display array elements
        System.out.print("Array elements are: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Step 5: Find the largest element
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Step 6: Display the largest element
        System.out.println("The largest element is: " + max);

        sc.close();
    }
}
