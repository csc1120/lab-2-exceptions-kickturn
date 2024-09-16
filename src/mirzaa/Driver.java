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

public class Driver {
    public static void main(String[] args) {
        System.out.println("Please enter the number of dice to roll, how many sides the dice have,");
        System.out.println("and how many rolls to complete, separating the values by a space");
        int[] config = getInput();
        Die[] dices = createDice(config[0], config[1]);
        int[] freq = rollDice(dices, config[1], config[2]);
        System.out.println(Arrays.toString(freq));
        int max = findMax(freq);
        report(config[0], freq, max);

    }
    public static int[] getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Example: ");
        String[] config = sc.nextLine().split(" ");
        int[] intConfig = new int[3];
        for (int i = 0; i < config.length; i++) {
            intConfig[i] = Integer.parseInt(config[i]);
        }

        return intConfig;
    }
    public static Die[] createDice(int numDice, int numSides) {
        Die[] dies = new Die[numDice];
        for (int i = 0; i < numDice; i++)
        {
            dies[i] = new Die(numSides);
        }
        return dies;
    }
    public static int[] rollDice(Die[] dices, int numSides, int numRolls) {
        int maxSum = dices.length * numSides;
        int minSum = dices.length;
        int[] results = new int[maxSum - minSum + 1];
        for (int i = 0; i < numRolls; i++)
        {
            int total = 0;
            for (Die dice : dices) {
                dice.roll();
                total += dice.getCurrentValue();
            }
            results[total - minSum] = results[total- minSum] + 1;
        }
        return results;
    }
    private static int findMax(int[] rolls) {
        int max = 0;
        for (int count : rolls) {
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    private static void report(int numDice, int[] rolls, int max) {
        int scale = max / 10;

        for (int i = 0; i < rolls.length; i++) {
            int sum = i + numDice;

            int numStars = rolls[i] / scale;

            String stars = "*".repeat(numStars);

            if (sum < 10) {
                System.out.printf("%d :%5d %s%n", sum, rolls[i], stars);
            } else {
                System.out.printf("%d:%5d %s%n", sum, rolls[i], stars);
            }
        }
    }
}