/**
 * 206322406.
 * HitNotifier interface indicate that objects that implement it
 * send notifications when they are being hit.
 */
public interface HitNotifier {
    /**
     * the function add hl as a listener to hit events.
     *
     * @param hl listener.
     */
    void addHitListener(HitListener hl);

    /**
     * The function remove hl from the list of listeners to hit events.
     *
     * @param hl listener.
     */
    void removeHitListener(HitListener hl);
}
