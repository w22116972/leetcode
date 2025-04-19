package twopointers;

import java.util.*;

public class TripletSumBruteForce {
    public List<List<Integer>> tripletSumBruteForce(int[] nums) {
        int n = nums.length;
        // Use a hash set to ensure we don't add duplicate triplets.
        Set<List<Integer>> triplets = new HashSet<>();

        // Iterate through the indexes of all triplets.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // Sort the triplet before including it in the hash set.
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        triplets.add(triplet);
                    }
                }
            }
        }
        // Convert the HashSet to a List of Lists.
        return new ArrayList<>(triplets);
    }

    public static void main(String[] args) {
        System.out.println("Tests an empty array.\n" +
                " Input: nums=[]\n" +
                " Expected output: []\n" +
                " Actual output: " + new TripletSumBruteForce().tripletSumBruteForce(new int[]{}));

        System.out.println("Tests a single-element array.\n" +
                " Input: nums=[0]\n" +
                " Expected output: []\n" +
                " Actual output: " + new TripletSumBruteForce().tripletSumBruteForce(new int[]{0}));

        System.out.println("Tests a two-element array.\n" +
                " Input: nums=[1, -1]\n" +
                " Expected output: []\n" +
                " Actual output: " + new TripletSumBruteForce().tripletSumBruteForce(new int[]{1, -1}));

        System.out.println("Tests an array where all three of its values are the same.\n" +
                " Input: nums=[0, 0, 0]\n" +
                " Expected output: [[0, 0, 0]]\n" +
                " Actual output: " + new TripletSumBruteForce().tripletSumBruteForce(new int[]{0, 0, 0}));

        System.out.println("Tests an array with no triplets that sum to 0.\n" +
                " Input: nums=[1, 0, 1]\n" +
                " Expected output: []\n" +
                " Actual output: " + new TripletSumBruteForce().tripletSumBruteForce(new int[]{1, 0, 1}));

        System.out.println("Tests an array with duplicate triplets.\n" +
                " Input: nums=[0, 0, 1, -1, 1, -1]\n" +
                " Expected output: [[-1, 0, 1]]\n" +
                " Actual output: " + new TripletSumBruteForce().tripletSumBruteForce(new int[]{0, 0, 1, -1, 1, -1}));

        System.out.println("Tests an array with multiple triplets.\n" +
                " Input: nums=[-1, 0, 1, 2, -1, -4]\n" +
                " Expected output: [[-1, -1, 2], [-1, 0, 1]]\n" +
                " Actual output: " + new TripletSumBruteForce().tripletSumBruteForce(new int[]{-1, 0, 1, 2, -1, -4}));  }
}
