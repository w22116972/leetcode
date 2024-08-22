package solution;

// If range is in [0, 100], S(n) should = O(100)
public class FindMedianFromDataStreamFollowUp {
    int[] countByNumber;
    int medianIndex;
    int medianIndex2;

    public FindMedianFromDataStreamFollowUp() {
        countByNumber = new int[101];
        medianIndex = 0;
        medianIndex2 = 0;
    }

    public void addNum(int num) {

    }

    public double findMedian() {
        if (medianIndex == medianIndex2) {
            return countByNumber[medianIndex];
        } else {
            return ((double) countByNumber[medianIndex] + (double) countByNumber[medianIndex2]) / 2;
        }
    }
}
