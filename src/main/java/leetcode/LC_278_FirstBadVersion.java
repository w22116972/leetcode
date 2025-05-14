package leetcode;

public class LC_278_FirstBadVersion {
    public int firstBadVersion(int n) {
        return findByBinarySearch(1, n);
    }

    public int findByBinarySearch(int left, int right) {
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    // The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version) {
        return true;
    }
}

