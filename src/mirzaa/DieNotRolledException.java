/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Ayaan Mirza
 * Last Updated: Ayaan Mirza
 */
package mirzaa;

/**
 * The Exception if the Die was not rolled.
 */
public class DieNotRolledException extends RuntimeException {

    /**
     * Provides an error message for this exception.
     *
     * @return A string that contains the error messages
     */
    @Override
    public String getMessage() {
        return "Die has not been rolled yet";
    }
}