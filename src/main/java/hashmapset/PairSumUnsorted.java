package hashmapset;

import java.util.Arrays;
import java.util.HashMap;

public class PairSumUnsorted {
    public int[] pairSumUnsorted(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[] {hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        System.out.println("Tests an empty array. Expected output: " + Arrays.toString(new PairSumUnsorted().pairSumUnsorted(new int[]{}, 0)));
        System.out.println("Tests an array with one element. Expected output: " + Arrays.toString(new PairSumUnsorted().pairSumUnsorted(new int[]{1}, 1)));
        System.out.println("Tests a two-element array that contains a pair that sums to the target. Expected output: " + Arrays.toString(new PairSumUnsorted().pairSumUnsorted(new int[]{2, 3}, 5)));
        System.out.println("Tests a two-element array that does not contain a pair that sums to the target. Expected output: " + Arrays.toString(new PairSumUnsorted().pairSumUnsorted(new int[]{2, 4}, 5)));
        System.out.println("Tests an array with duplicated values. Expected output: " + Arrays.toString(new PairSumUnsorted().pairSumUnsorted(new int[]{2, 2, 3}, 5)));
        System.out.println("Tests if the algorithm works with a negative number in the target pair. Expected output: " + Arrays.toString(new PairSumUnsorted().pairSumUnsorted(new int[]{-1, 2, 3}, 2)));
        System.out.println("Tests if the algorithm works with both numbers of the target pair being negative. Expected output: " + Arrays.toString(new PairSumUnsorted().pairSumUnsorted(new int[]{-3, -2, -1}, -5)));
    }
}
