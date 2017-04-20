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

    public String toRoman(int input) {

        switch (input) {
            case 10:
            case 20:
            case 30:
                return repeatSymbolX(input / 10);
            case 40:
                return X + L;
            case 50:
                return L;
            case 60:
            case 70:
            case 80:
                return L + repeatSymbolX(input / 10 - 5);
            case 90:
                return X + C;
        }

        switch (input) {
            case 1:
            case 2:
            case 3:
                return repeatSymbolI(input);
            case 4:
                return I + V;
            case 5:
                return V;
            case 6:
            case 7:
            case 8:
                return V + repeatSymbolI(input - 5);
            case 9:
                return I + X;
        }

        return null;
    }

    private String repeatSymbolX(int input) {
        return repeatSymbol(input, X);
    }

    private String repeatSymbolI(int input) {
        return repeatSymbol(input, I);
    }

    private String repeatSymbol(int input, String symbol) {
        return IntStream.range(0, input).mapToObj(i -> symbol).collect(Collectors.joining());
    }
}
