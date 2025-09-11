package leetcode;

public class Q27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int nonValIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[nonValIndex] = nums[i];
                nonValIndex++;
            }
        }
        return nonValIndex;
    }
}
