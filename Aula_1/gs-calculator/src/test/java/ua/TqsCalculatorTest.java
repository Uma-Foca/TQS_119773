package ua;

import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TqsCalculatorTest {

    // Don't use System.out.println, use a logger instead
    static final Logger log = org.slf4j.LoggerFactory.getLogger(lookup().lookupClass());

    @org.junit.jupiter.api.Test
    void add() {
        TqsCalculator t = new TqsCalculator();
        log.debug("Testing sum method in {}", t.getClass().getName());

        assertEquals(5, t.add(2, 3));
        assertEquals(-1, t.add(2, -3));
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        TqsCalculator t = new TqsCalculator();
        log.debug("Testing subtract method in {}", t.getClass().getName());

        assertEquals(-1, t.subtract(2, 3));
        assertEquals(5, t.subtract(2, -3));
    }

    @DisplayName("Multiplies two numbers and returns the product")
    @org.junit.jupiter.api.Test
    void multiply() {
        TqsCalculator t = new TqsCalculator();
        assertEquals(6, t.multiply(2, 3));
        assertEquals(-6, t.multiply(2, -3));
        assertEquals(0, t.multiply(2, 0));
    }

    @DisplayName("Divides two numbers and returns the quotient, excludes division by zero")
    @org.junit.jupiter.api.Test
    void divide() {
        TqsCalculator t = new TqsCalculator();
        assertEquals(2, t.divide(6, 3));
        assertEquals(-2, t.divide(6, -3));

        assertThrows(IllegalArgumentException.class, () -> t.divide(2, 0));
    }

    @DisplayName("Divides two numbers that result in an infinite decimal")
    @org.junit.jupiter.api.Test
    void infinite_decimal_divide() {
        TqsCalculator t = new TqsCalculator();
        assertEquals(13.0/11, t.divide(13, 11));
        assertEquals(7.0/5, t.divide(7, 5));
    }

    @DisplayName("Multiplies the number by itself a number of times and returns the result")
    @org.junit.jupiter.api.Test
    void exp() {
        TqsCalculator t = new TqsCalculator();
        assertEquals(8, t.exp(2, 3));
        assertEquals(0.25, t.exp(2, -2));
        assertEquals(22667121, t.exp(69, 4));
        assertEquals(1.0/420, t.exp(420, -1));
        assertEquals(1, t.exp(5, 0));
        assertEquals(12, t.exp(12, 1));
    }

    @DisplayName("Calculates the square root of a number and returns it")
    @org.junit.jupiter.api.Test
    void sqrt() {
        TqsCalculator t = new TqsCalculator();
        assertEquals(1, t.sqrt(1));
        assertEquals(2, t.sqrt(4));
        assertEquals(69, t.sqrt(4761));
        assertEquals(420, t.sqrt(176400));
        assertEquals(12, t.sqrt(144));
        assertEquals(5, t.sqrt(25));
    }
}