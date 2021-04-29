import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

import java.util.List;

/**
 * 206322406.
 * Game class hold the sprites and the collidables,
 * and in charge of the animation of the game.
 */
public class GameLevel implements Animation {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int WIDTHBOUND = 20;
    private static final int RADIUS = 6;
    private static final int HEIGHTPADDLE = 15;
    private static final Point STRATBALL1 = new Point(395, 550);


    //fields
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter counterBalls;
    private Counter counterBlocks;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;


    /**
     * The constructor gets parameters and sets the fields of the class.
     *
     * @param levelInfo       the level in the game.
     * @param keyboard        keyboard sensor.
     * @param animationRunner animationRunner.
     * @param score           the score of the player.
     */
    public GameLevel(LevelInformation levelInfo, KeyboardSensor keyboard,
                     AnimationRunner animationRunner, Counter score) {
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        counterBlocks = new Counter(0);
        counterBalls = new Counter(0);
        this.score = score;
        runner = animationRunner;
        this.keyboard = keyboard;
        levelInformation = levelInfo;

    }

    /**
     * The function return the counter of the balls in the level.
     *
     * @return counter of the balls.
     */
    public Counter getCounterBalls() {
        return this.counterBalls;
    }

    /**
     * The function return the counter of the blocks in the level.
     *
     * @return counter of the blocks.
     */
    public Counter getCounterBlocks() {
        return this.counterBlocks;
    }

    /**
     * The function return the score of the game.
     *
     * @return the score of the game.
     */
    public Counter getScore() {
        return this.score;
    }

    /**
     * The function gets Collidable add it to GameEnvironment's List.
     *
     * @param c collidable given.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * The function gets Sprite add it to Sprites' List.
     *
     * @param s sprite given.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * The function gets Collidable remove it from GameEnvironment's List.
     *
     * @param c collidable given.
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * The function gets Sprite remove it from Sprites' List.
     *
     * @param s sprite given.
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }
    /**
     * The function creates all the 4 bounds of the game.
     *
     */
    public void createBound(){
        // create the bound blocks and add them to the game
        Point p = new Point(0, 20);
        Block up = new Block(new Rectangle(p, WIDTH, WIDTHBOUND), Color.gray);
        up.addToGame(this);

        p = new Point(0, WIDTHBOUND + 20);
        Block left = new Block(new Rectangle(p, WIDTHBOUND + 5, HEIGHT - WIDTHBOUND - 20), Color.gray);
        left.addToGame(this);

        p = new Point(WIDTH - WIDTHBOUND - 5, WIDTHBOUND + 20);
        Block right = new Block(new Rectangle(p, WIDTHBOUND + 5, HEIGHT - WIDTHBOUND - 20), Color.gray);
        right.addToGame(this);

        p = new Point(WIDTHBOUND, HEIGHT);
        Block deathRegion = new Block(new Rectangle(p, WIDTH - (2 * WIDTHBOUND), WIDTHBOUND), Color.blue);
        environment.addCollidable(deathRegion);

        BallRemover ballRemover = new BallRemover(this, counterBalls);
        deathRegion.addHitListener(ballRemover);
    }

    /**
     * The function creates all the balls of the game by the level
     *
     */
    public void createBaslls(){

        List<Velocity> velocities = levelInformation.initialBallVelocities();
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {

            Ball ball = new Ball(STRATBALL1, RADIUS, Color.white, environment);
            ball.setVelocity(velocities.get(i));
            ball.addToGame(this);
            counterBalls.increase(1);

        }
    }
    /**
     * The function creates the player of the game by the level
     *
     */
    public void createPaddle(){
         // create player
        Point startPaddle = new Point(WIDTH / 2.0 - (levelInformation.paddleWidth() / 2.0), 565);
        Rectangle rec = new Rectangle(startPaddle, levelInformation.paddleWidth(), HEIGHTPADDLE);
        Paddle paddle = new Paddle(rec, runner.getGui().getKeyboardSensor(), Color.orange, levelInformation.paddleSpeed());
        paddle.addToGame(this);
    }
    /**
     * The function creates all the blocks of the game by the level
     *
     */
    public void createBlocks(){

        BlockRemover blockRemover = new BlockRemover(this, counterBlocks);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(score);

        // create the center blocks and add them to the game
        List<Block> blocks = levelInformation.blocks();
        for (Block block : blocks) {
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
            counterBlocks.increase(1);
        }
    }
    /**
     * The function initialize a new game.
     * create the Blocks, Balls, Paddle and add them to the game.
     */
    public void initialize() {

        sprites.addSprite(levelInformation.getBackground());

        createBound();

        createBaslls();

        createPaddle();

        ScoreIndicator scoreIndicator = new ScoreIndicator(score, levelInformation.levelName());
        sprites.addSprite(scoreIndicator);

        createBlocks();
    }

    /**
     * The function is the animation loop, that go over all the sprites,
     * and call drawOn and timePassed on each of them.
     */
    public void run() {
        runner.run(new CountdownAnimation(2, 3, sprites));
        running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        runner.run(this);

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        sprites.drawAllOn(d);
        // make one move.
        sprites.notifyAllTimePassed();
        if (counterBalls.getValue() == 0) {
            running = false;
        }
        if (counterBlocks.getValue() == -1) {
            running = false;
            score.increase(100);
        }
        if (counterBlocks.getValue() == 0) {
            counterBlocks.decrease(1);
        }

        if (keyboard.isPressed("p")) {
            runner.run(new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }
    }

    @Override
    public boolean shouldStop() {
        return !running;
    }
}