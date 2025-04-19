package hashmapset;

import java.util.HashMap;

public class GeometricSequenceTriplets {
    public int geometricSequenceTriplets(int[] nums, int r) {
        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        int count = 0;

        // Populate 'rightMap' with the frequency of each element in the array.
        // Note: hashMap.put is used to add a key-value pair to the map.
        // Note: hashMap.getOrDefault is used to get the value of a key in the map. If the key is not present, it returns the default value.
        for (int num : nums) {
            rightMap.put(num, rightMap.getOrDefault(num, 0) + 1);
        }

        // Search for geometric triplets that have x as the center.
        for (int num: nums) {
            // Decrement the frequency of x in 'right_map' since x is now being processed and is no longer to the right.
            rightMap.put(num, rightMap.get(num) - 1);
            if (num % r == 0) {
                count += leftMap.getOrDefault(num / r, 0) * rightMap.getOrDefault(num * r, 0);
            }
            // Increment the frequency of x in 'left_map' since it'll be a part of the left side of the array once we iterate to the next value of x.
            leftMap.put(num, leftMap.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}
