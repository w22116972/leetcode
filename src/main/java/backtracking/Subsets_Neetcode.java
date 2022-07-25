package backtracking;

import java.util.LinkedList;
import java.util.List;

public class Subsets_Neetcode {
    private LinkedList<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> candidates = new LinkedList<>();
        backtrack(0, candidates, nums);
        return result;
    }

    private void backtrack(int i, LinkedList<Integer> candidates, int[] nums) {
        if (i >= nums.length) {
            result.add(new LinkedList<>(candidates));
            return;
        }
        // decide to include nums[i]
        candidates.add(nums[i]);
        backtrack(i + 1, candidates, nums);

        // decide NOT to include nums[i]
        candidates.removeLast();
        backtrack(i + 1, candidates, nums);
    }

}
