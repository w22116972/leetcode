package leetcode;

import java.util.HashMap;

public class LC_242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c: t.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        for (char c: s.toCharArray()) {
            if (!hash.containsKey(c) || hash.get(c) == 0) {
                return false;
            }
            if (hash.containsKey(c)) {
                hash.put(c, hash.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
