////////////////////////////////////////////////////////////////////
// Davide Baraldo 2082847
// Alessandro Zainer 2101091
////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

import java.util.HashMap;
import java.util.Map;

public class RomanPrinter {
    private static final Map<Character, String[]> ASCII_MAP = new HashMap<>();

    static {
        ASCII_MAP.put('I', new String[]{
                "  _____  ",
                " |_   _| ",
                "   | |   ",
                "   | |   ",
                "  _| |_  ",
                " |_____| "
        });

        ASCII_MAP.put('V', new String[]{
                " __      __ ",
                " \\ \\    / / ",
                "  \\ \\  / /  ",
                "   \\ \\/ /   ",
                "    \\  /    ",
                "     \\/     "
        });

        ASCII_MAP.put('X', new String[]{
                " __   __ ",
                " \\ \\ / / ",
                "  \\ V /  ",
                "   > <   ",
                "  / . \\  ",
                " /_/ \\_\\ "
        });

        ASCII_MAP.put('L', new String[]{
                "  _       ",
                " | |      ",
                " | |      ",
                " | |      ",
                " | |____  ",
                " |______| "
        });

        ASCII_MAP.put('C', new String[]{
                "   _____  ",
                "  / ____| ",
                " | |      ",
                " | |      ",
                " | |____  ",
                "  \\_____| "
        });

        ASCII_MAP.put('D', new String[]{
                "  _____   ",
                " |  __ \\  ",
                " | |  | | ",
                " | |  | | ",
                " | |__| | ",
                " |_____/  "
        });

        ASCII_MAP.put('M', new String[]{
                "  __  __  ",
                " |  \\/  | ",
                " | \\  / | ",
                " | |\\/| | ",
                " | |  | | ",
                " |_|  |_| "
        });
    }


    public static String print(int num) {
        return printAsciiArt(IntegerToRoman.convert(num));
    }

    private static String printAsciiArt(String romanNumber) {
        StringBuilder[] lines = new StringBuilder[6];
        for (int i = 0; i < 6; i++) {
            lines[i] = new StringBuilder();
        }

        for (char c : romanNumber.toCharArray()) {
            String[] art = ASCII_MAP.get(c);
            if (art == null) {
                throw new IllegalArgumentException("Carattere romano non supportato: " + c);
            }
            for (int i = 0; i < 6; i++) {
                lines[i].append(art[i]);
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder line : lines) {
            result.append(line).append("\n");
        }

        return result.toString();
    }
}
