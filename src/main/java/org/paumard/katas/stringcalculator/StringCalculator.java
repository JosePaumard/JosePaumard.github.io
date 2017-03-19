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

package org.paumard.katas.stringcalculator;

import java.util.regex.Pattern;

/**
 * Created by José
 */
public class StringCalculator {

    private static final String SEPARATOR = ",";

    public int add(String input) {

        return Pattern.compile(SEPARATOR).splitAsStream(input).mapToInt(Integer::parseInt).sum();
    }
}
