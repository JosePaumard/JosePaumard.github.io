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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by José
 */
public class Anagrams {

    public List<List<String>> computeAnagrams(List<String> dictionnary) {

        Function<String, String> sortLetters = word -> {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            return new String(letters);
        };
        Map<String, List<String>> anagrams = dictionnary.stream()
                .collect(Collectors.groupingBy(sortLetters));

        anagrams.entrySet().removeIf(entry -> entry.getValue().size() == 1);

        return new ArrayList<>(anagrams.values());
    }

    public List<List<String>> findTheLongestAnagrams(List<String> dictionnary) {
        List<List<String>> anagrams = computeAnagrams(dictionnary);

        Map.Entry<Integer, List<List<String>>> entry =
                anagrams.stream()
                        .collect(Collectors.groupingBy(list -> list.get(0).length()))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByKey())
                        .get();

        return entry.getValue();
    }

    public List<List<String>> findTheBiggestAnagramicWord(List<String> dictionnary) {
        List<List<String>> anagrams = computeAnagrams(dictionnary);


        Map.Entry<Integer, List<List<String>>> entry =
                anagrams.stream()
                        .collect(Collectors.groupingBy(list -> list.size()))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByKey())
                        .get();

        return entry.getValue();
    }
}
