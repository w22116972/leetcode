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
    public static void main(String[] args) {
        int[] input1 = new int[]{-2, -1, 0, 2, 3};
        int[] input2 = new int[]{-3, -1, 0, 1, 2};

        for (int i: squareArray(input1)) {
            System.out.print(i);
        }

        System.out.println("\n---");
        for (int i: squareArray(input2)) {
            System.out.print(i);
        }

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
//        int[] result = new int[arr.length];
//        int j = 0;
//        for (int i = temp.size()-1; i >= 0; i --) {
//            result[j] = temp.get(i);
//            j++;
//        }
        return result;
    }
}
