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

            Function<String, String> replacer = createReplacer();
            IntFunction<String> mapper = createFinalSubstituer(replacer);
            return substitute(input, mapper);
        }

        private static String substitute(int input, IntFunction<String> mapper) {
            return ("" + input).chars().mapToObj(mapper).collect(Collectors.joining());
        }

        private static IntFunction<String> createFinalSubstituer(Function<String, String> replacer) {
            return c -> replacer.apply("" + (c - '0'));
        }

        private static Function<String, String> createReplacer() {
            Function<FBW, Function<String, String>> mapper2 = fbw -> (s -> s.equals("" + fbw.value) ? fbw.toString() : s);
            return Arrays.stream(values()).map(mapper2).reduce(Function.identity(), Function::andThen);
        }
    }

    public String convert(int input) {

        String result = "";
        boolean isDivisible = FBW.isDivisible(input);
        if (isDivisible) {
            result = FBW.fizzBuzzWoofByDivision(input);
        }


        boolean contains = contains(input);
        if (contains) {
            result += substitution(input);
        }

        if (isDivisible || contains) {
            return result;
        }

        return "" + input;
    }

    private String substitution(int input) {
        String firstSubstitution = FBW.fizzBuzzWoofBySubstitution(input);
        String secondSubstitution = replace0ByStar(firstSubstitution);
        return removeDigitsFrom(secondSubstitution);
    }

    private String removeDigitsFrom(String input) {
        return input.replaceAll("[0-9]", "");
    }

    private String replace0ByStar(String input) {
        return input.replace("0", "*");
    }

    private boolean contains(int input) {
        return FBW.contains(input) || ("" + input).contains("0");
    }
}
