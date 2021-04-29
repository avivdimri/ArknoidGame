import biuoop.DrawSurface;

import java.awt.Color;

/**
 * 206322406.
 * CountdownAnimation class responsible on the display  of the counting
 * on top of the game screen itself, so that the player will
 * know what to expect when the game start.
 */
public class CountdownAnimation implements Animation {
    private SpriteCollection gameScreen;
    private boolean stop;
    private double frame;
    private int counter;

    /**
     * The constructor set all the fields of the class.
     *
     * @param numOfSeconds the number of seconds of the counting.
     * @param countFrom    the number which count from.
     * @param gameScreen   all the sprites of the game level
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.gameScreen = gameScreen;
        stop = false;
        frame = (1000 * (numOfSeconds / countFrom));
        counter = countFrom;
    }

    /**
     * The function make a animation on for one frame.
     *
     * @param d surface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        if (counter == 0) {
            //the counting is over
            stop = true;
        }
        gameScreen.drawAllOn(d);
        d.setColor(Color.red);
        d.drawText(d.getWidth() / 2, d.getHeight() / 2, "" + counter, 60);
        long l = (long) frame;
        if (counter != 3) {
            sleeper.sleepFor(l);
        }
        counter--;

    }

    /**
     * The function return if the animation should stop the frame.
     *
     * @return true if should stop the frame otherwise false.
     */
    public boolean shouldStop() {
        return stop;
    }
}