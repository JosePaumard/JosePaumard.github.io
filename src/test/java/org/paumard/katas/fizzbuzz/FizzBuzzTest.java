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

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by José
 */
public class FizzBuzzTest {

    @Test
    public void should_return_1_when_fizzBuzzing_1() {

        // Given
        FizzBuzzer fizzBuzzer = new FizzBuzzer();
        int input = 1;
        String expectedOutput = "1";

        // When
        String output = fizzBuzzer.fizzBuzz(input);

        // Then
        assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_2_when_fizzBuzzing_2() {

        // Given
        FizzBuzzer fizzBuzzer = new FizzBuzzer();
        int input = 2;
        String expectedOutput = "2";

        // When
        String output = fizzBuzzer.fizzBuzz(input);

        // Then
        assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_Fizz_when_fizzBuzzing_3() {

        // Given
        FizzBuzzer fizzBuzzer = new FizzBuzzer();
        int input = 3;
        String expectedOutput = "Fizz";

        // When
        String output = fizzBuzzer.fizzBuzz(input);

        // Then
        assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_Fizz_when_fizzBuzzing_6() {

        // Given
        FizzBuzzer fizzBuzzer = new FizzBuzzer();
        int input = 6;
        String expectedOutput = "Fizz";

        // When
        String output = fizzBuzzer.fizzBuzz(input);

        // Then
        assertThat(output).isEqualTo(expectedOutput);
    }
}
