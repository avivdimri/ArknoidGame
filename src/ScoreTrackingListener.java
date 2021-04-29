/**
 * 206322406.
 * ScoreTrackingListener class update the score counter when blocks are being hit and removed.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * The constructor get scoreCounter and set the ScoreTrackingListener.
     *
     * @param scoreCounter scoreCounter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * The function is called whenever the beingHit object is hit.
     * the function increase the current score by 5 points .
     *
     * @param beingHit object is hit.
     * @param hitter   Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}