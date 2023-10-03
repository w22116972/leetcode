public class FindMinInRotatedSortedArray {
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[right] < nums[mid]) {  // search right
                left = mid + 1;  // mid itself is definite not the answer
            } else {  // mid ~ right is sorted correctly, so search left.
                // it is possible that mid itself is answer, so it needs to include mid
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new FindMinInRotatedSortedArray().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new FindMinInRotatedSortedArray().findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(new FindMinInRotatedSortedArray().findMin(new int[]{11,13,15,17}));
        System.out.println(new FindMinInRotatedSortedArray().findMin(new int[]{1}));
        System.out.println(new FindMinInRotatedSortedArray().findMin(new int[]{2, 1}));
    }
}
