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

package org.paumard.katas.onetwo;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by José
 */
public class OneTwoTest {

    @Test
    public void should_return_one_one_for_1() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "1";
        String expectedResult = "one one";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_one_two_for_2() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "2";
        String expectedResult = "one two";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_one_three_for_3() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "3";
        String expectedResult = "one three";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_one_four_for_4() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "4";
        String expectedResult = "one four";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_one_five_for_5() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "5";
        String expectedResult = "one five";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_one_six_for_6() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "6";
        String expectedResult = "one six";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_one_seven_for_7() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "7";
        String expectedResult = "one seven";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_one_eight_for_8() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "8";
        String expectedResult = "one eight";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_one_nine_for_9() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "9";
        String expectedResult = "one nine";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_one_nine_one_six_for_9_6() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "9 6";
        String expectedResult = "one nine one six";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_two_one_for_1_1() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "1 1";
        String expectedResult = "two one";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_two_two_for_2_2() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "2 2";
        String expectedResult = "two two";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_one_three_three_nine_two_eight_for_3_9_9_9_8_8() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "3 9 9 9 8 8";
        String expectedResult = "one three three nine two eight";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_seven_one_for_1_1_1_1_1_1_1() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "1 1 1 1 1 1 1";
        String expectedResult = "seven one";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_one_two_three_four_five_six_for_2_4_4_4_6_6_6_6_6() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "2 4 4 4 6 6 6 6 6";
        String expectedResult = "one two three four five six";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }
}
