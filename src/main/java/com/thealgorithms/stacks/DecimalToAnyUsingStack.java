package com.thealgorithms.stacks;

import java.util.Stack;

public class DecimalToAnyUsingStack {

    public static void main(String[] args) {
        assert "0".equals(convert(0, 2));
        assert "11110".equals(convert(30, 2));
        assert "36".equals(convert(30, 8));
        assert "30".equals(convert(30, 10));
        assert "1E".equals(convert(30, 16));
    }

    /**
     * Convert decimal number to another radix
     *
     * @param number the number to be converted
     * @param radix the radix
     * @return another radix
     * @throws ArithmeticException if <tt>number</tt> or <tt>radius</tt> is
     * invalid
     */
    private static String convert(int number, int radix) {
        if (radix < 2 || radix > 16) {
            throw new ArithmeticException(String.format("Invalid input -> number:%d,radius:%d", number, radix));
        }
        char[] tables = {
            '0',
            '1',
            '2',
            '3',
            '4',
            '5',
            '6',
            '7',
            '8',
            '9',
            'A',
            'B',
            'C',
            'D',
            'E',
            'F',
        };
        Stack<Character> bits = new Stack<>();
        do {
            bits.push(tables[number % radix]);
            number = number / radix;
        } while (number != 0);

        StringBuilder result = new StringBuilder();
        while (!bits.isEmpty()) {
            result.append(bits.pop());
        }
        return result.toString();
    }
}
