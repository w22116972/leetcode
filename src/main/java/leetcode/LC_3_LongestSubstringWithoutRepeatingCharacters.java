package leetcode;

import java.util.HashMap;

public class LC_3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        HashMap<Character, Integer> charToIndex = new HashMap<>();
        // use window sliding
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char current = s.charAt(right);
            if (charToIndex.containsKey(current) && charToIndex.get(current) >= left) {
                left = charToIndex.get(current) + 1;
            }

            // 更新字符的最新索引
            charToIndex.put(current, right);

            // 更新最大長度
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
