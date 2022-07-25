package string;

public class AddBinary {
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int prog = 0;
        StringBuilder result = new StringBuilder();
        while (aIndex >= 0 && bIndex >= 0) {
            final int aInt = aIndex >= 0? a.charAt(aIndex) - 48 : 0;
            final int bInt = bIndex >= 0? b.charAt(bIndex) - 48 : 0;
            int sum = aInt + bInt + prog;
            if (sum == 3) {
                result.append("1");
                prog = 1;
            } else if (sum == 2) {
                result.append("0");
                prog = 1;
            } else if (sum == 1) {
                result.append("1");
                prog = 0;
            } else {
                result.append("0");
                prog = 0;
            }

            aIndex--;
            bIndex--;
        }

        return result.reverse().toString();
    }


    public String addBinary2(String a, String b) {
        int i = 0;
        int prog = 0;
        final StringBuilder result = new StringBuilder();
        int maxLength = Math.max(a.length(), b.length());
        while (i < maxLength) {
            final int aInt = i < a.length()? a.charAt(i) - 48 : 0;
            final int bInt = i < b.length()? b.charAt(i) - 48 : 0;
            int sum = aInt + bInt + prog;
            if (sum == 3) {
                result.append("1");
                prog = 1;
            } else if (sum == 2) {
                result.append("0");
                prog = 1;
            } else if (sum == 1) {
                result.append("1");
                prog = 0;
            } else {
                result.append("0");
                prog = 0;
            }
            i++;
        }
        if (prog == 1) {
            result.append("1");
        }

        return result.reverse().toString();
    }
}
