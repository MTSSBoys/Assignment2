////////////////////////////////////////////////////////////////////
// Davide Baraldo 2082847
// Alessandro Zainer 2101091
////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

public class IntegerToRoman {

    public enum RomanNumeral {
        M(1000, "M"),
        CM(900, "CM"),
        D(500, "D"),
        CD(400, "CD"),
        C(100, "C"),
        XC(90, "XC"),
        L(50, "L"),
        XL(40, "XL"),
        X(10, "X"),
        IX(9, "IX"),
        V(5, "V"),
        IV(4, "IV"),
        I(1, "I");

        private final int value;
        private final String symbol;

        RomanNumeral(int value, String symbol) {
            this.value = value;
            this.symbol = symbol;
        }

        public int getValue() {
            return value;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    public static String convert(int number) {
        if (number <= 0 || number > 1000) {
            throw new IllegalArgumentException("Number must be between 1 and 1000");
        }

        StringBuilder result = new StringBuilder();

        for (RomanNumeral numeral : RomanNumeral.values()) {
            while (number >= numeral.getValue()) {
                result.append(numeral.getSymbol());
                number -= numeral.getValue();
            }
        }

        return result.toString();
    }
}