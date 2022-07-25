package string;

public class ConsecutiveCharacters {
    public int maxPower(String s) {
        int i = 0;
        final char[] chars = s.toCharArray();
        int max = 0;
        char current;
        while (i < chars.length) {
            current = chars[i];
            int j = i + 1;
            int localMax = 1;
            while (j < chars.length && chars[j] == current) {
                localMax++;
                j++;
            }
            max = Math.max(max, localMax);
            i = j;
        }

        return max;
    }
}
