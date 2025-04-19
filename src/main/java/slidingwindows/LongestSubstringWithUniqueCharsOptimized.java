package slidingwindows;

import java.util.HashMap;

public class LongestSubstringWithUniqueCharsOptimized {
    public int longestSubstringWithUniqueCharsOptimized(String s) {
        int maxLen = 0;
        HashMap<Character, Integer> prevIndices = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            // If a previous index of the current character is present in the current window, it's a duplicate character in the window.
            if (prevIndices.containsKey(s.charAt(right)) && prevIndices.get(s.charAt(right)) >= left) {
                // Shrink the window to exclude the previous occurrence of this character.
                left = prevIndices.get(s.charAt(right)) + 1;
            }
            // Update 'maxLen' if the current window is larger.
            maxLen = Math.max(maxLen, right - left + 1);
            prevIndices.put(s.charAt(right), right);
            // Expand the window.
            right++;
        }
        return maxLen;
    }
}
