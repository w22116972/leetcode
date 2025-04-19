package twopointers;

import java.util.Arrays;

public class ShiftZerosToTheEndNaive {
    public void shiftZerosToTheEndNaive(int[] nums) {
        int[] temp = new int[nums.length];
        int i = 0;
        // Add all non-zero elements to the left of 'temp'.
        for (int num : nums) {
            if (num != 0) {
                temp[i] = num;
                i++;
            }
        }
        // Set 'nums' to 'temp'
        // Note: `System.arraycopy` Copies an array from the specified source array, beginning at the specified position, to the specified position of the destination array.
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{};
        new ShiftZerosToTheEndNaive().shiftZerosToTheEndNaive(test1);
        System.out.println("Tests an empty array.\n" +
                " Input: nums=[]\n" +
                " Expected output: []\n" +
                " Actual output: " + Arrays.toString(test1));

        int[] test2 = new int[]{0};
        new ShiftZerosToTheEndNaive().shiftZerosToTheEndNaive(test2);
        System.out.println("Tests an array with one 0.\n" +
                " Input: nums=[0]\n" +
                " Expected output: [0]\n" +
                " Actual output: " + Arrays.toString(test2));

        int[] test3 = new int[]{1};
        new ShiftZerosToTheEndNaive().shiftZerosToTheEndNaive(test3);
        System.out.println("Tests an array with one 1.\n" +
                " Input: nums=[1]\n" +
                " Expected output: [1]\n" +
                " Actual output: " + Arrays.toString(test3));

        int[] test4 = new int[]{0, 0, 0};
        new ShiftZerosToTheEndNaive().shiftZerosToTheEndNaive(test4);
        System.out.println("Tests an array with all 0s.\n" +
                " Input: nums=[0, 0, 0]\n" +
                " Expected output: [0, 0, 0]\n" +
                " Actual output: " + Arrays.toString(test4));

        int[] test5 = new int[]{1, 3, 2};
        new ShiftZerosToTheEndNaive().shiftZerosToTheEndNaive(test5);
        System.out.println("Tests an array with all non-zeros.\n" +
                " Input: nums=[1, 3, 2]\n" +
                " Expected output: [1, 3, 2]\n" +
                " Actual output: " + Arrays.toString(test5));

        int[] test6 = new int[]{1, 1, 1, 0, 0};
        new ShiftZerosToTheEndNaive().shiftZerosToTheEndNaive(test6);
        System.out.println("Tests an array with all zeros already at the end.\n" +
                " Input: nums=[1, 1, 1, 0, 0]\n" +
                " Expected output: [1, 1, 1, 0, 0]\n" +
                " Actual output: " + Arrays.toString(test6));

        int[] test7 = new int[]{0, 0, 1, 1, 1};
        new ShiftZerosToTheEndNaive().shiftZerosToTheEndNaive(test7);
        System.out.println("Tests an array with all zeros at the start.\n" +
                " Input: nums=[0, 0, 1, 1, 1]\n" +
                " Expected output: [1, 1, 1, 0, 0]\n" +
                " Actual output: " + Arrays.toString(test7));  }
}
