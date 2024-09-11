/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: FIXME
 * Last Updated: FIXME
 */
package mirzaa;

import java.util.Random;

public class Die {
    private final int numSides;
    private int currentValue = 0;
    final int MAX_VALUE = 100;
    final int MIN_VALUE = 2;
    private final Random random = new Random();
    public Die(int sides) {
        if (sides > MAX_VALUE || sides < MIN_VALUE)
        {
            throw new IllegalArgumentException("The number of sides is outside of the range (2-100)");
        }
        this.numSides = sides;
    }
    public void roll() {
        this.currentValue = random.nextInt(100,MIN_VALUE) + MIN_VALUE;
    }
    public int getCurrentValue() {
        if (this.currentValue > numSides || this.currentValue < MIN_VALUE) {
            throw new DieNotRolledException("The die was either not rolled or was outside of the range.");
        }
        int temp = this.currentValue;
        this.currentValue = 0;
        return temp;
    }
}