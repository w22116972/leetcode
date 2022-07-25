package array;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }

        int lastIndex = arr.length;
        int rightMax = arr[lastIndex - 1];
        for (int i = lastIndex - 2; i >= 0; i--) {
            if (arr[i] > rightMax) {
                int temp = arr[i];
                arr[i] = rightMax;
                rightMax = temp;
            } else {
                arr[i] = rightMax;
            }
        }
        arr[lastIndex - 1] = -1;
        return arr;
    }
}
