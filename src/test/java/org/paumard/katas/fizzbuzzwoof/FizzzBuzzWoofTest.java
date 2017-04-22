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

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * Created by José
 */
public class FizzzBuzzWoofTest {

    @Test
    public void should_return_1_for_1() {

        // Given
        int input = 1;
        String expectedOuput = "1";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_2_for_2() {

        // Given
        int input = 2;
        String expectedOuput = "2";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Fizz_for_6() {

        // Given
        int input = 6;
        String expectedOuput = "Fizz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Fizz_for_9() {

        // Given
        int input = 9;
        String expectedOuput = "Fizz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Buzz_for_10() {

        // Given
        int input = 10;
        String expectedOuput = "Buzz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Buzz_for_20() {

        // Given
        int input = 20;
        String expectedOuput = "Buzz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Woof_for_14() {

        // Given
        int input = 14;
        String expectedOuput = "Woof";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Woof_for_28() {

        // Given
        int input = 28;
        String expectedOuput = "Woof";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_FizzBuzz_for_60() {

        // Given
        int input = 60;
        String expectedOuput = "FizzBuzz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_FizzWoof_for_21() {

        // Given
        int input = 21;
        String expectedOuput = "FizzWoof";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_BuzzWoof_for_140() {

        // Given
        int input = 140;
        String expectedOuput = "BuzzWoof";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_FizzBuzzWoof_for_210() {

        // Given
        int input = 210;
        String expectedOuput = "FizzBuzzWoof";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Fizz_for_13() {

        // Given
        int input = 13;
        String expectedOuput = "Fizz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Buzz_for_52() {

        // Given
        int input = 52;
        String expectedOuput = "Buzz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Woof_for_17() {

        // Given
        int input = 17;
        String expectedOuput = "Woof";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_FizzFizz_for_313() {

        // Given
        int input = 313;
        String expectedOuput = "FizzFizz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_FizzFizzFizz_for_2313() {

        // Given
        int input = 2313;
        String expectedOuput = "FizzFizzFizz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_FizzBuzzBuzzFizzBuzz_for_2535() {

        // Given
        int input = 2535;
        String expectedOuput = "FizzBuzzBuzzFizzBuzz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOuput);
    }
}
