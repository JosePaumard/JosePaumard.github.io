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

package org.paumard.katas.rpncalculator;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by José
 */
public class RPNCalculatorTest {

    @Test
    public void should_compute_1_for_input_1() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "1";
        int expectedResult = 1;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_2_for_input_2() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "2";
        int expectedResult = 2;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }
}
