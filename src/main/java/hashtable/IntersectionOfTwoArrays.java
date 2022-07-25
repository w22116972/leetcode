package hashtable;

import java.util.HashSet;
import java.util.LinkedList;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i: nums1) {
            set.add(i);
        }
        final HashSet<Integer> result = new HashSet<>();

        for (int i: nums2) {
            if (set.contains(i)) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
