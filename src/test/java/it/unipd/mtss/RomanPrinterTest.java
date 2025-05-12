package it.unipd.mtss;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class RomanPrinterTest {

    private String invokePrintAsciiArt(String roman) throws Throwable {
        try {
            Method method = RomanPrinter.class.getDeclaredMethod("printAsciiArt", String.class);
            method.setAccessible(true);
            return (String) method.invoke(null, roman);
        } catch (NoSuchMethodException|SecurityException e) {
            throw new RuntimeException("Failed to get printAsciiArt via reflection", e);
        } catch (IllegalAccessException|IllegalArgumentException e) {
            throw new RuntimeException("Failed to invoke printAsciiArt via reflection", e);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }

    @Test
    public void shouldPrintAsciiForI() throws Throwable {
        String roman = "I";
        String[] expected = new String[]{
                "  _____  ",
                " |_   _| ",
                "   | |   ",
                "   | |   ",
                "  _| |_  ",
                " |_____| ",
                ""
        };

        assertEquals(String.join("\n", expected), invokePrintAsciiArt(roman));
    }

    @Test
    public void shouldPrintAsciiForII() throws Throwable {
        String roman = "II";
        String[] expected = new String[]{
                "  _____  " + "  _____  ",
                " |_   _| " + " |_   _| ",
                "   | |   " + "   | |   ",
                "   | |   " + "   | |   ",
                "  _| |_  " + "  _| |_  ",
                " |_____| " + " |_____| ",
                ""
        };

        assertEquals(String.join("\n", expected), invokePrintAsciiArt(roman));
    }

    @Test
    public void shouldPrintAsciiForIII() throws Throwable {
        String roman = "III";
        String[] expected = new String[]{
                "  _____  " + "  _____  " + "  _____  ",
                " |_   _| " + " |_   _| " + " |_   _| ",
                "   | |   " + "   | |   " + "   | |   ",
                "   | |   " + "   | |   " + "   | |   ",
                "  _| |_  " + "  _| |_  " + "  _| |_  ",
                " |_____| " + " |_____| " + " |_____| ",
                ""
        };

        assertEquals(String.join("\n", expected), invokePrintAsciiArt(roman));
    }

    @Test
    public void shouldPrintAsciiForV() throws Throwable {
        String roman = "V";
        String[] expected = new String[]{
                " __      __ ",
                " \\ \\    / / ",
                "  \\ \\  / /  ",
                "   \\ \\/ /   ",
                "    \\  /    ",
                "     \\/     ",
                ""
        };

        assertEquals(String.join("\n", expected), invokePrintAsciiArt(roman));
    }

    @Test
    public void shouldPrintAsciiForX() throws Throwable {
        String roman = "X";
        String[] expected = new String[]{
                " __   __ ",
                " \\ \\ / / ",
                "  \\ V /  ",
                "   > <   ",
                "  / . \\  ",
                " /_/ \\_\\ ",
                ""
        };

        assertEquals(String.join("\n", expected), invokePrintAsciiArt(roman));
    }

    @Test
    public void shouldPrintAsciiForL() throws Throwable {
        String roman = "L";
        String[] expected = new String[]{
                "  _       ",
                " | |      ",
                " | |      ",
                " | |      ",
                " | |____  ",
                " |______| ",
                ""
        };

        assertEquals(String.join("\n", expected), invokePrintAsciiArt(roman));
    }

    @Test
    public void shouldPrintAsciiForC() throws Throwable {
        String roman = "C";
        String[] expected = new String[]{
                "   _____  ",
                "  / ____| ",
                " | |      ",
                " | |      ",
                " | |____  ",
                "  \\_____| ",
                ""
        };

        assertEquals(String.join("\n", expected), invokePrintAsciiArt(roman));
    }

    @Test
    public void shouldPrintAsciiForD() throws Throwable {
        String roman = "D";
        String[] expected = new String[]{
                "  _____   ",
                " |  __ \\  ",
                " | |  | | ",
                " | |  | | ",
                " | |__| | ",
                " |_____/  ",
                ""
        };

        assertEquals(String.join("\n", expected), invokePrintAsciiArt(roman));
    }

    @Test
    public void shouldPrintAsciiForM() throws Throwable {
        String roman = "M";
        String[] expected = new String[]{
                "  __  __  ",
                " |  \\/  | ",
                " | \\  / | ",
                " | |\\/| | ",
                " | |  | | ",
                " |_|  |_| ",
                ""
        };

        assertEquals(String.join("\n", expected), invokePrintAsciiArt(roman));
    }

    @Test
    public void testInvalidArgumentExceptionOnPrint_LowerBound() {
        int number = 0;

        ThrowingRunnable result = () -> RomanPrinter.print(number);

        assertThrows(IllegalArgumentException.class, result);
    }


    @Test
    public void testInvalidArgumentExceptionOnPrint_UpperBound() {
        int number = 1001;

        ThrowingRunnable result = () -> RomanPrinter.print(number);

        assertThrows(IllegalArgumentException.class, result);
    }

    @Test
    public void testInRangeNumber() throws Throwable {
        int number = 888;
        String expectedOutput, actualOutput;

        expectedOutput = invokePrintAsciiArt(IntegerToRoman.convert(888));
        actualOutput = RomanPrinter.print(888);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testInvalidCharacter() {
        String invalid = "AAA";

        ThrowingRunnable result = () -> invokePrintAsciiArt(invalid);

        assertThrows(IllegalArgumentException.class, result);
    }
}
