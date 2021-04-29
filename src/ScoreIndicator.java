import biuoop.DrawSurface;

import java.awt.Color;

/**
 * ScoreIndicator class is in charge of displaying the current score
 * and the name of the current level.
 */
public class ScoreIndicator implements Sprite {
    private static final int WIDTH = 800;
    private static final int WIDTHBOUND = 20;
    private static final int X_WRITE = 370;
    private static final int Y_WRITE = 15;
    private static final int FONT = 18;
    private Counter score;
    private String name;

    /**
     * The constructor gets scoreCurrent and set ScoreIndicator.
     *
     * @param scoreCurrent score of the game.
     * @param name         the name of the cuurent level.
     */
    public ScoreIndicator(Counter scoreCurrent, String name) {
        this.score = scoreCurrent;
        this.name = name;
    }

    /**
     * The function draw the sprite to the screen.
     *
     * @param d surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, WIDTH, WIDTHBOUND);
        d.setColor(Color.black);
        d.drawText(X_WRITE, Y_WRITE, "score:" + this.score.getValue(), FONT);
        d.drawText(X_WRITE + 150, Y_WRITE, "Level Name: " + this.name, FONT);
    }

    /**
     * The function notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
    }
}
