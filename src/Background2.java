import biuoop.DrawSurface;

import java.awt.Color;

/**
 * 206322406.
 * Background2 class is a sprite which responsible on the
 * background of level 2 of the game.
 */
public class Background2 implements Sprite {
    private static final int X_SUN = 140;
    private static final int Y_SUN = 150;
    private static final int RADIUS_SUN = 40;

    /**
     * The function draw the sprite to the screen.
     *
     * @param d surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, AnimationRunner.WIDTH, AnimationRunner.HEIGHT);
        d.setColor(new Color(0xF1EDB3));
        for (int i = 0; i < 100; i++) {
            d.drawLine(X_SUN, Y_SUN, 20 + (i * 7), Y_SUN + 120);
        }
        d.setColor(new Color(0xF1EDB3));
        d.fillCircle(X_SUN, Y_SUN, RADIUS_SUN + 20);
        d.setColor(new Color(0xE4D577));
        d.fillCircle(X_SUN, Y_SUN, RADIUS_SUN + 10);
        d.setColor(new Color(0xFFD81D));
        d.fillCircle(X_SUN, Y_SUN, RADIUS_SUN);
    }

    /**
     * The function notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
