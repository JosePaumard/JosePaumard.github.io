/*
 * Copyright (C) 2017 José Paumard
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.paumard.katas.romannumerals;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by José
 */
public class RomanNumerals {

    public static final String I = "I";
    public static final String V = "V";
    public static final String X = "X";
    public static final String L = "L";
    public static final String C = "C";
    public static final String D = "D";
    public static final String M = "M";

    public String toRoman(int input) {

        int thousandsDigit = input / 1000;
        int hundredsDigit = (input % 1000) / 100;
        int tensDigit = (input % 100) / 10;
        int unitsDigit = input % 10;

        return convertThousandsDigit(thousandsDigit) +
                convertHundredsDigit(hundredsDigit) +
                convertTensDigit(tensDigit) +
                convertUnitDigit(unitsDigit);
    }

    private String convertThousandsDigit(int input) {
        return convertToDigit(input, M, "", "");
    }

    private String convertHundredsDigit(int input) {
        return convertToDigit(input, C, D, M);
    }

    private String convertTensDigit(int input) {
        return convertToDigit(input, X, L, C);
    }

    private String convertUnitDigit(int input) {
        return convertToDigit(input, I, V, X);
    }

    private String convertToDigit(int input, String symbolFor1, String symbolFor5, String symbolFor10) {
        switch (input) {
            case 1:
            case 2:
            case 3:
                return repeatSymbol(input, symbolFor1);
            case 4:
                return symbolFor1 + symbolFor5;
            case 5:
                return symbolFor5;
            case 6:
            case 7:
            case 8:
                return symbolFor5 + repeatSymbol(input - 5, symbolFor1);
            case 9:
                return symbolFor1 + symbolFor10;
        }
        return "";
    }

    private String repeatSymbol(int input, String symbol) {
        return IntStream.range(0, input).mapToObj(i -> symbol).collect(Collectors.joining());
    }

    private enum RomanDigits {
        I(1), V(5), X(10);

        private int value;

        private RomanDigits(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }

        public static RomanDigits of(int c) {
            return Arrays.stream(values()).filter(digit -> digit.toString().charAt(0) == c).findFirst().get();
        }
    }

    public int toArabics(String input) {

        IntUnaryOperator toValue = c -> {
            RomanDigits romanDigits = RomanDigits.of(c);
            return romanDigits.value();
        };

        return input.chars().map(toValue).sum();
    }
}
