package services;

import exceptions.CalculatorException;

public abstract class Calculator {
    /**
     *  Add two number
     *
     * @param x first term
     * @param y second term
     * @return the sum of x and y
     */
    public static double add(double x, double y){
        return x + y;
    }

    /**
     * Subtract two number
     *
     * @param x first term
     * @param y second term
     * @return the difference between x and y
     */
    public static double sub(double x, double y){
        return x - y;
    }

    /**
     * Multiply two number
     *
     * @param x first factor
     * @param y second factor
     * @return the product of x and y
     */
    public static double times(double x, double y){
        return x * y;
    }

    /**
     * Divides two numbers.
     *
     * @param x the dividend
     * @param y the divisor
     * @return the quotient of x and y
     * @throws CalculatorException Divisor can't be equal to zero.
     */
    public static double divide(double x, double y) throws CalculatorException {
        // Check for division by zero
        if (Double.compare(y, 0.0) == 0) {
            throw new CalculatorException("Divisor can't be equal to zero.");
        }

        return x / y;
    }
}
