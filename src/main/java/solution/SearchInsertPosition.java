package solution;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        while (head < tail) {
            final int mid = (head + tail) / 2;
            final int midValue = nums[mid];
            if (target == midValue) {
                return mid;
            } else if (target < midValue) {
                tail--;
            } else {
                head++;
            }
        }
        if (target == nums[head]) {
            return head;
        } else if (target < nums[head]) {
            if (head == 0) {
                return 0;
            } else {
                return head;
            }
        } else {
            return tail + 1;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 2}, 2));
    }
}
