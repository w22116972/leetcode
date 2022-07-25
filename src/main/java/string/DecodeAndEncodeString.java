package string;

import java.util.LinkedList;
import java.util.List;

public class DecodeAndEncodeString {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        final LinkedList<String> result = new LinkedList<>();
        int start = 0;
        int tail = 0;
        while (tail < s.length()) {
            while (s.charAt(tail) != '#') {
                tail++;
            }
            final Integer strLength = Integer.valueOf(s.substring(start, tail));
            result.add(s.substring(tail + 1, tail + 1 + strLength));
            start = tail + 1 + strLength;
            tail = tail + 1 + strLength;
        }
        return result;
    }
}
