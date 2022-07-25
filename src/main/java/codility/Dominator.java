package codility;

import java.util.HashMap;

public class Dominator {
    public int solution100(int[] A) {
        // write your code in Java SE 11
        final int n = A.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            final int val = A[i];
            if (!map.containsKey(val)) {
                map.put(val, 1);
            } else {
                map.put(val, map.get(val) + 1);
            }
            if (map.get(val) > n) {
                return i;
            }
        }
        return -1;
    }
}
