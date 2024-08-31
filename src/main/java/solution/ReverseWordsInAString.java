package solution;

/**
 * The words are separated by one or more spaces and returned string should only have a single space separating the words.
 * When using split(" ") on `  ` double space, it will return an empty string.
 * So, we need to check if the split word is empty before appending it to the result.
 */
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
    // In Java, strings are immutable, so we can't modify the input string in-place.
    // We can convert the string to a char array and reverse the whole string and then reverse each word.
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
