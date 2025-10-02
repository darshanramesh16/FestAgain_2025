import java.util.*;

public class FindDuplicates {// find duplicate without using extra space......i.e constant
                             // space................
    public static int DuplicatesFinder(int[] arr) {
        int n = arr.length;
        while (true) {// i only need 0th index.........................
            if (arr[0] == arr[arr[0]])// if current element and element at current element's index is same....then
                                      // return............
                return arr[0];
            int temp = arr[0];// else swap until............
            arr[0] = arr[temp];
            arr[temp] = temp;
        }
        // Note if i run any loop infinitly then i don't need to return anything because
        // my return statement would be unreachable..........
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 4, 5, 3 };
        System.out.println(DuplicatesFinder(arr));
    }
}
