package leetcode;

public class Q80_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 1;
        int prev = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                if (count < 2) {
                    nums[index] = nums[i];
                    count++;
                    index++;
                }
            } else {
                nums[index] = nums[i];
                prev = nums[i];
                count = 1;
                index++;
            }
        }
        return index;
    }
}
