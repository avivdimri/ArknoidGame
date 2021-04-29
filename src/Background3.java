import biuoop.DrawSurface;

import java.awt.Color;

/**
 * 206322406.
 * Background3 class is a sprite which responsible on the
 * background of level 3 of the game.
 */
public class Background3 implements Sprite {
    private static final int X_LIGHT = 119;
    private static final int Y_LIGHT = 208;
    private static final int RADIUS_LIGHT = 8;

    /**
     * The function draw the sprite to the screen.
     *
     * @param d surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(0x23670E));
        d.fillRectangle(0, 0, AnimationRunner.WIDTH, AnimationRunner.HEIGHT);
        d.setColor(Color.white);
        d.fillRectangle(70, 440, 90, 160);
        d.setColor(new Color(0x343233));
        d.fillRectangle(105, 390, 28, 50);
        d.setColor(new Color(0x434142));
        d.fillRectangle(114, 210, 10, 180);
        d.setColor(new Color(0xCE8D51));
        d.fillCircle(X_LIGHT, Y_LIGHT, RADIUS_LIGHT + 3);
        d.setColor(new Color(0xCE5F4B));
        d.fillCircle(X_LIGHT, Y_LIGHT, RADIUS_LIGHT);
        d.setColor(Color.white);
        d.fillCircle(X_LIGHT, Y_LIGHT, RADIUS_LIGHT - 5);
        d.setColor(new Color(0x292728));
        for (int i = 0; i < 5; i++) {
            d.fillRectangle(70, 440 + (i * 34), 90, 8);
        }
        for (int i = 0; i < 6; i++) {
            d.fillRectangle(70 + (i * 18), 440, 8, 160);
        }


    }

    /**
     * The function notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
