package solution;

// edge case:
// BackspaceStringCompare
public class ComparingStringsContainBackspaces {

    public static boolean sol(String s1, String s2) {
        int spaceCount1 = 0;
        int spaceCount2 = 0;
        int i1 = s1.length() - 1;
        int i2 = s2.length() - 1;

        while (i1 >= 0 && i2 >= 0) {
            final Character c1 = s1.charAt(i1);
            final Character c2 = s2.charAt(i2);
            if (c1.equals('#')) {
                spaceCount1++;
                i1--;
            } else if (c2.equals('#')) {
                spaceCount2++;
                i2--;
            } else if (spaceCount1 > 0) {
                i1--;
                spaceCount1--;
            } else if (spaceCount2 > 0) {
                i2--;
                spaceCount2--;
            } else if (!c1.equals(c2)) {
                return false;
            } else if (c1.equals(c2)) {
                i1--;
                i2--;
            }
        }
        return true;
    }

    public static boolean sol2(String s1, String s2) {
        return backspace(s1).equals(backspace(s2));
    }

    public static String backspace(String s) {
        int backspace = 0;
        StringBuilder strBuilder = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            char c = s.charAt(i);
            if (c == '#') {
                backspace++;
            } else if (backspace > 0) {
                backspace--;
            } else {
                strBuilder.append(c);
            }
            i--;
        }
        return strBuilder.reverse().toString();
    }
}
