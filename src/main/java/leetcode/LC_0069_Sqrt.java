package leetcode;

public class LC_0069_Sqrt {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x / 2; // x / 2 is the maximum possible integer square root
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevent overflow


            if (mid <= x / mid) { // Avoid overflow by using division instead of mid * mid
                result = mid;    // mid is a candidate, but we need to find the largest
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
