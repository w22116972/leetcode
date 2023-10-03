import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {

    private List<Integer> sortedCandidates;
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        sortedCandidates = Arrays.stream(candidates).sorted().boxed().toList();
        dfs(new LinkedList<>(), 0, target, sortedCandidates);
        return result;
    }

    private void dfs(LinkedList<Integer> currentCandidates, int start , int target, List<Integer> candidates) {
        if (target == 0) {
            result.add(new LinkedList<>(currentCandidates));
        }
        if (target <= 0) {
            return;
        }
        int prevCandidate = -1; // dummy value
        for (int currentIndex = start; currentIndex < candidates.size(); currentIndex++) {
            final int currentCandidate = candidates.get(currentIndex);
            // skip duplicated combinations
            if (currentCandidate == prevCandidate) {
                continue;
            }
            currentCandidates.addLast(currentCandidate);
            dfs(currentCandidates, currentIndex + 1, target - currentCandidate, candidates);
            currentCandidates.removeLast();
            prevCandidate = currentCandidate;
        }
    }
}
