package cyclicsort;

import util.Util;

public class CyclicSort {
    public static int[] sol(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // [2, 3, 1]
            // arr[0]=2 != (i=0) + 1 -> swap i, arr[i] - 1
            while (arr[i] != i + 1) {
                // swap
                Util.swap(arr, arr[i] - 1, i);
            }
        }
        return arr;
    }



    public static void main(String[] args) {
        int[] ints = {3, 1, 5, 4, 2};
        final int[] answer = sol(ints);
        Util.printArray(answer);
    }
}
