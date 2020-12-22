package twopointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {

    public static int getTripletSumCloseToTarget(int[] arr, int target) {

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int x = 0; x < arr.length - 2; x++) {
            int y = x + 1;
            int z = arr.length - 1;
            while (y < z) {
                int currentSum = arr[x] + arr[y] + arr[z];
                int currentDiff = Math.abs(target - currentSum);
                if (currentDiff == 0) {
                    return target;
                }
                if (currentDiff < minDiff) {
                    minDiff = currentDiff;
                }
                if (target > currentSum) { // current sum need to be bigger
                    y++;
                } else {
                    z--;
                }
            }
        }
        return target - minDiff;
    }

}
