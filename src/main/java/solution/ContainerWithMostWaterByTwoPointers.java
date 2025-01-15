package solution;

public class ContainerWithMostWaterByTwoPointers {
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println("Tests an empty array.\n" +
                " Input: height=[]\n" +
                " Expected output: 0\n" +
                " Actual output");
    }
}
