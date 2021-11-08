package string;

public class Strstr {
    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            int h = i;
            int n = 0;
            boolean find = true;
            while (h < haystack.length() && n < needle.length()) {
                if (!(haystack.charAt(h) == (needle.charAt(n)))) {
                    find = false;
                    break;
                }
                h++;
                n++;
            }
            if (find && n == needle.length()) {
                return i;
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(Strstr.strStr("hello", "ll"));
    }
}
