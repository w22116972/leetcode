import java.util.concurrent.ConcurrentHashMap;

/*
        Problem Statement
        Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
        Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
        Example 1:
        Input: [1, 2, 3, 4, 6], target=6
        Output: [1, 3]
        Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
        Example 2:
        Input: [2, 5, 9, 11], target=11
        Output: [0, 2]
        Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
*/
public class PairWithTargetSum {

    // both start in same direction
    // T = O(^2)
    public static int[] traverseSameDirection(int[] arr, int target) {
        for (int slow = 0; slow < arr.length - 1; slow++) {
            for (int fast = slow + 1; fast < arr.length; fast++) {
                if (arr[slow] + arr[fast] == target) {
                    return new int[]{slow, fast};
                } else if (arr[slow] + arr[fast] > target) {
                    break;
                }
            }
        }
        return new int[]{-1, -1};
    }

    // both start in opposite directions
    // T = O(n)
    public static int[] traverseOppositeDirections(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int current_sum = arr[left] + arr[right];
            if (current_sum == target) {
                return new int[]{left, right};
            }
            if (current_sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] hashTable(int[] arr, int target) {
        // remaining value: index
        final ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                return new int []{map.get(arr[i]), i};
            } else {
                map.put(target-arr[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] practice(int[] arr, int target) {
        // declare pair of pointers that adding up to target
        // it's sorted array, we could use 2 pointers at start and end
        int headIndex = 0;
        int tailIndex = arr.length - 1;
        while (headIndex < tailIndex) {
            int currentSum = arr[headIndex] + arr[tailIndex];
            if (currentSum == target) {
                return new int[] {headIndex, tailIndex};
            } else if (currentSum < target) {
                headIndex++;
            } else if (currentSum > target) {
                tailIndex--;
            }
        }
        return new int[]{-1, -1};
    }
}
