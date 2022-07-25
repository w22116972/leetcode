package hashtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // mapping value to list of index
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int value = nums[i];
            if (!map.containsKey(value)) {
                final LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(value, list);
            } else {
                final List<Integer> listOfIndex = map.get(value);
                for (int index: listOfIndex) {
                    if (Math.abs(i - index) <= k) {
                        return true;
                    }
                }
                listOfIndex.add(i);
                map.put(value, listOfIndex);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        final int[] ints = new int[]{1, 0, 1, 1};
        final int k = 1;
        final boolean isContain = new ContainsDuplicateII().containsNearbyDuplicate(ints, k);
        System.out.println("isContain = " + isContain);
    }
}
