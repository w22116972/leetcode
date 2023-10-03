import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int count = 0;
        int maxCount = 0;
        int startIndex = 0;
        int endIndex = 0;
        while (startIndex < intervals.length) {
            if (starts[startIndex] < ends[endIndex]) {
                startIndex++;
                count++;
            } else {
                endIndex++;
                count--;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
