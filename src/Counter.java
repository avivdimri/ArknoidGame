/**
 * 206322406.
 * Counter class is used for counting things.
 */
public class Counter {
    private int counter;

    /**
     * The constructor gets number and set the Counter.
     *
     * @param c number.
     */
    Counter(int c) {
        this.counter = c;
    }

    /**
     * The function add number to current count.
     *
     * @param number number given.
     */
    void increase(int number) {
        this.counter += number;
    }

    /**
     * The function subtract number from the current count.
     *
     * @param number number given.
     */
    void decrease(int number) {
        this.counter -= number;
    }

    /**
     * The function return the current count.
     *
     * @return current count.
     */
    int getValue() {
        return this.counter;
    }
}