import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of each element
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a min-heap to keep top k frequent elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));

        for (int num : freqMap.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove least frequent
            }
        }

        // Step 3: Build the result array
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    // Test the program
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,3,4,4,5};
        int k = 3;
        int[] topK = topKFrequent(nums, k);

        System.out.println("Top " + k + " frequent elements:");
        System.out.println(Arrays.toString(topK));
    }
}
