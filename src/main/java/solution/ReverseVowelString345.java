package solution;

public class ReverseVowelString345 {

    public static void main(String[] args) {
        final ReverseVowelString345 sol = new ReverseVowelString345();
        System.out.println("sol.reverseVowels(\"hello\") = " + sol.reverseVowels("hello"));
    }

    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length - 1;
        while (left <= right) {
            if (!isVowel(c[left])) {
                left++;
            } else if (!isVowel(c[right])) {
                right--;
            } else if (isVowel(c[left]) && isVowel(c[right])) {
                char temp = c[right];
                c[right] = c[left];
                c[left] = temp;
                left++;
                right--;
            }
        }
        return new String(c);
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
