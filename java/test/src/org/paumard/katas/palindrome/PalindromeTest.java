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
}
