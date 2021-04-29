

/**
 * id 206322406.
 * Velocity class specifies the change in position on the `x` and the `y` axes.
 * The class supports relevant methods.
 */
public class Velocity {
    // fields
    private double dx = 0; // default
    private double dy = 0; // default
    // constructor

    /**
     * Thr constructor gets derivatives in axes x,y and set velocity.
     *
     * @param dx derivatives in axes x.
     * @param dy derivatives in axes y.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * The function return the derivatives in axes x (dx).
     *
     * @return derivatives in axes x(dx).
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * The function return the derivatives in axes y (dy).
     *
     * @return derivatives in axes y (dy).
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * The function return a new point with position (x+dx, y+dy) according to the velocity.
     *
     * @param p the first position of point.
     * @return point with new position (x+dx, y+dy).
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * The function gets angle and speed.
     * convert them to derivatives in axes x,y,and return new velocity.
     *
     * @param angle direction of derivative.
     * @param speed speed of derivative.
     * @return new velocity according to the angle and speed.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = (-speed * Math.cos(Math.toRadians(angle)));
        return new Velocity(dx, dy);
    }
}
