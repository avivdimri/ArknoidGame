import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * 206322406.
 * AnimationRunner class takes an Animation object and runs it.
 */
public class AnimationRunner {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private static final int MILLISECONDSPERFRAME = 1000 / 60;

    private GUI gui;
    private int framesPerSecond;

    /**
     * The constructor open a window and set frames per second.
     */
    public AnimationRunner() {
        gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        framesPerSecond = MILLISECONDSPERFRAME;
    }

    /**
     * The function gets animation and run it in loop.
     *
     * @param animation animation.
     */
    public void run(Animation animation) {
        
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        int millisecondsPerFrame = framesPerSecond;

        while (!animation.shouldStop()) {

            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);

            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * The function return the gui(window) of the class.
     *
     * @return gui(window) of the class.
     */
    public GUI getGui() {
        return gui;
    }
}