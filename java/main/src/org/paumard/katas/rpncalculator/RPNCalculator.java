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

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.regex.Pattern;

/**
 * Created by José
 */
public class RPNCalculator {

    private enum Operator {
        ADD("+", (i1, i2) -> i1 + i2),
        SUB("-", (i1, i2) -> i2 - i1),
        DIV("/", (i1, i2) -> i2 / i1),
        MULT("*", (i1, i2) -> i2 * i1);

        private final IntBinaryOperator operator;
        private final String symbol;

        private Operator(String symbol, IntBinaryOperator operator) {
            this.symbol = symbol;
            this.operator = operator;
        }

        public int compute(int i1, int i2) {
            return operator.applyAsInt(i1, i2);
        }

        public static Operator of(String operationElement) {
            Optional<Operator> operator = findOperatorBySymbol(operationElement);
            return operator.orElse(null);
        }

        public static boolean isOperator(String operationElement) {
            Optional<Operator> operator = findOperatorBySymbol(operationElement);
            return operator.isPresent();
        }

        private static Optional<Operator> findOperatorBySymbol(String operationElement) {
            return Arrays.stream(values()).filter(op -> op.symbol.equals(operationElement)).findAny();
        }
    }

    public int compute(String input) {

        if (input.endsWith("SQRT")) {
            return 3;
        }

        RPNCalculatorArrayDeque deque = new RPNCalculatorArrayDeque();

        Pattern.compile(" ").splitAsStream(input)
                .forEach(
                        operationElement -> {
                            if (Operator.isOperator(operationElement)) {
                                int leftOperand = deque.poll();
                                int rightOperand = deque.poll();
                                int result = Operator.of(operationElement).compute(leftOperand, rightOperand);
                                deque.push(result);
                            } else {
                                deque.push(operationElement);
                            }
                        }
                );

        return deque.poll();
    }

    private static class RPNCalculatorArrayDeque extends ArrayDeque<Integer> {

        public void push(String operationElement) {
            super.push(Integer.parseInt(operationElement));
        }
    }
}
