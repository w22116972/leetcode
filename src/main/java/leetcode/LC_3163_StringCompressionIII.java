package leetcode;

public class LC_3163_StringCompressionIII {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int count = 0;
        char current = '-';
        for (char c: word.toCharArray()) {
            if (current == '-') {
                current = c;
                count++;
            } else if (current == c) {
                if (count == 9) {
                    comp.append("9");
                    comp.append(c);
                    count = 1;
                } else {
                    count++;
                }
            } else {
                comp.append(count);
                comp.append(current);
                current = c;
                count = 1;
            }
        }
        comp.append(count);
        comp.append(current);
        return comp.toString();
    }
}
