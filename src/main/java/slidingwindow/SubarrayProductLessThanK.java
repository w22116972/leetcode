package slidingwindow;

import java.util.LinkedList;
import java.util.List;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int currentProduct = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            currentProduct *= nums[right];
            while (currentProduct >= k && left <= right) {
                currentProduct /= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}
