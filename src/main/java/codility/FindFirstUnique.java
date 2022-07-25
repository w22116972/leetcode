package codility;

import java.util.*;

public class FindFirstUnique {
    public int solution100(int[] A) {
        LinkedHashMap<Integer, Boolean> set = new LinkedHashMap<>();
        for (int i: A) {
            if (set.containsKey(i)) {
                set.put(i, false);
            } else {
                set.put(i, true);
            }
        }
        return set.entrySet().stream().parallel().filter(Map.Entry::getValue).map(Map.Entry::getKey).findFirst().orElse(-1);
    }

    public int solution63(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i: A) {
            if (set.contains(i)) {
                list.remove(Integer.valueOf(i));
            } else {
                list.addLast(i);
            }
            set.add(i);

        }
        if (list.isEmpty()) {
            return -1;
        } else {
            return list.getFirst();
        }
    }
}
