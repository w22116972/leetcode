package twopointers;

import java.util.ArrayList;
import java.util.List;

//Problem Statement
//        Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
//        Example 1:
//        Input: [-2, -1, 0, 2, 3]
//        Output: [0, 1, 4, 4, 9]
//        Example 2:
//        Input: [-3, -1, 0, 1, 2]
//        Output: [0 1 1 4 9]
public class SquareSortedArray {

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


}
