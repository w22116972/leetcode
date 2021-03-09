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

    public static int sol1(String s, int k) {
        int windowStartIndex = 0;
        int maxWindowLength = 0;
        ConcurrentHashMap<Character, Integer> basket = new ConcurrentHashMap<>(k);
        for (int windowEndIndex = 0; windowEndIndex < s.length(); windowEndIndex++) {
            final char currentChar = s.charAt(windowEndIndex);
            if (basket.contains(currentChar)) {
                basket.put(currentChar, basket.get(currentChar) + 1);
            } else {
                basket.put(currentChar, 1);
            }
            while (basket.size() > k) {
                final char toShrinkChar = s.charAt(windowStartIndex);
                basket.put(toShrinkChar, basket.get(toShrinkChar) - 1);
                if (basket.get(toShrinkChar) == 0) {
                    basket.remove(toShrinkChar);
                }
                windowStartIndex++;
            }
            maxWindowLength = Math.max(maxWindowLength, windowEndIndex - windowStartIndex + 1);
        }
        return maxWindowLength;
    }


    public static int sol(String str, int k) {
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
