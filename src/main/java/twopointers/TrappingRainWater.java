package twopointers;

public class TrappingRainWater {

    public int sol(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        int leftMaxHeight= 0;
        int rightMaxHeight= 0;

        while (left < right) {
            leftMaxHeight = Math.max(leftMaxHeight, height[left]);
            rightMaxHeight = Math.max(rightMaxHeight, height[right]);

            if (leftMaxHeight < rightMaxHeight) {
                max += leftMaxHeight - height[left];
                left++;
            } else {
                max += rightMaxHeight - height[right];
                right++;
            }
        }
        return max;
    }
}
