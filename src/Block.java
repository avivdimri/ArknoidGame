import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * 206322406.
 * Block class specifies obstacles on the screen.
 * The block is a rectangle with color.
 * It implements the Sprite and the Collidable interfaces.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private java.awt.Color color;
    private List<HitListener> hitListeners;

    /**
     * The constructor gets rectangle and color and set the block.
     *
     * @param rec   block's rectangle given.
     * @param color block's color given.
     */
    public Block(Rectangle rec, java.awt.Color color) {
        this.rectangle = rec;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * The function return the block's rectangle.
     *
     * @return block's rectangle.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * The function change the velocity after the hit.
     *
     * @param hitter          the Ball that's doing the hitting.
     * @param collisionPoint  intersection point with the block.
     * @param currentVelocity current velocity.
     * @return new velocity according the hitting location.
     */

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Line[] scope = this.rectangle.linesOfScope();
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        // go over the lines of the block's sides
        for (int i = 0; i < scope.length; i++) {
            double x1 = scope[i].start().getX(), x2 = scope[i].end().getX();
            double y1 = scope[i].start().getY(), y2 = scope[i].end().getY();
            // check if the collisionPoint on the side
            if ((Line.inRange(collisionPoint.getX(), x1, x2)) && (Line.inRange(collisionPoint.getY(), y1, y2))) {
                // check if line is up/down block's side
                if (i < 2) {
                    // opposite velocity's dy
                    dy = -dy;
                } else {
                    //the line is left/right block's side
                    // opposite velocity's dx
                    dx = -dx;
                }
            }
        }
        this.notifyHit(hitter);
        return new Velocity(dx, dy);
    }

    /**
     * The function draw the block on surface given, by his features.
     *
     * @param surface surface given.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        int x = (int) this.rectangle.getUpperLeft().getX();
        int y = (int) this.rectangle.getUpperLeft().getY();
        int height = (int) this.rectangle.getHeight();
        int width = (int) this.rectangle.getWidth();
        surface.setColor(this.color);
        surface.fillRectangle(x, y, width, height);
        surface.setColor(Color.BLACK);
        surface.drawRectangle(x, y, width, height);
    }

    /**
     * .
     */
    @Override
    public void timePassed() {
    }

    /**
     * The function in charge of adding the block to the game.
     *
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * The function be called whenever a hit() occurs,
     * and will notify all of the registered HitListener objects
     * by calling their hitEvent method.
     *
     * @param hitter Ball that's doing the hitting.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * the function add hl as a listener to hit events.
     *
     * @param hl listener.
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * The function remove hl from the list of listeners to hit events.
     *
     * @param hl listener.
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * The function in charge of remove the block from the game.
     *
     * @param game the game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }
}
