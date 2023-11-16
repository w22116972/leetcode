import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> numToOccurrence = new HashMap<>();
        for (int i: arr) {
            numToOccurrence.put(i, numToOccurrence.getOrDefault(i, 0) + 1);
        }
        return numToOccurrence.size() == new HashSet<>(numToOccurrence.values()).size();

    }
}
