package util;

public class Util {
    public static void printArray(int[] arr) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i: arr) {
            stringBuilder.append(i);
            stringBuilder.append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("}");
        System.out.println(stringBuilder);
    }

    public static void swap(int[] arr, int i, int j) {
        final int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
