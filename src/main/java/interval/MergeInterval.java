package interval;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

public class MergeInterval {
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        intervals.sort(Comparator.comparing(interval -> interval.start));
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next(); // a
        int start = interval.start; // a.start
        int end = interval.end; // a.end

        while (intervalItr.hasNext()) {
            interval = intervalItr.next(); // b
            if (interval.start <= end) { // b.start <= a.end
                end = Math.max(interval.end, end); // set c.end
            } else { //

            }

        }


        return mergedIntervals;
    }

}
