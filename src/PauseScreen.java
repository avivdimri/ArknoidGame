import biuoop.DrawSurface;

/**
 * PauseScreen class display a screen with the message
 * paused -- press space to continue until a key is pressed.
 */
public class PauseScreen implements Animation {
    private boolean stop;

    /**
     * The constructor of the class.
     */
    public PauseScreen() {
        stop = false;
    }

    /**
     * The function make a animation on for one frame.
     *
     * @param d surface.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
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