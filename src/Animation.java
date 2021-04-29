import biuoop.DrawSurface;

/**
 * 206322406.
 * Animation interface specifies methods for objects which make move on frame.
 */
public interface Animation {
    /**
     * The function make a animation on for one frame.
     *
     * @param d surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * The function return if the animation should stop the frame.
     *
     * @return true if should stop the frame otherwise false.
     */
    boolean shouldStop();
}
