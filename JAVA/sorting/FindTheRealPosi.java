public class FindTheRealPosi {
    public static int[] Decrease(int[] arr) {// in this we have used selection sort algorithm.........
        int[] ans = new int[arr.length];
        int min = -1;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;// make current element as minimum
            for (int j = 0; j < arr.length; j++) {// using selection sort....
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            ans[min] = count++;// mark the answer
            arr[min] = Integer.MAX_VALUE;// make the min as maximun value 'cause we also have to find next
                                         // minimums........
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 54, 11, 28, 47, 91, 63 };
        int[] ans = Decrease(arr);
        for (int i : ans)
            System.out.print(i + " ");
    }
}