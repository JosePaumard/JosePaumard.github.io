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

package org.paumard.katas.stringcalculator;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by José
 */
public class StringCalculatorTest {

    @Test
    public void should_return_0_for_an_empty_input() {

        // Given
        StringCalculator stringCalculator = new StringCalculator();
        String input = "";
        int expectedResult = 0;

        // When
        int result = stringCalculator.add(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_1_for_an_input_of_1() {

        // Given
        StringCalculator stringCalculator = new StringCalculator();
        String input = "1";
        int expectedResult = 1;

        // When
        int result = stringCalculator.add(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }
}
