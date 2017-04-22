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

/**
 * Created by José
 */
public class FizzBuzzWoof {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String WOOF = "Woof";

    public String convert(int input) {

        String result = "";
        boolean isDivisible = false;
        if (isDivisibleBy3(input)) {
            result += FIZZ;
            isDivisible = true;
        }
        if (isDivisibleBy5(input)) {
            result += BUZZ;
            isDivisible = true;
        }
        if (isDivisibleBy7(input)) {
            result += WOOF;
            isDivisible = true;
        }
        if (isDivisible) {
            return result;
        }

        if (("" + input).contains("3")) {
            return FIZZ;
        } else if (("" + input).contains("5")) {
            return BUZZ;
        } else if (("" + input).contains("7")) {
            return WOOF;
        }

        return "" + input;
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
