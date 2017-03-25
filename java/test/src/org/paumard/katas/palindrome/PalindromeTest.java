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

package org.paumard.katas.palindrome;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by José
 */
public class PalindromeTest {

    @Test
    public void should_return_true_for_empty_string() {

        // Given
        Palindrome palindrome = new Palindrome();
        String input = "";
        boolean expectedResult =  true;

        // When
        boolean result = palindrome.isPalindrome(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_false_for_a_random_string() {

        // Given
        Palindrome palindrome = new Palindrome();
        String input = "Not a palindrome";
        boolean expectedResult =  false;

        // When
        boolean result = palindrome.isPalindrome(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_true_for_a_single_char_string() {

        // Given
        Palindrome palindrome = new Palindrome();
        String input = "A";
        boolean expectedResult =  true;

        // When
        boolean result = palindrome.isPalindrome(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_true_for_a_two_identical_chars_string() {

        // Given
        Palindrome palindrome = new Palindrome();
        String input = "AA";
        boolean expectedResult =  true;

        // When
        boolean result = palindrome.isPalindrome(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_true_for_a_three_chars_string_with_identical_begin_and_end() {

        // Given
        Palindrome palindrome = new Palindrome();
        String input = "ABA";
        boolean expectedResult =  true;

        // When
        boolean result = palindrome.isPalindrome(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_true_for_a_many_chars_palindrome() {

        // Given
        Palindrome palindrome = new Palindrome();
        String input = "ABCDEFGHIIHGFEDCBA";
        boolean expectedResult =  true;

        // When
        boolean result = palindrome.isPalindrome(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_true_for_a_many_chars_palindrome_with_blanks_and_a_mix_of_lower_upper_case() {

        // Given
        Palindrome palindrome = new Palindrome();
        String input = "Sore was I ere I saw Eros";
        boolean expectedResult =  true;

        // When
        boolean result = palindrome.isPalindrome(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }
}
