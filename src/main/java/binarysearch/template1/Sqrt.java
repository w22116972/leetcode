package binarysearch.template1;

public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        } else if (x == 1 || x / 2.0 <= 2.0) {
            return 1;
        } else {
            return recur(x, 2.0, x / 2.0);
        }
    }

    public int recur(int x, double head, double last) {
        double mid = head + (last - head) / 2;
        if (mid * mid <= x && Math.floor(mid + 1) * Math.floor(mid + 1) > x ) {
            return (int) mid;
        } else if (mid * mid <= x) {
            return recur(x, mid, last);
        } else {
            return recur(x, head, mid);
        }
    }

    public static void main(String[] args) {
        System.out.println("new Sqrt().mySqrt(3) = " + new Sqrt().mySqrt(3));
    }
}
