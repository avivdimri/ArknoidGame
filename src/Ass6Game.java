import biuoop.KeyboardSensor;

import java.util.ArrayList;
import java.util.List;

/**
 * 206322406.
 * Ass3Game has main method which create a new game of "Arkanoid".
 */
public class Ass6Game {

    /**
     * Main function which create and run a new game of "Arkanoid" withe some levels
     * by the arguments given.
     *
     * @param args .
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        for (String arg : args) {
            switch (arg) {
                case ("1"):
                    levels.add(new DirectHit());
                    //  continue;
                    break;
                case ("2"):
                    levels.add(new WideEasy());
                    //continue;
                    break;
                case ("3"):
                    levels.add(new Green3());
                    //  continue;
                    break;
                case ("4"):
                    levels.add(new FinalFor());
                    // continue;
                    break;
                default:
            }
        }
        // default game
        if (levels.size() == 0) {
            levels.add(new DirectHit());
            levels.add(new WideEasy());
            levels.add(new Green3());
            levels.add(new FinalFor());
        }
        AnimationRunner animationRunner = new AnimationRunner();
        KeyboardSensor keyboardSensor = animationRunner.getGui().getKeyboardSensor();
        GameFlow game = new GameFlow(animationRunner, keyboardSensor);
        game.runLevels(levels);
    }
}
