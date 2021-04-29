import biuoop.KeyboardSensor;

import java.util.List;

/**
 * 206322406.
 * GameFlow class in charge of creating the different levels,
 * and moving from one level to the next.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;

    /**
     * The constructor sets the fields of the class.
     *
     * @param ar AnimationRunner.
     * @param ks KeyboardSensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        animationRunner = ar;
        keyboardSensor = ks;
    }

    /**
     * The function gets list of levels an run all the levels
     * one after one while the player not lose.
     *
     * @param levels list of levels.
     */
    public void runLevels(List<LevelInformation> levels) {

        Counter score = new Counter(0);
        boolean isWin = true;
        
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, keyboardSensor,animationRunner, score);
            level.initialize();

             while ((level.getCounterBalls().getValue() != 0) && (level.getCounterBlocks().getValue() != -1)) {
                 level.run();
             }
            // check if no more balls and the game is over
            if (level.getCounterBalls().getValue() == 0) {
                isWin = false;
                break;
            }

            score = level.getScore();
        }
        animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor,
                KeyboardSensor.SPACE_KEY, new EndScreen(score, isWin)));
        animationRunner.getGui().close();

    }
}