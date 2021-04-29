import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * 206322406.
 * KeyPressStoppableAnimation decorator-class that will wrap
 * an existing animation and add a "waiting-for-key" behavior to it.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;
    private boolean stop;

    /**
     * The constructor gets parameters and sets the fields of the class.
     *
     * @param sensor    KeyboardSensor.
     * @param key       the key which pressed.
     * @param animation animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        isAlreadyPressed = true;
        stop = false;
    }

    /**
     * The function make a animation on for one frame.
     *
     * @param d surface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (sensor.isPressed(key)) {
            if (!isAlreadyPressed) {
                stop = true;
            }
        } else {
            isAlreadyPressed = false;
        }
    }

    /**
     * The function return if the animation should stop the frame.
     *
     * @return true if should stop the frame otherwise false.
     */
    @Override
    public boolean shouldStop() {
        return stop;
    }
}