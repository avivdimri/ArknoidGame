import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * 206322406
 * DirectHit class is a levelInformation and specifies the first level in the game.
 */
public class DirectHit implements LevelInformation {
    private static final int PADDLEWIDTH = 100;
    private static final int PADDLESPEED = 5;
    private static final int SIZEBLOCK = 30;

    /**
     * The function return the number of balls in this level.
     *
     * @return number of balls.
     */
    @Override

    public int numberOfBalls() {
        return 1;
    }

    /**
     * The function initial velocity of each ball and
     * return list of the balls' velocities.
     *
     * @return list of the balls' velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(new Velocity(0, -5));
        return velocities;
    }

    /**
     * The function return the speed of the paddle in this level.
     *
     * @return paddle's speed.
     */
    @Override
    public int paddleSpeed() {
        return PADDLESPEED;
    }

    /**
     * The function return the width of the paddle in this level.
     *
     * @return paddle's width.
     */
    @Override
    public int paddleWidth() {
        return PADDLEWIDTH;
    }

    /**
     * The function return the level name.
     *
     * @return level name.
     */
    @Override
    public String levelName() {
        return "Direct Hit";
    }


    /**
     * The function return a sprite with the background of the level.
     *
     * @return background of the level.
     */
    @Override
    public Sprite getBackground() {
        return new Background1();
    }

    /**
     * The function make up a list of blocks of this level ,each block contains
     * its size, color and location.
     *
     * @return list of blocks.
     */

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Rectangle rec = new Rectangle(new Point(380, 150), SIZEBLOCK, SIZEBLOCK);
        blocks.add(new Block(rec, Color.red));
        return blocks;
    }

    /**
     * The function return the number of blocks that should be removed
     * before the level is considered to be "cleared".
     *
     * @return number of blocks that should be removed.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
