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

    @Test
    public void should_compute_3_for_input_1_2_ADD() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "1 2 +";
        int expectedResult = 3;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_5_for_input_3_2_ADD() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "3 2 +";
        int expectedResult = 5;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_6_for_input_3_2_ADD_1_ADD() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "3 2 + 1 +";
        int expectedResult = 6;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_7_for_input_3_2_2_ADD_ADD() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "3 2 2 + +";
        int expectedResult = 7;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_6_for_input_3_2_2_ADD_ADD_1_SUB() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "3 2 2 + + 1 -";
        int expectedResult = 6;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_4_for_input_20_5_DIV() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "20 5 /";
        int expectedResult = 4;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_100_for_input_20_5_MULT() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "20 5 *";
        int expectedResult = 100;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }
}
