import java.util.LinkedList;
import java.util.List;

public class Combinations {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0) {
            return result;
        }

        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n, k, 1, track);
        return result;
    }

    private void backtrack(int n, int k, int start, LinkedList<Integer> track) {
        if (track.size() == k) {
            result.add((List<Integer>) track.clone());
            return;
        }
        for (int i = start; i <= n; i++) {
            track.addLast(i);
            backtrack(n, k, i + 1, track);
            track.removeLast();
        }
    }

}
