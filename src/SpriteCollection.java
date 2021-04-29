import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * 206322406.
 * SpriteCollection class holds a collection of sprites.
 * The class supports relevant methods.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * Thr constructor create new list of sprites.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }

    /**
     * The function adds sprite to the list.
     *
     * @param s sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * The function remove sprite to the list.
     *
     * @param s sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * The function call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spritesCopy = new ArrayList<>(this.sprites);
        for (Sprite s : spritesCopy) {
            s.timePassed();
        }
    }

    /**
     * The function call drawOn(d) on all sprites.
     *
     * @param d .
     */
    public void drawAllOn(DrawSurface d) {
        List<Sprite> spritesCopy = new ArrayList<>(this.sprites);
        for (Sprite s : spritesCopy) {
            s.drawOn(d);
        }
    }
}