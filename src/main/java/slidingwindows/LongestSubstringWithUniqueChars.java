package slidingwindows;

import java.util.HashSet;

public class LongestSubstringWithUniqueChars {
    public int longestSubstringWithUniqueChars(String s) {
        int maxLen = 0;
        HashSet<Character> hashSet = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            // If we encounter a duplicate character in the window, shrink the window until it's no longer a duplicate.
            while (hashSet.contains(s.charAt(right))) {
                hashSet.remove(s.charAt(left));
                left++;
            }
            // Once there are no more duplicates in the window, update 'maxLen' if the current window is larger.
            maxLen = Math.max(maxLen, right - left + 1);
            hashSet.add(s.charAt(right));
            // Expand the window.
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("new LongestSubstringWithUniqueChars().longestSubstringWithUniqueChars(\"abcba\") = " + new LongestSubstringWithUniqueChars().longestSubstringWithUniqueChars("abcba"));

    }
}
