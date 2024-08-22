package solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int result = 0;
        int prevEnd = intervals[0][1];
        for (int[] interval: Arrays.stream(intervals).skip(1).toList()) {
            final int start = interval[0];
            final int end = interval[1];
            if (start >= prevEnd) {
                prevEnd = end;
            } else {
                result += 1;
                prevEnd = Math.min(end, prevEnd);
            }

        }
        return result;

    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        System.out.println("arr = " + Arrays.deepToString(arr));
    }

//    class Sortbyroll implements Comparator<Integer> {
//        // Used for sorting in ascending order of
//        // roll number
//        public int compare(Integer a, Integer b)
//        {
//            return a - b;
//        }
//    }

//    public static void main(String[] args) {
//        new NonOverlappingIntervals().eraseOverlapIntervals(new int[] {});
//    }
}
