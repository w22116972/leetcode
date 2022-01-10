package dp;

public class JumperGame {
    public boolean greedy(int[] nums) {
        final int n = nums.length;
        int farthest = 0;
        // 走到倒數第二個index
        for (int i = 0; i < n - 1; i++) {
            // 計算局部最遠距離，並更新全域最遠距離
            farthest = Math.max(farthest, i + nums[i]);
            // 如果更新完發現還在原地，代表卡住了 (因為此處位置是i)
            if (farthest <= i) {
                return false;
            }
        }
        // 如果最遠距離有走到最後的index(= n - 1)
        return farthest >= n - 1;
    }
}
