package exceptions;

/**
 * Custom exception for calculator-related errors.
 */
public class CalculatorException extends Exception {
    // Constructor with a default message
    public CalculatorException() {
        super("Calculator error occurred");
    }

    // Constructor with a custom message
    public CalculatorException(String message) {
        super(message);
    }

    // Constructor with a custom message and cause
    public CalculatorException(String message, Throwable cause) {
        super(message, cause);
    }
}