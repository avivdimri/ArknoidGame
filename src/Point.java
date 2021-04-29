
/**
 * id 206322406.
 * Point class specifies a point by 2 coordinates x,y, and supports relevant methods.
 */
public class Point {
    // fields
    private double x;
    private double y;
    // constructor

    /**
     * The constructor gets 2 coordinates and sets a Point.
     *
     * @param x point's x coordinate.
     * @param y point's y coordinate.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The function calculates distance between 2 points.
     *
     * @param other given point.
     * @return distance between 2 points.
     */
    public double distance(Point other) {
        double x2 = other.getX(), y2 = other.getY();
        double sum = ((this.x - x2) * (this.x - x2)) + ((this.y - y2) * (this.y - y2));
        return Math.sqrt(sum);
    }

    /**
     * The function compares 2 points.
     *
     * @param other given point.
     * @return true if equals, otherwise false.
     */
    public boolean equals(Point other) {
        double x2 = other.getX(), y2 = other.getY();
        return (this.x == x2) && (this.y == y2);
    }

    /**
     * The function returns the point's x coordinate.
     *
     * @return point's x coordinate.
     */
    public double getX() {
        return this.x;
    }

    /**
     * The function returns the point's y coordinate.
     *
     * @return point's y coordinate.
     */
    public double getY() {
        return this.y;
    }
}
