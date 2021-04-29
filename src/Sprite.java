import biuoop.DrawSurface;

/**
 * 206322406.
 * Sprite interface specifies game object that can be drawn to the screen.
 * it also can be notified that time has passed .
 */
public interface Sprite {
    /**
     * The function draw the sprite to the screen.
     *
     * @param d surface.
     */
    void drawOn(DrawSurface d);

    /**
     * The function notify the sprite that time has passed.
     */
    void timePassed();
}