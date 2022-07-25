package twopointers;

public class ReverseWordsInStringIII {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int start = 0;
        int end = 0;
        while (start < s.length() && end < s.length()) {
            if (s.charAt(start) == ' ') {
                result.append(s.charAt(start));
                start++;
                end++;
            } else if (s.charAt(end) != ' ') {
                end++;
            } else if (s.charAt(end) == ' ') {
                int i = start;
                int j = end - 1;
                while (j >= i) {
                    result.append(s.charAt(j));
                    j--;
                }
                start = end;
                end++;

            }
        }
        if (s.charAt(end - 1) != ' ' && start < s.length()) {
            int j = end - 1;
            while (j >= start) {
                result.append(s.charAt(j));
                j--;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInStringIII().reverseWords("Let's take LeetCode contest"));

    }
}
