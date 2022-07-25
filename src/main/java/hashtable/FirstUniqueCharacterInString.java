package hashtable;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        final LinkedHashMap<Character, Node> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new Node(1, i));
            } else {
                map.put(c, new Node(map.get(c).frequency + 1, map.get(c).index));
            }
        }
        for (Map.Entry<Character, Node> entry : map.entrySet()) {
            if (entry.getValue().frequency == 1) {
                return entry.getValue().index;
            }
        }
        return -1;
    }

    static class Node {
        Integer frequency;
        Integer index;

        public Node(Integer frequency, Integer index) {
            this.frequency = frequency;
            this.index = index;
        }
    }
}
