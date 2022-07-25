package codility;

import java.util.HashSet;

public class MissingInteger {
    public int Solution100(int[] A) {
        HashSet<Integer> set = new HashSet<>();

        for (int i: A) {
            set.add(i);
        }

        int i = 1;
        while (i <= A.length) {
            if (!set.contains(i)) {
                return i;
            }
            i++;
        }
        if (set.size() == A.length) {
            return i;
        }

        return -1;
    }
}
