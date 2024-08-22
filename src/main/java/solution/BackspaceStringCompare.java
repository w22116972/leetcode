package solution;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        return applyBackspace(s).equals(applyBackspace(t));
    }

    public static String applyBackspace(String str) {
        StringBuilder sb = new StringBuilder();
        int backspaceCount = 0;
        int i = str.length() - 1;
        while (i >= 0) {
            if (str.charAt(i) == '#') {
                backspaceCount++;
            } else if (backspaceCount > 0) {
                backspaceCount--;
            } else {
                sb.append(str.charAt(i));
            }
            i--;
        }

        return sb.reverse().toString();
    }
}
