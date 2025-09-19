package ua;

/**
 * Basic calculator class with methods for addition, subtraction, multiplication, and division.
 */
public class TqsCalculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public double exp(double a, int b) {
        double r;
        if (b == 0) {
            return 1;
        } else if (b > 0) {
            r = a;
            for (int i = 1; i < b; i++) {
                r = r*a;
            }
            return r;
        } else {
            r = 1/a;
            for (int i = -1; i > b; i--) {
                r = r/a;
            }
            return r;
        }
    }

    public double sqrt(double a) {
        return Math.sqrt(a);
    }

}
