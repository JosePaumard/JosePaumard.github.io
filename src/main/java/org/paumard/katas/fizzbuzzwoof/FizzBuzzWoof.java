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

package org.paumard.katas.fizzbuzzwoof;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by José
 */
public class FizzBuzzWoof {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String WOOF = "Woof";

    private enum FBW {

        Fizz(3),
        Buzz(5),
        Woof(7);

        private int value;

        FBW(int value) {
            this.value = value;
        }

        public static boolean isDivisible(int input) {
            return Arrays.stream(values()).anyMatch(fbw -> input % fbw.value == 0);
        }

        public static String fizzBuzzWoofByDivision(int input) {
            return Arrays.stream(values()).map(fbw -> input % fbw.value == 0 ? fbw.toString() : "").collect(Collectors.joining());
        }
    }

    public String convert(int input) {

        boolean isDivisible = FBW.isDivisible(input);
        if (isDivisible) {
            return FBW.fizzBuzzWoofByDivision(input);
        }


        String inputAsString = "" + input;
        boolean contains = inputAsString.contains("3") || inputAsString.contains("5") || inputAsString.contains("7");

        if (contains) {
            if (inputAsString.contains("3")) {
                return FIZZ;
            } else if (inputAsString.contains("5")) {
                return BUZZ;
            } else if (inputAsString.contains("7")) {
                return WOOF;
            }

            return inputAsString;
        }

        return inputAsString;
    }

    private boolean isDivisibleBy7(int input) {
        return input % 7 == 0;
    }

    private boolean isDivisibleBy5(int input) {
        return input % 5 == 0;
    }

    private boolean isDivisibleBy3(int input) {
        return input % 3 == 0;
    }
}
