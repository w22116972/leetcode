package solution;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] splitWords = s.split(" ");
        StringBuilder reversedString = new StringBuilder();
        for (int i = splitWords.length - 1; i >= 0; i--) {
            if (!splitWords[i].isEmpty()) {
                reversedString.append(splitWords[i]);
                reversedString.append(" ");
            }
        }
        // use trim() to remove the last space
        return reversedString.toString().trim();
    }

    // follow-up: use in-place with S(n) = O(1)
    public String reverseWordsInPlace(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        // reverse the whole string
        reverse(chars, 0, n - 1);

        // reverse each word
        int start = 0;
        for (int end = 0; end < n; end++) {
            if (chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }
        // reverse the last word
        reverse(chars, start, n - 1);

        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
