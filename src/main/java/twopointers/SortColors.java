package twopointers;

public class SortColors {
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        int i = 0;
        while (i < nums.length) {
            final int num = nums[i];
            if (num == 0) {
                swap(nums, zeroIndex, i);
                zeroIndex++;
            } else if (num == 2) {
                swap(nums, twoIndex, i);
                twoIndex--;
            }
            i++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
