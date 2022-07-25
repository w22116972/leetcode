package paypay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;

public class CodeSignal1 {
    public int[] solution(int[] a) {
        HashMap<Integer, Integer> digitToFrequency = new HashMap<>();
        int maxFrequency = 0;
        HashSet<Integer> digitWithMaxFrequency = new HashSet<>();
        for (int i: a) {
            final char[] chars = String.valueOf(i).toCharArray();
            for (char c: chars) {
                final int value = Character.getNumericValue(c);
                if (digitToFrequency.containsKey(value)) {
                    digitToFrequency.put(value, digitToFrequency.get(value) + 1);
                } else {
                    digitToFrequency.put(value, 1);
                }
                if (digitToFrequency.get(value) > maxFrequency) {
                    digitWithMaxFrequency.clear();
                    digitWithMaxFrequency.add(value);
                    maxFrequency = digitToFrequency.get(value);
                } else if (digitToFrequency.get(value) == maxFrequency) {
                    digitWithMaxFrequency.add(value);
                }
            }
        }
        return digitWithMaxFrequency.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        final CodeSignal1 sol = new CodeSignal1();
        final int[] solution = sol.solution(new int[]{25, 2, 3, 57, 38, 41});
        System.out.println("solution = " + Arrays.toString(solution));
    }
}
