/**
 * 206322406.
 * BlockRemover class is in charge of removing blocks from the game, as well as
 * keeping count of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * The constructor get a game and Counter of remaining Blocks and set the BlockRemover.
     *
     * @param game          the game.
     * @param removedBlocks counter of blocks which remain in the game.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * The function is called whenever the beingHit object is hit.
     * Make the beingHit be removed from the game.
     * update the count of the remains blocks in the game.
     *
     * @param beingHit object is hit.
     * @param hitter   Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
        this.remainingBlocks.decrease(1);
    }
}