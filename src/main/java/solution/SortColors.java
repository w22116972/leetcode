package solution;

public class SortColors {

    public void sortColors(int[] nums) {
        int n0 = -1;
        int n1 = -1;
        int n2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[++n2] = 2;
                nums[++n1] = 1;
                nums[++n0] = 0;
            } else if (nums[i] == 1) {
                nums[++n2] = 2;
                nums[++n1] = 1;
            } else if (nums[i] == 2) {
                nums[++n2] = 2;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int zeroInsertIndex = 0;
        int twoInsertIndex = nums.length - 1;
        int currentIndex = 0;

        while (currentIndex <= twoInsertIndex) {
            if (nums[currentIndex] == 0) {
                swap(nums, currentIndex, zeroInsertIndex);
                zeroInsertIndex++;
                currentIndex++;
            } else if (nums[currentIndex] == 2) {
                swap(nums, currentIndex, twoInsertIndex);
                twoInsertIndex--;
            } else { // if 1
                currentIndex++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
