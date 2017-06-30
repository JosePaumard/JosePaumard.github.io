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
package org.paumard.katas.tennis;

import java.util.Arrays;

/**
 * Created by José
 */
public class TennisGame {

    private int player1Score;
    private int player2Score;
    private String initialScore;

    public TennisGame() {
        this.player1Score = 0;
        this.player2Score = 0;
    }

    public TennisGame(String initialScore) {
        String[] scores = initialScore.split(" ");
        this.player1Score = convertScoreToInt(scores[0]);
        this.player2Score = convertScoreToInt(scores[1]);
    }

    private int convertScoreToInt(String score) {
        IndividualScore individualScore = IndividualScore.byLabel(score);
        return individualScore.score;
    }

    public String score() {
        if (this.player1Score >= 3 && this.player1Score == this.player2Score) {
            return "Deuce";
        }

        return convertScoreToString(player1Score) + " " + convertScoreToString(player2Score);
    }

    private String convertScoreToString(int score) {
        IndividualScore individualScore = IndividualScore.byScore(score);
        return individualScore.label;
    }

    public void player1Scores() {
        this.player1Score++;
    }

    public void player2Scores() {
        this.player2Score++;
    }

    private enum IndividualScore {
        LOVE(0, "Love"),
        FIFTEEN(1, "Fifteen"),
        THIRTY(2, "Thirty"),
        FOURTY(3, "Fourty");

        private final int score;
        private final String label;

        IndividualScore(int score, String label) {
            this.score = score;
            this.label = label;
        }

        public static IndividualScore byScore(int score) {
            return Arrays.stream(values()).filter(individualScore -> individualScore.score == score).findAny().get();
        }

        public static IndividualScore byLabel(String label) {
            return Arrays.stream(values()).filter(individualScore -> individualScore.label.equals(label)).findAny().get();
        }
    }
}
