// Sort Colors

// Given an array containing 0s, 1s and 2s, sort the array in-place.
public class DutchNationalFlag {
    // To make sure 0s are left-hand side and 2s are right-hand side
    // Use two pointers, one points to "next 0 to be inserted index" and other points to "next 2 to be inserted index"
    public static int[] sol(int[] arr) {
        int next0Index = 0;
        int next2Index = arr.length - 1;
        int i = 0;
        while (i <= next2Index) {
            final int num = arr[i];
            if (num == 0) {
                int temp = arr[next0Index];
                arr[i] = temp;
                arr[next0Index] = num;
                next0Index++;
                i++;
            } else if (num == 2) {
                int temp = arr[next2Index];
                arr[i] = temp;
                arr[next2Index] = num;
                next2Index--;
            } else {
                i++;
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        sol(new int[]{1, 0, 2, 1, 0});
        sol(new int[]{2, 2, 0, 1, 2, 0});
    }
}
