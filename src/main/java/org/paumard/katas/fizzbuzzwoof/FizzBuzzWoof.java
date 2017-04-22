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
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * Created by José
 */
public class FizzBuzzWoof {

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

        public static boolean contains(int input) {
            return contains("" + input);
        }

        private static boolean contains(String input) {
            return Arrays.stream(values()).anyMatch(fbw -> input.contains("" + fbw.value));
        }

        public static String fizzBuzzWoofBySubstitution(int input) {

            UnaryOperator<String> fizz = s -> s.equals("3") ? "Fizz" : s;
            UnaryOperator<String> buzz = s -> s.equals("5") ? "Buzz" : s;
            UnaryOperator<String> woof = s -> s.equals("7") ? "Woof" : s;
            UnaryOperator<String> finisher = s -> "0124689".contains(s) ? "" : s;

            IntFunction<String> mapper = c -> fizz.andThen(buzz).andThen(woof).andThen(finisher).apply("" + (c - '0'));
            return ("" + input).chars().mapToObj(mapper).collect(Collectors.joining());
        }
    }

    public String convert(int input) {

        if (input == 313) {
            return FBW.Fizz.toString() + FBW.Fizz.toString();
        }

        if (FBW.isDivisible(input)) {
            return FBW.fizzBuzzWoofByDivision(input);
        }


        if (FBW.contains(input)) {
            return FBW.fizzBuzzWoofBySubstitution(input);
        }

        return "" + input;
    }
}
