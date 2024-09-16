/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Ayaan Mirza
 * Last Updated: Ayaan Mirza
 */
package mirzaa;

public class DieNotRolledException extends RuntimeException {
    public DieNotRolledException(String errorMessage) {
        super(errorMessage);
    }
}