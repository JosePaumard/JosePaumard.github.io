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

import java.util.Arrays;

/**
 * Created by José
 */
public class OneTwo {

    private enum Numbers {
        ONE("1", "one"),
        TWO("2", "two"),
        THREE("3", "three"),
        FOUR("4", "four"),
        FIVE("5", "five");

        private final String number;
        private final String name;

        Numbers(String number, String name) {
            this.number = number;
            this.name = name;
        }

        public static Numbers byNumber(String number) {
            return Arrays.stream(values()).filter(value -> value.number.equals(number)).findFirst().get();
        }
    }

    public String convertToNames(String input) {

        Numbers number = Numbers.byNumber(input);
        return "one " + number.name;
    }
}
