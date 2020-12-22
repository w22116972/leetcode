package twopointers;

import java.util.Arrays;

public class TripletSumLessThanTarget {
    public static int countTripletSumLessThanTarget(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int x = 0; x < arr.length - 2; x++) {
            int y = x + 1;
            int z = arr.length - 1;
            while (y < z) {
                int currentSum = arr[x] + arr[y] + arr[z];
                if (currentSum < target) {
                    count+= (y-z);
                    y++;
                }
                else {
                    z--;
                }
            }
        }
        return count;
    }
}
