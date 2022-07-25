package binarysearch;

public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j ) {
            int m = (i + j) / 2;
            if (nums[m] > nums[j]) {
                i = m + 1;
            } else {
                j = m;
            }
        }
        return nums[i];
    }

    public static void main(String[] args) {
        System.out.println(new FindMinInRotatedSortedArray().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new FindMinInRotatedSortedArray().findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(new FindMinInRotatedSortedArray().findMin(new int[]{11,13,15,17}));
        System.out.println(new FindMinInRotatedSortedArray().findMin(new int[]{1}));
        System.out.println(new FindMinInRotatedSortedArray().findMin(new int[]{2, 1}));
    }
}
