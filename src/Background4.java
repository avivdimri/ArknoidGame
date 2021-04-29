import biuoop.DrawSurface;

import java.awt.Color;

/**
 * 206322406.
 * Background4 class is a sprite which responsible on the
 * background of level 4 of the game.
 */
public class Background4 implements Sprite {
    private static final int X_LEFTCIRCLE = 80;
    private static final int Y_LEFTCIRCLE = 398;
    private static final int RADIUS = 22;
    private static final int X_RIGHTCIRCLE = 600;
    private static final int Y_RIGHTCIRCLE = 500;

    /**
     * The function draw the sprite to the screen.
     *
     * @param d surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(0x1A7CBA));
        d.fillRectangle(0, 0, AnimationRunner.WIDTH, AnimationRunner.HEIGHT);
        d.setColor(Color.white);
        for (int i = 0; i < 10; i++) {
            d.drawLine(80 + (i * 10), 400, 60 + (i * 10), AnimationRunner.HEIGHT);
        }
        d.setColor(new Color(0xC6C7C6));
        d.fillCircle(X_LEFTCIRCLE, Y_LEFTCIRCLE, RADIUS);
        d.fillCircle(X_LEFTCIRCLE + 20, Y_LEFTCIRCLE + 17, RADIUS + 2);
        d.setColor(new Color(0xAEAFAE));
        d.fillCircle(X_LEFTCIRCLE + 40, Y_LEFTCIRCLE - 8, RADIUS + 6);
        d.setColor(new Color(0xA2A3A2));
        d.fillCircle(X_LEFTCIRCLE + 50, Y_LEFTCIRCLE + 19, RADIUS - 2);
        d.fillCircle(X_LEFTCIRCLE + 72, Y_LEFTCIRCLE + 2, RADIUS + 8);
        d.setColor(Color.white);
        for (int i = 0; i < 10; i++) {
            d.drawLine(600 + (i * 10), 530, 580 + (i * 10), 600);
        }
        d.setColor(new Color(0xC6C7C6));
        d.fillCircle(X_RIGHTCIRCLE, Y_RIGHTCIRCLE, RADIUS);
        d.fillCircle(X_RIGHTCIRCLE + 15, Y_RIGHTCIRCLE + 40, RADIUS + 3);
        d.setColor(new Color(0xAEAFAE));
        d.fillCircle(X_RIGHTCIRCLE + 40, Y_RIGHTCIRCLE + 10, RADIUS + 6);
        d.setColor(new Color(0xA2A3A2));
        d.fillCircle(X_RIGHTCIRCLE + 55, Y_RIGHTCIRCLE + 35, RADIUS - 2);
        d.fillCircle(X_RIGHTCIRCLE + 80, Y_RIGHTCIRCLE + 25, RADIUS + 8);
    }

    /**
     * The function notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
