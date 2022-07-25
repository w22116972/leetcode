package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(Arrays.stream(nums).boxed().collect(Collectors.toList()), 0, track);
        return result;
    }

    // start: number that the subset starts with
    private void backtrack(List<Integer> nums, int start, LinkedList<Integer> track) {
        // preorder traversal
        result.add((List<Integer>) track.clone());
        // subsets start with `start`
        for (int i = start; i < nums.size(); i++) {
            // do choice
            track.addLast(nums.get(i));

            // recur backtrack
            backtrack(nums, i + 1, track);
            // revoke choice
            track.removeLast();
        }
    }



    public static void main(String[] args) {
        System.out.println("subsets({1, 2, 3}) = " + new Subsets().subsets(new int[]{1, 2, 3}));
    }
}
