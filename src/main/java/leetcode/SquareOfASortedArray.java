package leetcode;

/*
* Given an integer array nums sorted in non-decreasing order,
* return an array of the squares of each number sorted in non-decreasing order.
* */
//        Example 1:
//        Input: [-2, -1, 0, 2, 3]
//        Output: [0, 1, 4, 4, 9]
//        Example 2:
//        Input: [-3, -1, 0, 1, 2]
//        Output: [0 1 1 4 9]
public class SquareOfASortedArray {

    public static int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length];
        int index = result.length - 1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            double leftSquare = Math.pow(nums[left], 2);
            double rightSquare = Math.pow(nums[right], 2);
            if (leftSquare >= rightSquare) {
                result[index] = (int)leftSquare;
                left++;
            } else {
                result[index] = (int)rightSquare;
                right--;
            }
            index--;
        }
        return result;
    }

    public static int[] squareArray(int[] arr) {
        int[] result = new int[arr.length];
        int start = 0;
        int end = arr.length - 1;
        int insertIndex = arr.length - 1;
        while (start <= end) {
            if (Math.pow(arr[start], 2) > Math.pow(arr[end], 2)) {
                result[insertIndex] = (int)Math.pow(arr[start], 2);
                start++;
            } else {
                result[insertIndex] = (int)Math.pow(arr[end], 2);
                end--;
            }
            insertIndex--;
        }
        return result;
    }

    public static int[] sol(int[] arr) {
        // Since the larger number could be near the front and back of array,
        // we should use two pointers to trace front and back.
        // After comparing which one is the larger square number, we could put this number into latter part of result array.
        // The order to insert into result array should be starting from the end to the beginning.
        int frontIndex = 0;
        int backIndex = arr.length - 1;
        int[] result = new int[arr.length];
        int insertIndexOfResult = arr.length - 1;
        while (frontIndex < backIndex) {
            final int frontNumber = arr[frontIndex] * arr[frontIndex];
            final int backNumber = arr[backIndex] * arr[backIndex];
            final int largerNumber = Math.max(frontNumber, backNumber);
            if (frontNumber > backNumber) {
                frontIndex++;
            } else {
                backIndex--;
            }
            result[insertIndexOfResult] = largerNumber;
            insertIndexOfResult--;
        }
        result[insertIndexOfResult] = arr[frontIndex];
        return result;
    }

    public static int[] practice(int[] arr) {
        //
        int positiveIndex = arr.length - 1;
        int negativeIndex = 0;
        int i = arr.length - 1;
        final int[] result = new int[arr.length];
        while (negativeIndex <= positiveIndex) {
            final int squaredNumberOnNegativeSide = (int) Math.pow(arr[negativeIndex], 2);
            final int squaredNumberOnPositiveSide = (int) Math.pow(arr[positiveIndex], 2);
            if (squaredNumberOnNegativeSide >= squaredNumberOnPositiveSide) {
                result[i] = squaredNumberOnNegativeSide;
                negativeIndex++;
            } else {
                result[i] = squaredNumberOnPositiveSide;
                positiveIndex--;
            }
            i--;
        }
        return result;
    }


}
