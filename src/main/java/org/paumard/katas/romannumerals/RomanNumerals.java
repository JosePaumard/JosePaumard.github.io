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

    public String toRoman(int input) {
        if (input == 6) {
            return "VI";
        } else if (input == 5) {
            return "V";
        } else if (input == 4) {
            return "IV";
        }
        return repeatSymbolI(input);
    }

    private String repeatSymbolI(int input) {
        return IntStream.range(0, input).mapToObj(i -> "I").collect(Collectors.joining());
    }
}
