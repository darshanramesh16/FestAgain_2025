import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * Finds the length of the longest substring without repeating characters 
     * using the Sliding Window technique with a HashMap.
     * @param s The input string.
     * @return The length of the longest substring.
     */
    public int lengthOfLongestSubstring(String s) {
        // If the string is null or empty, the length is 0.
        if (s == null || s.length() == 0) {
            return 0;
        }

        // 'charIndexMap' stores the character and its last seen index.
        Map<Character, Integer> charIndexMap = new HashMap<>();
        
        int maxLength = 0;
        int left = 0; // The left boundary of the sliding window (start of the substring)

        // The 'right' pointer iterates through the string, expanding the window.
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 1. Check for Repetition:
            // If the character is ALREADY in the map AND its last index 
            // is within the current window (index >= left).
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                // If a repeat is found, move the left pointer to the position 
                // IMMEDIATELY AFTER the previous occurrence of this character.
                left = charIndexMap.get(currentChar) + 1;
            }

            // 2. Update Map and Max Length:
            // Store the current index of the character (or update its index).
            charIndexMap.put(currentChar, right);

            // The current length is (right - left + 1). Update the maximum length found so far.
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}