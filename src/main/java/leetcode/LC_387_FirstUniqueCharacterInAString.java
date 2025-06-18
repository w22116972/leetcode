package leetcode;

import java.util.HashMap;

public class LC_387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> charToCount = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c: s.toCharArray()) {
            charToCount.put(c, charToCount.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (charToCount.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
