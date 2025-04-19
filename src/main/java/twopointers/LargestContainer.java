package twopointers;

public class LargestContainer {
    public int largestContainer(int[] height) {
        int maxWater = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            // Calculate the water contained between the current pair of lines.
            int water = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, water);
            // Move the pointers inward, always moving the pointer at the shorter line.
            // If both lines have the same height, move both pointers inward.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        System.out.println("Tests an empty array.\n" +
                " Input: height=[]\n" +
                " Expected output: 0\n" +
                " Actual output: " + new LargestContainer().largestContainer(new int[]{}));

        System.out.println("Tests an array with one element.\n" +
                " Input: height=[1]\n" +
                " Expected output: 0\n" +
                " Actual output: " + new LargestContainer().largestContainer(new int[]{1}));

        System.out.println("Tests an array with no containers that can contain water.\n" +
                " Input: height=[0, 1, 0]\n" +
                " Expected output: 0\n" +
                " Actual output: " + new LargestContainer().largestContainer(new int[]{0, 1, 0}));

        System.out.println("Tests an array where all heights are the same.\n" +
                " Input: height=[3, 3, 3, 3]\n" +
                " Expected output: 9\n" +
                " Actual output: " + new LargestContainer().largestContainer(new int[]{3, 3, 3, 3}));

        System.out.println("Tests an array with strictly increasing heights.\n" +
                " Input: height=[1, 2, 3]\n" +
                " Expected output: 2\n" +
                " Actual output: " + new LargestContainer().largestContainer(new int[]{1, 2, 3}));

        System.out.println("Tests an array with strictly decreasing heights.\n" +
                " Input: height=[3, 2, 1]\n" +
                " Expected output: 2\n" +
                " Actual output: " + new LargestContainer().largestContainer(new int[]{3, 2, 1}));  }
}
