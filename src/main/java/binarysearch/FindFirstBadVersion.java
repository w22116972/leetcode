package binarysearch;

public class FindFirstBadVersion {

    public int firstBadVersion(int n) {
        int head = 0;
        int tail = n;
        while (tail - head > 1) {
            int mid = head + (tail - head) / 2;
            if (isBadVersion(mid)) {
                tail = mid;
            } else {
                head = mid;
            }
        }
        return tail;
//            System.out.println("head = " + head);
//            System.out.println("tail = " + tail);
//            //  (a / 2) + (b / 2) + (((a % 2) + (b % 2)) / 2)
//            final int mid = head + (tail - head) / 2;
//            final boolean isMidBad = isBadVersion(mid);
//            if (isMidBad && !isBadVersion(mid - 1)) {
//                return mid;
//            } else if (isMidBad && isBadVersion(mid - 1)) {
//                tail = mid;
//            } else if (!isMidBad && isBadVersion(mid + 1)) {
//                return mid + 1;
//            } else {
//                head = mid;
//            }
//            System.out.println("mid = " + mid);
//        }
//        if (isBadVersion(head)) {
//
//            return head;
//        }
//        if (isBadVersion(head - 1) && !isBadVersion(head)) {
//
//        }
//        return -1;
    }

    public boolean isBadVersion(int i) {
        return i == 1702766719;
    }

    public static void main(String[] args) {
        System.out.println(new FindFirstBadVersion().firstBadVersion(2126753390));
    }
}
