public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int leftSum = 0;
        int rightSum = 0;
        for (int i: nums) {
            rightSum += i;
        }
        rightSum -= nums[0];
        if (leftSum == rightSum) {
            return 0;
        }

        for (int current = 0; current < nums.length; current++) {

            leftSum += nums[current];
            rightSum -= nums[current];
            if (leftSum == rightSum) {
                return current;
            }
        }

        return -1;
    }
}
