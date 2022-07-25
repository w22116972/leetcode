package design;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueNumber {

    LinkedHashMap<Integer, Boolean> list = new LinkedHashMap<>();

    public FirstUniqueNumber(int[] nums) {
        for (int i: nums) {
            if (list.containsKey(i)) {
                list.put(i, false);
            } else {
                list.put(i, true);
            }
        }

    }

    public int showFirstUnique() {
        return list.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey).findAny().orElse(-1);
    }

    public void add(int value) {
        if (list.containsKey(value)) {
            list.put(value, false);
        } else {
            list.put(value, true);
        }
    }
}
