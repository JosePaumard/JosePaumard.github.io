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

package org.paumard.katas.anagrams;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by José
 */
public class AnagramsTest {

    @Test
    public void should_return_an_empty_result_list_for_an_empty_input_dictionary() {

        // Given
        List<String> dictionnary = new ArrayList<>();
        Anagrams anagrams = new Anagrams();

        // When
        List<List<String>> result = anagrams.computeAnagrams(dictionnary);

        // Then
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void should_return_an_empty_result_list_for_an_input_dictionary_that_contains_no_anagram() {

        // Given
        List<String> dictionnary = Arrays.asList("one", "two", "three");
        Anagrams anagrams = new Anagrams();

        // When
        List<List<String>> result = anagrams.computeAnagrams(dictionnary);

        // Then
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void should_return_the_correct_list_of_two_anagrams_for_an_input_dictionary_that_contains_two_anagram() {

        // Given
        List<String> dictionnary = Arrays.asList("one", "two", "three", "rots", "sort");
        Anagrams anagrams = new Anagrams();

        // When
        List<List<String>> result = anagrams.computeAnagrams(dictionnary);

        // Then
        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result.get(0)).containsOnly("rots", "sorts");
    }
}
