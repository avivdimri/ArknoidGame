import biuoop.DrawSurface;

import java.awt.Color;


//import geometric.Point;

/**
 * id 206322406.
 * Ball class specifies ball with his feathers, and supports relevant methods.
 */
public class Ball implements Sprite {
    private static final double ALMOST = 0.5;
    // fields
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity vel;
    private GameEnvironment gameEnvironment;

    // constructor

    /**
     * The constructor gets ball's features and set ball.
     *
     * @param center          point - ball's center(location).
     * @param r               ball's radius.
     * @param color           ball's color.
     * @param gameEnvironment ball's game environment.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * The constructor gets 2 coordinates, radius, color and set ball.
     *
     * @param x     x value of ball's center.
     * @param y     y value of ball's center.
     * @param r     ball's radius.
     * @param color ball's color.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
    }

    /**
     * The function return x coordinate of ball's center(location).
     *
     * @return x value of ball's center.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * The function return y coordinate of ball's center(location).
     *
     * @return y value of ball's center.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * The function return the ball's radius.
     *
     * @return the ball's radius.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * The function return the ball's color.
     *
     * @return ball's color
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * The function draw circle(ball) by ball's features.
     *
     * @param surface access to draw.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.radius);
        surface.setColor(Color.black);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     * The function call moveOneStep.
     */
    public void timePassed() {
        moveOneStep();
    }

    /**
     * The function set ball's velocity.
     *
     * @param v ball's velocity.
     */
    public void setVelocity(Velocity v) {
        this.vel = v;
    }

    /**
     * The function set ball's velocity.
     *
     * @param dx derivatives in axes x.
     * @param dy derivatives in axes y.
     */
    public void setVelocity(double dx, double dy) {
        this.vel = new Velocity(dx, dy);
    }

    /**
     * The function return the ball's velocity.
     *
     * @return ball's velocity.
     */
    public Velocity getVelocity() {
        return this.vel;
    }

    /**
     * The function return ball's game environment.
     *
     * @return ball's game environment.
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * The function move the ball one step according to
     * his velocity and his environment.
     */
    public void moveOneStep() {
        Point end = this.getVelocity().applyToPoint(this.center);
        Line trajectory = new Line(this.center, end); // ball's trajectory
        CollisionInfo coInfo = this.gameEnvironment.getClosestCollision(trajectory);
        if (coInfo == null) {
            // there is not collision
            this.center = end;
            return;
        }
        //there is a collision
        double rx = ALMOST;
        double ry = ALMOST;
        // change the ALMOST according to his direction.
        if (this.vel.getDx() >= 0) {
            rx = (this.vel.getDx() > 0) ? -rx : 0;
        }
        if (this.vel.getDy() >= 0) {
            ry = (this.vel.getDy() > 0) ? -ry : 0;
        }
        // move the ball almost to collision point
        this.center = new Point(coInfo.collisionPoint().getX() + rx, coInfo.collisionPoint().getY() + ry);
        // call hit function and update velocity
        Velocity updateVel = coInfo.collisionObject().hit(this, coInfo.collisionPoint(), this.vel);
        setVelocity(updateVel);
    }

    /**
     * The function in charge of adding the ball to the game.
     *
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * The function in charge of remove the ball from the game.
     *
     * @param g the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}


