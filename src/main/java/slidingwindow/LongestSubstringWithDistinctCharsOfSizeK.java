package slidingwindow;

import java.util.concurrent.ConcurrentHashMap;

//Given a string, find the length of the longest substring in it with no more than K distinct characters.
//Input: String="araaci", K=2
//Output: 4
//Explanation: The longest substring with no more than '2' distinct characters is "araa".
//Input: String="araaci", K=1
//Output: 2
//Explanation: The longest substring with no more than '1' distinct characters is "aa".
//Input: String="cbbebi", K=3
//Output: 5
//Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
public class LongestSubstringWithDistinctCharsOfSizeK {
    public static void main(String[] args) {
        assert findLength("araaci", 2) == 4;
        assert findLength("araaci", 1) == 2;
        assert findLength("cbbebi", 3) == 5;

    }
    public static int findLength(String str, int k) {
        ConcurrentHashMap<Character, Integer> chars = new ConcurrentHashMap<Character, Integer>();
        int startIndex = 0;
        int maxLength = 0;
        for (int endIndex = 0; endIndex < str.length(); endIndex++) {
            final char rightChar = str.charAt(endIndex);
            chars.put(rightChar, chars.getOrDefault(rightChar, 0)+1);
            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (chars.size() > k) {
                final char leftChar = str.charAt(startIndex);
                chars.put(leftChar, chars.get(leftChar)-1);
                if (chars.get(leftChar) == 0) {
                    chars.remove(leftChar);
                }
                startIndex++;
            }
            final int windowLength = endIndex - startIndex + 1;
            if (windowLength  > maxLength) {
                maxLength = windowLength;
            }
        }

        return maxLength;
    }
}
