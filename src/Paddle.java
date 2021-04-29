import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * 206322406.
 * Paddle class specifies the player in the game.
 * It is a rectangle that is controlled by the arrow keys,
 * and moves according to the player key presses.
 * It implements the Sprite and the Collidable interfaces.
 */
public class Paddle implements Sprite, Collidable {
    private static final double LEFTBOUND = 25;
    private static final double RIGHTBOUND = 775;
    //fields
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private java.awt.Color color;
    private int speed;

    /**
     * The constructor create a paddle by rectangle,keyboardSensor and his color.
     *
     * @param rectangle rectangle given.
     * @param keyboard  keyboardSensor given.
     * @param color     paddle's color.
     * @param speed     paddle's speed.
     */
    public Paddle(Rectangle rectangle, biuoop.KeyboardSensor keyboard, Color color, int speed) {
        this.keyboard = keyboard;
        this.rectangle = rectangle;
        this.color = color;
        this.speed = speed;
    }

    /**
     * The function move the paddle one move left.
     */
    public void moveLeft() {
        // change the paddle's location.
        double x = rectangle.getUpperLeft().getX() - this.speed;
        //check is not go out of left bound
        if (x < LEFTBOUND) {
            x = LEFTBOUND;
        }
        Point updateUpperLeft = new Point(x, rectangle.getUpperLeft().getY());
        //update the new location
        this.rectangle = new Rectangle(updateUpperLeft, this.rectangle.getWidth(), this.rectangle.getHeight());
    }

    /**
     * The function move the paddle one move right.
     */
    public void moveRight() {
        // change the paddle's location.
        double x = rectangle.getUpperLeft().getX() + this.speed;
        double width = rectangle.getWidth();
        //check is not go out of right bound
        if (x + width > RIGHTBOUND) {
            x = RIGHTBOUND - width;
        }
        Point updateUpperLeft = new Point(x, rectangle.getUpperLeft().getY());
        // update the new location
        this.rectangle = new Rectangle(updateUpperLeft, width, this.rectangle.getHeight());
    }

    /**
     * The function move the paddle according to the keyboard pressed.
     */
    @Override
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * The function draw the paddle on the surface according to his features.
     *
     * @param d surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        int x = (int) this.rectangle.getUpperLeft().getX();
        int y = (int) this.rectangle.getUpperLeft().getY();
        int height = (int) this.rectangle.getHeight();
        int width = (int) this.rectangle.getWidth();
        d.setColor(this.color);
        d.fillRectangle(x, y, width, height);
        d.setColor((Color.BLACK));
        d.drawRectangle(x, y, width, height);
    }

    /**
     * The function return the paddle's rectangle.
     *
     * @return paddle's rectangle.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * The function change the velocity after the hit.
     * if the collisionPoint is on paddle's up side,
     * change the velocity each part different.
     *
     * @param hitter          the ball that's doing the hitting.
     * @param collisionPoint  intersection point with the paddle.
     * @param currentVelocity current velocity.
     * @return update velocity after the hit.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Line[] scope = this.rectangle.linesOfScope();
        // go over the lines of the paddle's sides
        for (int i = 0; i < 2; i++) {
            double x1 = scope[i].start().getX(), x2 = scope[i].end().getX();
            double y1 = scope[i].start().getY(), y2 = scope[i].end().getY();
            // check is the collisionPoint on the line
            if ((Line.inRange(collisionPoint.getX(), x1, x2)) && (Line.inRange(collisionPoint.getY(), y1, y2))) {
                // check if the line is paddle's down side
                if (i == 1) {
                    return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
                }
                // the line is paddle's up side
                double speeds = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
                // change the velocity according to collision part on the up side
                if ((x1 + (0.2 * x1)) >= collisionPoint.getX()) {
                    return Velocity.fromAngleAndSpeed(300, speeds);
                }
                if ((x1 + (0.4 * x1)) >= collisionPoint.getX()) {
                    return Velocity.fromAngleAndSpeed(330, speeds);
                }
                if ((x1 + (0.6 * x1)) >= collisionPoint.getX()) {
                    return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
                }
                if ((x1 + (0.8 * x1)) >= collisionPoint.getX()) {
                    return Velocity.fromAngleAndSpeed(30, speeds);
                }
                return Velocity.fromAngleAndSpeed(60, speeds);
            }
        }
        // the collisionPoint on the paddle's left/right side
        return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
    }

    /**
     * The function in charge of adding the paddle to the game.
     *
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}