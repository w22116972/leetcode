import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        final List<Integer> result = new LinkedList<>();
        int start = 0;
        while (start < s.length()) {
            int end = s.length() - 1;
            while (s.charAt(end) != s.charAt(start)) {
                end--;
            }

            final HashMap<Character, Integer> map = new HashMap<>();

        }

        return result;
    }
}
