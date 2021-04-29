import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * 206322406
 * FinalFor class is a levelInformation and specifies the fourth level in the game.
 */
public class FinalFor implements LevelInformation {

    private static final int PADDLEWIDTH = 150;
    private static final int PADDLESPEED = 5;
    private static final int BLOCKWIDTH = 50;
    private static final int BLOCKHEIGHT = 22;
    private static final int NUMBLOCKS = 105;
    private static final int ANGLE = 300;

    /**
     * The function return the number of balls in this level.
     *
     * @return number of balls.
     */
    @Override
    public int numberOfBalls() {
        return 3;
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
        for (int i = 0; i < 3; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(ANGLE + (i * 60), 5));
        }

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
        return "Final Four";
    }

    /**
     * The function return a sprite with the background of the level.
     *
     * @return background of the level.
     */
    @Override
    public Sprite getBackground() {
        return new Background4();
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
        Color[] colors = new Color[7];
        colors[0] = Color.cyan;
        colors[1] = Color.pink;
        colors[2] = Color.white;
        colors[3] = Color.green;
        colors[4] = Color.yellow;
        colors[5] = Color.red;
        colors[6] = Color.gray;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < 15; j++) {
                Point p = new Point(725 - (j * BLOCKWIDTH), 240 - (i * BLOCKHEIGHT));
                blocks.add(new Block(new Rectangle(p, BLOCKWIDTH, BLOCKHEIGHT), colors[i]));
            }
        }
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
        return NUMBLOCKS;
    }
}
