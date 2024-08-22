package solution;

import java.util.HashMap;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> remainDurationToCount = new HashMap<>();
        int numberOfPairs = 0;
        for (int i = 0; i < time.length; i++) {
            int currentDuration = time[i] % 60;
            // Consider the case when currentDuration = 0, then 60 - currentDuration = 60, which causes 0, 60 to be counted twice.
            if (remainDurationToCount.containsKey((60 - currentDuration) % 60)) {
                numberOfPairs += remainDurationToCount.get((60 - currentDuration) % 60);
            }
            remainDurationToCount.put(currentDuration, remainDurationToCount.getOrDefault(currentDuration, 0) + 1);
        }
        return numberOfPairs;
    }

    public static void main(String[] args) {
        PairsOfSongsWithTotalDurationsDivisibleBy60 pairsOfSongsWithTotalDurationsDivisibleBy60 = new PairsOfSongsWithTotalDurationsDivisibleBy60();
        int[] time = {30,20,150,100,40};
        System.out.println(pairsOfSongsWithTotalDurationsDivisibleBy60.numPairsDivisibleBy60(time));
    }
}
