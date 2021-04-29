import biuoop.DrawSurface;

import java.awt.Color;

/**
 * 206322406.
 * Background1 class is a sprite which responsible on the
 * background of level 1 of the game.
 */
public class Background1 implements Sprite {
    private static final int X_CIRCLE = 395;
    private static final int Y_CIRCLE = 165;
    private static final int RADDIUS = 60;

    /**
     * The function draw the sprite to the screen.
     *
     * @param d surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 0, AnimationRunner.WIDTH, AnimationRunner.HEIGHT);
        d.setColor(Color.blue);

        d.drawCircle(X_CIRCLE, Y_CIRCLE, 2 * RADDIUS);
        d.drawCircle(X_CIRCLE, Y_CIRCLE, (RADDIUS + RADDIUS / 2));
        d.drawCircle(X_CIRCLE, Y_CIRCLE, RADDIUS);
        d.drawLine(X_CIRCLE, Y_CIRCLE - 20, X_CIRCLE, Y_CIRCLE - 140);
        d.drawLine(X_CIRCLE, Y_CIRCLE + 20, X_CIRCLE, Y_CIRCLE + 140);
        d.drawLine(X_CIRCLE - 20, Y_CIRCLE, X_CIRCLE - 140, Y_CIRCLE);
        d.drawLine(X_CIRCLE + 20, Y_CIRCLE, X_CIRCLE + 140, Y_CIRCLE);
    }

    /**
     * The function notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
