package leetcode;

public class LC_26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int uniqueNumberIndex = 1;

        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                nums[uniqueNumberIndex] = nums[i];
                prev =  nums[i];
                uniqueNumberIndex++;
            }
        }

        return uniqueNumberIndex;
    }
}
