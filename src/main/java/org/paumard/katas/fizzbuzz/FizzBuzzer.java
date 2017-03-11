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

package org.paumard.katas.fizzbuzz;

/**
 * Created by José
 */
public class FizzBuzzer {

    private static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public String fizzBuzz(int input) {

        if (isDivisibleBy3(input) && isDivisibleBy5(input))
            return FIZZ + BUZZ;

        if (isDivisibleBy3(input))
            return FIZZ;

        if (isDivisibleBy5(input))
            return BUZZ;

        return "" + input;
    }

    private boolean isDivisibleBy5(int input) {
        return input % 5 == 0;
    }

    private boolean isDivisibleBy3(int input) {
        return input % 3 == 0;
    }
}
