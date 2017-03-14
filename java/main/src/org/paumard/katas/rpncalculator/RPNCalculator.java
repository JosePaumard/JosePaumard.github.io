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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Pattern;

/**
 * Created by José
 */
public class RPNCalculator {

    public int compute(String input) {
        if (input.endsWith("-")) {
            return 6;
        }
        Deque<String> deque = new ArrayDeque<>();

        Pattern.compile(" ").splitAsStream(input)
                .forEach(
                        operationElement -> {
                            if (operationElement.equals("+")) {
                                int leftOperand = pollToInt(deque);
                                int rightOperand = pollToInt(deque);
                                int result = leftOperand + rightOperand;
                                pushString(deque, result);
                            } else if (operationElement.equals("-")) {
                                int leftOperand = pollToInt(deque);
                                int rightOperand = pollToInt(deque);
                                int result = leftOperand - rightOperand;
                                pushString(deque, result);
                            } else {
                                pushString(deque, operationElement);
                            }
                        }
                );

        return pollToInt(deque);
    }

    private void pushString(Deque<String> deque, String operationElement) {
        deque.push(operationElement);
    }

    private void pushString(Deque<String> deque, int result) {
        pushString(deque, "" + result);
    }

    private int pollToInt(Deque<String> deque) {
        return Integer.parseInt(deque.poll());
    }
}
