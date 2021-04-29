import java.util.List;

/**
 * 206322406.
 * The LevelInformation interface specifies the information required to fully describe a level.
 */
public interface LevelInformation {
    /**
     * The function return the number of balls in this level.
     *
     * @return number of balls.
     */
    int numberOfBalls();

    /**
     * The function initial velocity of each ball and
     * return list of the balls' velocities.
     *
     * @return list of the balls' velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * The function return the speed of the paddle in this level.
     *
     * @return paddle's speed.
     */
    int paddleSpeed();

    /**
     * The function return the width of the paddle in this level.
     *
     * @return paddle's width.
     */
    int paddleWidth();

    /**
     * The function return the level name.
     *
     * @return level name.
     */
    String levelName();

    /**
     * The function return a sprite with the background of the level.
     *
     * @return background of the level.
     */
    Sprite getBackground();

    /**
     * The function make up a list of blocks of this level ,each block contains
     * its size, color and location.
     *
     * @return list of blocks.
     */

    List<Block> blocks();

    /**
     * The function return the number of blocks that should be removed
     * before the level is considered to be "cleared".
     *
     * @return number of blocks that should be removed.
     */
    int numberOfBlocksToRemove();
}