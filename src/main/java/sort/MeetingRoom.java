package sort;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int preStart = intervals[0][0];
        int preEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            if (currentStart < preEnd) {
                return false;
            }
            preEnd = currentEnd;
        }
        return true;
    }
}
