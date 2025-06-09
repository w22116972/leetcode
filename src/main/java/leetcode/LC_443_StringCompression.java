package leetcode;

public class LC_443_StringCompression {
    public int compress(char[] chars) {
        int insertIndex = 0;
        char current = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == current) {
                count++;
            } else {
                chars[insertIndex++] = current;
                if (count > 1) {
                    String countStr = String.valueOf(count);
                    for (char ch : countStr.toCharArray()) {
                        chars[insertIndex++] = ch;
                    }
                }
                current = chars[i];
                count = 1;
            }
        }
        // Process last character
        chars[insertIndex++] = current;
        if (count > 1) {
            String countStr = String.valueOf(count);
            for (char ch : countStr.toCharArray()) {
                chars[insertIndex++] = ch;
            }
        }
        return insertIndex;
    }
}
