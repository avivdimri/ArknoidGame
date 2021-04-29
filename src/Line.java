
import java.util.List;

/**
 * id 206322406.
 * Line class specifies a line with 2 Points,and supports relevant methods.
 */
public class Line {
    private static final double EPSILON = Math.pow(10, -14);
    //fields
    private Point start;
    private Point end;
    // constructors

    /**
     * The Constructor gets 2 Points and creates segment Line between them.
     *
     * @param start start point of the line.
     * @param end   end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The constructor gets 4 coordinates and sets 2 points
     * (start,end) and the segment Line between them.
     *
     * @param x1 x value of start point.
     * @param y1 y value of start point.
     * @param x2 x value of end point.
     * @param y2 y value of end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * The function returns line's length.
     *
     * @return length of the line.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * The function returns the line's middle point.
     *
     * @return middle point of the line.
     */
    public Point middle() {
        double x = (this.start.getX() + this.end.getX()) / 2;
        double y = (this.start.getY() + this.end.getY()) / 2;
        return new Point(x, y);
    }

    /**
     * The function returns the line's start point.
     *
     * @return start point.
     */
    public Point start() {
        return this.start;
    }

    /**
     * The function returns the line's end point.
     *
     * @return end point.
     */
    public Point end() {
        return this.end;
    }

    /**
     * The function Calculates intersection between 2 segment lines, if exists.
     *
     * @param other other segment line.
     * @return intersection's point, if exist, else null.
     */
    public Point intersectionWith(Line other) {
        double y;  // y value of the intersection.
        double x1 = this.start.getX(), x2 = this.end.getX();
        double x3 = other.start().getX(), x4 = other.end().getX();
        // checks the case when object's line is vertical.
        if ((x1 == x2) && (x3 != x4)) {
            // the straight lines are intersect in point (x1,y).
            y = getPointYValue(other, x1);
            // check if x1 is on given line segment, and y is on object's line segment.
            if ((inRange(y, this.start().getY(), this.end().getY()))
                    && (inRange(x1, other.start().getX(), other.end().getX()))) {
                return new Point(x1, y);
            }
            // the lines segments don't intersect.
            return null;
        }
        // check the case when given line is vertical.
        if ((x3 == x4) && (x1 != x2)) {
            // the straight lines are intersect in point (x3,y).
            y = getPointYValue(this, x3);
            // check if x3 is on object's line segment, and y are on given line segment.
            if ((inRange(y, other.start.getY(), other.end.getY()))
                    && (inRange(x3, this.start().getX(), this.end().getX()))) {
                return new Point(x3, y);
            }
            // the lines segments don't intersect.
            return null;
        }
        // check the case when both lines are vertical.
        if ((x3 == x4) && (x1 == x2)) {
            // check if both lines have a same equation.
            if (x1 == x3) {
                // check is the given line continue exactly where object's line end
                if (isContinue(this, other)) {
                    return new Point(x1, Math.max(this.start.getY(), this.end.getY()));
                }
                // check is object's line continue exactly where the given line end.
                if (isContinue(other, this)) {
                    return new Point(x1, Math.min(this.start.getY(), this.end.getY()));
                }
            }
            // the lines segments don't intersect.
            return null;
        }
        // the lines are not vertical, therefore they have slopes.
        double slope1 = getSlope(this.start, this.end);
        double slope2 = getSlope(other.start(), other.end());
        // b  value of the equation y = mx +b
        double b1 = getB(this.start, slope1);
        double b2 = getB(other.start(), slope2);
        // check the case when the lines are parallel
        if (slope1 == slope2) {
            // check if both lines have a same equation
            if (b1 == b2) {
                // check is the given line continue exactly where object's line end.
                if ((Math.max(x1, x2) == Math.min(x3, x4))) {
                    y = getPointYValue(this, Math.max(x1, x2));
                    return new Point(Math.max(x1, x2), y);
                }
                // check is object's line continue exactly where the given line end.
                if (Math.min(x1, x2) == Math.max(x3, x4)) {
                    y = getPointYValue(this, Math.min(x1, x2));
                    return new Point(Math.min(x1, x2), y);
                }
            }
            // the lines segments don't intersect
            return null;
        }
        // the lines are not vertical or parallel, therefore the lines intersect
        double x = (b1 - b2) / (slope2 - slope1); // x value of the intersection
        y = getPointYValue(this, x);
        // check if the x value are on the line segments
        if (inRange(x, x1, x2) && inRange(x, x3, x4)) {
            return new Point(x, y);
        }
        //the lines segments don't intersect
        return null;
    }

    /**
     * The function return slope between 2 points.
     *
     * @param a point.
     * @param b point.
     * @return slope between the Points.
     */
    static double getSlope(Point a, Point b) {
        return (a.getY() - b.getY()) / (a.getX() - b.getX());
    }

    /**
     * The function gets slope of line and point on the line.
     * and return the b value of the equation ( y = mx +b).
     *
     * @param a     point
     * @param slope slope of line.
     * @return the b value of the equation.
     */
    static double getB(Point a, double slope) {
        // y - mx = b
        return a.getY() - (slope * a.getX());
    }

    /**
     * The function return y coordinate of the line's point.
     *
     * @param other line.
     * @param x     point's x coordinate.
     * @return point's y coordinate.
     */
    static double getPointYValue(Line other, double x) {
        double slope = getSlope(other.start(), other.end());
        double b = getB(other.start(), slope);
        return (slope * x) + b; // equation y = mx +b
    }

    /**
     * The function gets 3 numbers and return true if the first
     * number (a) in range of the other numbers(a-b),otherwise false.
     *
     * @param x first number.
     * @param a range's start.
     * @param b range's end.
     * @return true if x in range of a-b, else false.
     */
    static boolean inRange(double x, double a, double b) {
        return ((x <= Math.max(a, b) + EPSILON) && (x >= Math.min(a, b) - EPSILON));
    }

    /**
     * The function gets 2 vertical lines and check if the first line is over where the second line is starting.
     *
     * @param a first line.
     * @param b second line.
     * @return true if line b continue line a, else false.
     */
    public static boolean isContinue(Line a, Line b) {
        return (Math.max(a.start().getY(), a.end().getY()) == Math.min(b.start().getY(), b.end().getY()));
    }

    /**
     * The function check if there is intersection between 2 segment lines.
     *
     * @param other given segment line.
     * @return true if object's line intersect with given line, else false.
     */
    public boolean isIntersecting(Line other) {
        return this.intersectionWith(other) != null;
    }

    /**
     * The function compare 2 lines.
     *
     * @param other given line.
     * @return true if equals, otherwise false.
     */
    public boolean equals(Line other) {
        return ((this.start.equals(other.start())) && (this.end.equals(other.end())));
    }

    /**
     * The function check if this line intersect with given rectangle,
     * and return the closest intersection point to the start of the line.
     *
     * @param rect given rectangle.
     * @return if exist, the closest intersection point,otherwise null.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> points = rect.intersectionPoints(this);
        if (points.isEmpty()) {
            // there is no intersection
            return null;
        }
        // there is intersection, so at least exist one point
        Point pClosest = points.get(0);
        double minDistance = this.start.distance(pClosest);
        // go over all the intersection points
        for (int i = 1; i < points.size(); i++) {
            if (this.start.distance(points.get(i)) < minDistance) {
                // update the closest point,minimal distance
                minDistance = this.start.distance(points.get(i));
                pClosest = points.get(i);
            }
        }
        return pClosest;
    }
}
