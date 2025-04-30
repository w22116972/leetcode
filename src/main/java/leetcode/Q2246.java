package leetcode;

// 2446. Determine if Two Events Have Conflict
public class Q2246 {
    public boolean haveConflict(String[] event1, String[] event2) {
        String start1 = event1[0];
        String end1 = event1[1];
        String start2 = event2[0];
        String end2 = event2[1];

        // Just need to check if s1 or e1 is in range of [s2, e2]
        // case 1
        // s1 - s2 - e1 - e2
        if (isLater(start1, start2) && isLater(start2, end1)) {
            return true;
        }

        // case 2
        // s2 - s1 - e2 - e1
        if (isLater(start2, start1) && isLater(start1, end2)) {
            return true;
        }

        return false;

    }

    public boolean isLater(String input1, String input2) {
        String[] time1 = input1.split(":");
        int hour1 = Integer.parseInt(time1[0]);
        int min1 = Integer.parseInt(time1[1]);

        String[] time2 = input2.split(":");
        int hour2 = Integer.parseInt(time2[0]);
        int min2 = Integer.parseInt(time2[1]);

        if (hour2 > hour1) {
            return true;
        } else if (hour2 == hour1 && min2 >= min1) {
            return true;
        } else {
            return false;
        }
    }
}
