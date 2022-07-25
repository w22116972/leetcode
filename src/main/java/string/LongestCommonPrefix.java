package string;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        // find min length
        int minLength = 201;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        if (minLength == 0) {
            return "";
        }

        for (int i = 0; i < minLength; i++) {
            Character c = null;
            for (int j = 0; j < strs.length; j++) {
                if (c == null) {
                    c = strs[j].charAt(i);
                } else if (c != strs[j].charAt(i)) {
                    return result.toString();
                }
            }
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {

    }
}
