package dfs;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(path, nums, result);
        return result;
    }

    public void dfs(List<Integer> path, int[] nums, List<List<Integer>> result) {
        // 終止條件 path含有的數字跟要排列的數字一樣多
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
        } else {
            // 從選項中做出選擇
            for (int num : nums) {
                if (path.contains(num)) {
                    continue;
                }
                path.add(num);
                dfs(path, nums, result);
                path.remove(Integer.valueOf(num));
            }
        }
    }


}
