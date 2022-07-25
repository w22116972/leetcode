package codility;

public class StrSymmetryPoint {
    public int solution100(String S) {
        if (S.length() == 1 ) {
            return 0;
        }

        if (S.length() % 2 == 0) {
            return -1;
        }

        int i = 0;
        int j = S.length() - 1;
        while (i < j) {
            if (S.charAt(i) != S.charAt(j)) {
                return -1;
            }
            i++;
            j--;
        }
        return S.length() / 2;
    }
}
