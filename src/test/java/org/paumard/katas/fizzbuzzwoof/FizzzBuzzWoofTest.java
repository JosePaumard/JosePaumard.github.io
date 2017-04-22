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
}
