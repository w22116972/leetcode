package solution;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    private final List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, new LinkedList<>(), 0, candidates, target);
        return result;
    }

    private void dfs(int i, LinkedList<Integer> currentCombination, int currentTotal, int[] candidates, int target) {
        if (currentTotal == target) {
            result.add((List<Integer>)currentCombination.clone());
            return;
        }
        if (i >= candidates.length || currentTotal > target) {
            return;
        }

        currentCombination.addLast(candidates[i]);
        dfs(i, currentCombination, currentTotal + candidates[i], candidates, target);
        currentCombination.removeLast();
        dfs(i + 1, currentCombination, currentTotal, candidates, target);
    }
}
