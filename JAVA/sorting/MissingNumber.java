public class MissingNumber {// using cyclic sort to find missing array,,,,,,,,
    public static int missingNumber(int[] arr) {// this is inplace ........we can also use boolean array that would take
                                                // O(n) space complexity......it also has maths method n(n+1)/2 - sum of
                                                // array elements......
        int n = arr.length;
        int i = 0;
        while (i < n) {
            if (arr[i] == n)// if current element is n......then go forward to check whether ith number
                            // present or not........
                i++;
            else if (arr[i] != i) {// sort other indices elements.......
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            } else {// if arr[i]==i then move forward............
                i++;
            }
        }
        i = 0;
        while (i < n) {// loop to identify the missing number........
            if (arr[i] != i)// if at a particular idx element is arr[i]!=i then return i......because if it
                            // would present so it should have sorted .....that is why this is why this
                            // number is missing
                return i;
            i++;
        }
        return n;// if there is no missing number, then return n........
    }

    public static void main(String[] args) {
        int[] arr = { 6, 3, 2, 0, 4, 1 };
        System.out.println("Missing number is : " + missingNumber(arr));
    }
}
