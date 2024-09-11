/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: FIXME
 * Last Updated: FIXME
 */
package mirzaa;

public class DieNotRolledException extends RuntimeException {
    public DieNotRolledException(String errorMessage) {
        super(errorMessage);
    }
}