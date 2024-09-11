/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: FIXME
 * Last Updated: FIXME
 */
package mirzaa;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Please enter the number of dice to roll, how many sides the dice have,");
        System.out.println("and how many rolls to complete, separating the values by a space");
        int[] config = getInput();
        Die[] dices = createDice(config[0], config[1]);
    }
    public static int[] getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Example: ");
        String[] config = sc.nextLine().split(" ");
        if (config.length != 3)
        {
            // TODO: throw exception.
        }
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
//    public int[] rollDice(int numDice, int numSides) {}
//    public int findMax(int[] rolls) {}
//    public void report(int numDice, int[] rolls, int max) {}
}