/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Ayaan Mirza
 * Last Updated: Ayaan Mirza
 */
package mirzaa;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The Driver class to use our programs and the Die class.
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("Please enter the number of dice to roll, " +
                "how many sides the dice have,");
        System.out.println("and how many rolls to complete, " +
                "separating the values by a space");
        int[] config = getInput();
        Die[] dices = createDice(config[0], config[1]);
        int[] freq = rollDice(dices, config[1], config[2]);
        System.out.println(Arrays.toString(freq));
        int max = findMax(freq);
        report(config[0], freq, max);

    }

    /**
     * Gets the input and outputs an array that gives the configuration.
     * @return an array containg three numbers that will be used to
     * @throws IllegalArgumentException If the values given aren't three.
     * @throws NumberFormatException If the numbers in the input are not integer.
     * creating the dies.
     */
    public static int[] getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Example: ");
        String[] config = sc.nextLine().split(" ");
        if (config.length != 3) {
            throw new IllegalArgumentException("Expected 3 values but only received " + config.length);
        }
        int[] intConfig = new int[3];
        for (int i = 0; i < config.length; i++) {
            try {
                intConfig[i] = Integer.parseInt(config[i]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid input: All values must be whole numbers.");
            }
        }

        return intConfig;
    }

    /**
     * Creates an array of dies depending on how many dies.
     * @param numDice The number of dices to create
     * @param numSides The number of sides on dices.
     * @return An array of dies.
     */
    public static Die[] createDice(int numDice, int numSides) {

        Die[] dies = new Die[numDice];
        for (int i = 0; i < numDice; i++) {
            dies[i] = new Die(numSides);
        }
        return dies;
    }

    /**
     * The frequencies of each result from how many times it's rollde.
     * @param dices The dices in the arrays
     * @param numSides The number of sides of each die.
     * @param numRolls How many times to roll each dice
     * @return The frequencies of each results.
     */
    public static int[] rollDice(Die[] dices, int numSides, int numRolls) {
        int maxSum = dices.length * numSides;
        int minSum = dices.length;
        int[] results = new int[maxSum - minSum + 1];
        for (int i = 0; i < numRolls; i++) {
            int total = 0;
            for (Die dice : dices) {
                dice.roll();
                total += dice.getCurrentValue();
            }
            results[total - minSum] = results[total- minSum] + 1;
        }
        return results;
    }

    /**
     * The max result of which value was rolled the most.
     * @param rolls The number of rolls rolled.
     * @return The max results of which value was rolled the most.
     */
    private static int findMax(int[] rolls) {
        int max = 0;
        for (int count : rolls) {
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    /**
     * Prints out all the report of the credits' frequencies.
     * @param numDice The number of dices rolled
     * @param rolls How many rolls it dones.
     * @param max The max value from max().
     */
    private static void report(int numDice, int[] rolls, int max) {
        final int scaleNum = 10;
        int scale = max / scaleNum;

        for (int i = 0; i < rolls.length; i++) {
            int sum = i + numDice;

            int numStars = rolls[i] / scale;

            String stars = "*".repeat(numStars);

            if (sum < scaleNum) {
                System.out.printf("%d :%5d %s%n", sum, rolls[i], stars);
            } else {
                System.out.printf("%d:%5d %s%n", sum, rolls[i], stars);
            }
        }
    }
}