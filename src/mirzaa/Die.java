/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Ayaan Mirza
 * Last Updated: Ayaan Mirza
 */
package mirzaa;

import java.util.Random;

/**
 * The Die class. This holds a Die that we can roll and get its current value.
 */
public class Die {
    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = 2;

    private final int numSides;
    private int currentValue = 0;
    private final Random random = new Random();

    /**
     * Constructor for the Die class
     * @param sides The number of sides.
     */
    public Die(int sides) {
        if (sides > MAX_VALUE || sides < MIN_VALUE) {
            throw new IllegalArgumentException("The number of sides" +
                    " is outside of the range (2-100)");
        }
        this.numSides = sides;
    }

    /**
     * This gives us a random integer from 1 to numSides
     */
    public void roll() {
        this.currentValue = random.nextInt(numSides) + 1;
    }

    /**
     * Returns the current value of the die.
     * @return the value after the die is rolled
     * @throws DieNotRolledException if the die was not rolled
     */
    public int getCurrentValue() {
        if (this.currentValue == 0) {
            System.out.println(this.currentValue);
            throw new DieNotRolledException("The die was either not rolled " +
                    "or was outside of the range.");
        }
        int temp = this.currentValue;
        this.currentValue = 0;
        return temp;
    }
}