package topkelements;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distFromOrigin() {
        // ignoring sqrt
        return (x * x) + (y * y);
    }

    @Override
    public boolean equals(Object obj) {
        Point otherPoint = (Point) obj;
        return this.x == otherPoint.x && this.y == otherPoint.y;
    }
}
