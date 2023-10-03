public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        final int[] result = new int[nums.length];
        int i = nums.length - 1;
        while (head < tail) {
            final int headSquare = (int) Math.pow(nums[head], 2);
            final int tailSquare = (int) Math.pow(nums[tail], 2);
            // put tailSquare
            if (headSquare < tailSquare) {
                result[i] = tailSquare;
                tail--;
            } else {
                result[i] = headSquare;
                head++;
            }
            i--;
        }
        result[i] = (int) Math.pow(nums[head], 2);
        return result;
    }

}
