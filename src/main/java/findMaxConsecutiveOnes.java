public class findMaxConsecutiveOnes {
    public static int sol(int[] nums) {
        int max1s = 0;
        int current1s = 0;
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            if (num == 1) {
                current1s++;
            } else {
                max1s = Math.max(max1s, current1s);
                current1s = 0;
            }
        }
        max1s = Math.max(max1s, current1s);
        return max1s;
    }
}
