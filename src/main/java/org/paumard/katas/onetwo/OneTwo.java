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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by José
 */
public class OneTwo {

    private enum Numbers {
        ONE("1", "one"),
        TWO("2", "two"),
        THREE("3", "three"),
        FOUR("4", "four"),
        FIVE("5", "five"),
        SIX("6", "six"),
        SEVEN("7", "seven"),
        EIGHT("8", "eight"),
        NINE("9", "nine");

        private final String number;

        public String getName() {
            return name;
        }

        private final String name;

        Numbers(String number, String name) {
            this.number = number;
            this.name = name;
        }

        public static Numbers byNumber(String number) {
            return Arrays.stream(values()).filter(value -> value.number.equals(number)).findFirst().get();
        }

        public static Numbers byNumber(int number) {
            return byNumber(Integer.toString(number));
        }
    }

    public String convertToNames(String input) {

        ArrayDeque<Integer> deque = splitToDeque(input);

        List<Integer> result = new ArrayList<>();
        int currentValue = deque.peek();
        int count = 0;
        while (!deque.isEmpty()) {
            boolean isValueChanging = deque.peek() != currentValue;
            boolean shouldResetCounter = count == 9;
            isValueChanging = isValueChanging || shouldResetCounter;

            addToResultIfChanging(result, currentValue, count, isValueChanging);
            count = incrementOrResetIfChanging(count, isValueChanging);
            currentValue = consumeAndUpdateIfChanging(deque, currentValue, isValueChanging);
        }
        addToResult(result, currentValue, count);


        return result.stream().map(Numbers::byNumber).map(Numbers::getName).collect(Collectors.joining(" "));
    }

    private ArrayDeque<Integer> splitToDeque(String input) {
        return Pattern.compile(" ").splitAsStream(input).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
    }

    private void addToResult(List<Integer> result, int currentValue, int count) {
        result.add(count);
        result.add(currentValue);
    }

    private void addToResultIfChanging(List<Integer> result, int currentValue, int count, boolean isValueChanging) {
        if (isValueChanging) {
            addToResult(result, currentValue, count);
        }
    }

    private int incrementOrResetIfChanging(int count, boolean isValueChanging) {
        if (isValueChanging) {
            count = 1;
        } else {
            count++;
        }
        return count;
    }

    private int consumeAndUpdateIfChanging(ArrayDeque<Integer> deque, int currentValue, boolean isValueChanging) {
        if (isValueChanging) {
            return deque.poll();
        } else {
            deque.poll();
            return currentValue;
        }
    }
}
