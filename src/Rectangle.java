
import java.util.ArrayList;
import java.util.List;

/**
 * Rectangle class specifies shape of rectangle by point,width,height.
 * The class supports relevant methods.
 */
public class Rectangle {
    //fields
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * The constructor create a rectangle with location and width/height.
     *
     * @param upperLeft rectangle's vertex.
     * @param width     rectangle's width.
     * @param height    rectangle's height.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * The function create array with 4 lines of rectangle's scope.
     * 2 first line are up/down sides, 2 last line are left/right.
     *
     * @return array with 4 scope's lines.
     */
    public Line[] linesOfScope() {
        Line[] lines = new Line[4];
        Point uppLeft = this.upperLeft;
        Point uppRight = new Point(uppLeft.getX() + this.width, uppLeft.getY());
        Point downLeft = new Point(uppLeft.getX(), uppLeft.getY() + height);
        Point downRight = new Point(uppRight.getX(), downLeft.getY());
        lines[0] = new Line(uppLeft, uppRight);   //up side
        lines[1] = new Line(downLeft, downRight); //down side
        lines[2] = new Line(downLeft, uppLeft);   //left side
        lines[3] = new Line(downRight, uppRight); //right side
        return lines;
    }

    /**
     * The function return a (possibly empty) List of intersection points
     * of thr rectangle's sides with the specified line.
     *
     * @param line given line segment.
     * @return list of intersection points.
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> points = new ArrayList<>();
        Line[] scope = this.linesOfScope();
        // go over the scope's lines sides
        for (Line value : scope) {
            Point p = value.intersectionWith(line);
            // check if exist point
            if (p != null) {
                points.add(p);
            }
        }
        return points;
    }

    /**
     * The function return the rectangle's width.
     *
     * @return rectangle's width.
     */
    //Return the width and height of the rectangle
    public double getWidth() {
        return this.width;
    }

    /**
     * The function return the rectangle's height.
     *
     * @return rectangle's height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * The function returns the upper-left point of the rectangle.
     *
     * @return upper-left point of the rectangle..
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

}