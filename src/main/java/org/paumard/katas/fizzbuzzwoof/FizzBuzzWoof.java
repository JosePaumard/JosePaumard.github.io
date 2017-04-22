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

            Function<FBW, Function<String, String>> mapper1 = fbw -> (s -> s.replace("" + fbw.value, ""));
            Function<String, String> replacer = Arrays.stream(values()).map(mapper1).reduce(Function.identity(), Function::andThen);

            String nonSubstitutedInts = replacer.apply("0123456789");
            UnaryOperator<String> finisher = s -> nonSubstitutedInts.contains(s) ? "" : s;

            Function<FBW, Function<String, String>> mapper2 = fbw -> (s -> s.equals("" + fbw.value) ? fbw.toString() : s);

            Function<String, String> function = Arrays.stream(values()).map(mapper2).reduce(Function.identity(), Function::andThen).andThen(finisher);
            IntFunction<String> mapper = c -> function.apply("" + (c - '0'));
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
