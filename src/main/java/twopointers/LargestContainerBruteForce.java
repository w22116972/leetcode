package twopointers;

public class LargestContainerBruteForce {
    public int largestContainerBruteForce(int[] height) {
        int n = height.length;
        int maxWater = 0;
        // Find the maximum amount of water stored between all pairs of lines.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Calculate the area of the container formed by the lines at indexes i and j.
                int water = Math.min(height[i], height[j]) * (j - i);
                // Update the maximum amount of water stored.
                maxWater = Math.max(maxWater, water);
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        System.out.println("Tests an empty array.\n" +
                " Input: height=[]\n" +
                " Expected output: 0\n" +
                " Actual output: " + new LargestContainerBruteForce().largestContainerBruteForce(new int[]{}));

        System.out.println("Tests an array with one element.\n" +
                " Input: height=[1]\n" +
                " Expected output: 0\n" +
                " Actual output: " + new LargestContainerBruteForce().largestContainerBruteForce(new int[]{1}));

        System.out.println("Tests an array with no containers that can contain water.\n" +
                " Input: height=[0, 1, 0]\n" +
                " Expected output: 0\n" +
                " Actual output: " + new LargestContainerBruteForce().largestContainerBruteForce(new int[]{0, 1, 0}));

        System.out.println("Tests an array where all heights are the same.\n" +
                " Input: height=[3, 3, 3, 3]\n" +
                " Expected output: 9\n" +
                " Actual output: " + new LargestContainerBruteForce().largestContainerBruteForce(new int[]{3, 3, 3, 3}));

        System.out.println("Tests an array with strictly increasing heights.\n" +
                " Input: height=[1, 2, 3]\n" +
                " Expected output: 2\n" +
                " Actual output: " + new LargestContainerBruteForce().largestContainerBruteForce(new int[]{1, 2, 3}));

        System.out.println("Tests an array with strictly decreasing heights.\n" +
                " Input: height=[3, 2, 1]\n" +
                " Expected output: 2\n" +
                " Actual output: " + new LargestContainerBruteForce().largestContainerBruteForce(new int[]{3, 2, 1})); }
}
