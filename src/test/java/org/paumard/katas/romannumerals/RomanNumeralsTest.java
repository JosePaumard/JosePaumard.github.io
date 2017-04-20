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

package org.paumard.katas.romannumerals;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * Created by José
 */
public class RomanNumeralsTest {

    @Test
    public void should_return_I_for_1() {

        // Given
        int input = 1;
        String expectedOutput = "I";
        RomanNumerals romanNumerals = new RomanNumerals();

        // When
        String output = romanNumerals.toRoman(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_II_for_2() {

        // Given
        int input = 2;
        String expectedOutput = "II";
        RomanNumerals romanNumerals = new RomanNumerals();

        // When
        String output = romanNumerals.toRoman(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_III_for_3() {

        // Given
        int input = 3;
        String expectedOutput = "III";
        RomanNumerals romanNumerals = new RomanNumerals();

        // When
        String output = romanNumerals.toRoman(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_IV_for_4() {

        // Given
        int input = 4;
        String expectedOutput = "IV";
        RomanNumerals romanNumerals = new RomanNumerals();

        // When
        String output = romanNumerals.toRoman(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_V_for_5() {

        // Given
        int input = 5;
        String expectedOutput = "V";
        RomanNumerals romanNumerals = new RomanNumerals();

        // When
        String output = romanNumerals.toRoman(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_VI_for_6() {

        // Given
        int input = 6;
        String expectedOutput = "VI";
        RomanNumerals romanNumerals = new RomanNumerals();

        // When
        String output = romanNumerals.toRoman(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_VII_for_7() {

        // Given
        int input = 7;
        String expectedOutput = "VII";
        RomanNumerals romanNumerals = new RomanNumerals();

        // When
        String output = romanNumerals.toRoman(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_VIII_for_8() {

        // Given
        int input = 8;
        String expectedOutput = "VIII";
        RomanNumerals romanNumerals = new RomanNumerals();

        // When
        String output = romanNumerals.toRoman(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_IX_for_9() {

        // Given
        int input = 9;
        String expectedOutput = "IX";
        RomanNumerals romanNumerals = new RomanNumerals();

        // When
        String output = romanNumerals.toRoman(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_X_for_10() {

        // Given
        int input = 10;
        String expectedOutput = "X";
        RomanNumerals romanNumerals = new RomanNumerals();

        // When
        String output = romanNumerals.toRoman(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_XX_for_20() {

        // Given
        int input = 20;
        String expectedOutput = "XX";
        RomanNumerals romanNumerals = new RomanNumerals();

        // When
        String output = romanNumerals.toRoman(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_XXX_for_30() {

        // Given
        int input = 30;
        String expectedOutput = "XXX";
        RomanNumerals romanNumerals = new RomanNumerals();

        // When
        String output = romanNumerals.toRoman(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_XL_for_40() {

        // Given
        int input = 40;
        String expectedOutput = "XL";
        RomanNumerals romanNumerals = new RomanNumerals();

        // When
        String output = romanNumerals.toRoman(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_L_for_50() {

        // Given
        int input = 50;
        String expectedOutput = "L";
        RomanNumerals romanNumerals = new RomanNumerals();

        // When
        String output = romanNumerals.toRoman(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    public void should_return_LX_for_60() {

        // Given
        int input = 60;
        String expectedOutput = "LX";
        RomanNumerals romanNumerals = new RomanNumerals();

        // When
        String output = romanNumerals.toRoman(input);

        // Then
        Assertions.assertThat(output).isEqualTo(expectedOutput);
    }
}
