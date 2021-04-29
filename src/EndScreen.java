import biuoop.DrawSurface;

/**
 * 206322406.
 * EndScreen class responsible on the screen once the game is over either the player died,
 * or he managed to clear all the levels, it will display the final score.
 */
public class EndScreen implements Animation {
    // private KeyboardSensor keyboard;
    private boolean stop;
    private boolean isWin;
    private Counter score;

    /**
     * The constructor sets the fields of the class.
     *
     * @param sc    score of the player.
     * @param isWin true if the player win else false.
     */
    public EndScreen(Counter sc, boolean isWin) {
        this.isWin = isWin;
        stop = false;
        score = sc;
    }

    /**
     * The function make a animation on for one frame.
     *
     * @param d surface.
     */
    public void doOneFrame(DrawSurface d) {
        if (isWin) {
            d.drawText(40, d.getHeight() / 2, "You Win! Your score is " + this.score.getValue(), 40);
        } else {
            d.drawText(40, d.getHeight() / 2, "Game Over. Your score is " + this.score.getValue(), 40);
        }
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