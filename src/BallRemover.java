/**
 * 206322406.
 * BallRemover class is in charge of removing balls from the game, as well as
 * keeping count of the number of balls that remain.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * The constructor get a game and Counter of remaining balls and set the BallRemover.
     *
     * @param game           the game.
     * @param remainingBalls counter of balls which remain in the game.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    /**
     * The function is called whenever the beingHit object is hit.
     * Make the hitter be removed from the game.
     * update the count of the remains balls in the game.
     *
     * @param beingHit object is hit.
     * @param hitter   Ball that's doing the hitting.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
