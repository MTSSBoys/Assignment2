package it.unipd.mtss;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class IntegerToRomanTest {

    @Test
    public void testBasicCase() {
        // Arrange
        int number = 1;

        // Act
        String result = IntegerToRoman.convert(number);

        // Assert
        assertEquals("I", result);
    }

    @Test
    public void testTwoDigitsCase() {
        int number = 11;

        String result = IntegerToRoman.convert(number);

        assertEquals("XI", result);
    }

    @Test
    public void testThreeDigitsCase() {
        int number = 111;

        String result = IntegerToRoman.convert(number);

        assertEquals("CXI", result);
    }

    @Test
    public void testUpperBound() {
        int number = 1000;

        String result = IntegerToRoman.convert(number);

        assertEquals("M", result);
    }

    @Test
    public void testJustAboveUpperBound() {
        int number = 1001;

        ThrowingRunnable result = () -> IntegerToRoman.convert(number);

        assertThrows(IllegalArgumentException.class, result);
    }

    @Test
    public void testOverUpperBound() {
        int number = 29949393; // Random number way above the upper bound

        ThrowingRunnable result = () -> IntegerToRoman.convert(number);

        assertThrows(IllegalArgumentException.class, result);
    }

    @Test
    public void testZero() {
        int number = 0;

        ThrowingRunnable result = () -> IntegerToRoman.convert(number);

        assertThrows(IllegalArgumentException.class, result);
    }

    @Test
    public void testMinusOne() {
        int number = -1;

        ThrowingRunnable result = () -> IntegerToRoman.convert(number);

        assertThrows(IllegalArgumentException.class, result);
    }

    @Test
    public void testNegativeValue() {
        int number = -234233423; // Random number, way below zero

        ThrowingRunnable result = () -> IntegerToRoman.convert(number);

        assertThrows(IllegalArgumentException.class, result);
    }

    @Test
    public void testMaxInteger() {
        int number = Integer.MAX_VALUE;

        ThrowingRunnable result = () -> IntegerToRoman.convert(number);

        assertThrows(IllegalArgumentException.class, result);
    }

    @Test
    public void testMinInteger() {
        int number = Integer.MAX_VALUE;

        ThrowingRunnable result = () -> IntegerToRoman.convert(number);

        assertThrows(IllegalArgumentException.class, result);
    }

    @Test
    public void testLargeNumber() {
        int number = 888;

        String result = IntegerToRoman.convert(number);

        assertEquals(result, "DCCCLXXXVIII");
    }
}