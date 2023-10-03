public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        return findPeak(nums,0,nums.length-1);
    }

    public int findPeak(int[] nums, int start, int end) {
        int mid = start + (end-start)/2;
        if(mid >0 && nums[mid] < nums[mid-1]) return findPeak(nums, start, mid);
        else if(mid+1 < nums.length && nums[mid] < nums[mid+1]) return findPeak(nums, mid+1, end);
        else return mid;
    }
}
