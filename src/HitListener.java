/**
 * 206322406.
 * HitListener interface indicate that objects that want to be notified of hit events
 */
public interface HitListener {
    /**
     * The function is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit object is hit.
     * @param hitter   Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}