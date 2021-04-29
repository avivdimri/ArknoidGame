import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * 206322406
 * WideEasy class is a levelInformation and specifies the second level in the game.
 */
public class WideEasy implements LevelInformation {
    private static final int PADDLEWIDTH = 550;
    private static final int PADDLESPEED = 3;
    private static final int BLOCKWIDTH = 50;
    private static final int BLOCKHEIGHT = 20;
    private static final int NUMBLOCKS = 40;
    private static final int NUMBALLS = 10;

    /**
     * The function return the number of balls in this level.
     *
     * @return number of balls.
     */
    @Override
    public int numberOfBalls() {
        return NUMBALLS;
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
        for (int i = 0; i < 10; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(315 + (i * 10), 5));
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
        return "Wide Easy";
    }

    /**
     * The function return a sprite with the background of the level.
     *
     * @return background of the level.
     */
    @Override
    public Sprite getBackground() {
        return new Background2();
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
        Color[] colors = new Color[15];
        colors[0] = Color.red;
        colors[1] = Color.red;
        colors[2] = Color.orange;
        colors[3] = Color.orange;
        colors[4] = Color.yellow;
        colors[5] = Color.yellow;
        colors[6] = Color.green;
        colors[7] = Color.green;
        colors[8] = Color.green;
        colors[9] = Color.blue;
        colors[10] = Color.blue;
        colors[11] = Color.pink;
        colors[12] = Color.pink;
        colors[13] = Color.CYAN;
        colors[14] = Color.CYAN;
        for (int i = 0; i < 15; i++) {
            Rectangle rec = new Rectangle(new Point(25 + (BLOCKWIDTH * (i)), 270), BLOCKWIDTH, BLOCKHEIGHT);
            blocks.add(new Block(rec, colors[i]));
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
        return 15;
    }
}
