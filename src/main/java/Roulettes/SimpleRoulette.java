package Roulettes;

/**
 * Simple because doesn't have 0 (European) or 00 (American)
 * Returns either black or red
 */

public class SimpleRoulette implements Roulette {


    /**
     * Returns either Black or Red integer values
     */
    public int spin() {
        return BetColor.getRandomColor();
    }
}
