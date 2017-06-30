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
        if (score.equals("Love")) {
            return 0;
        } else {
            return 1;
        }
    }

    public String score() {

        return convertScoreToString(player1Score) + " " + convertScoreToString(player2Score);
    }

    private String convertScoreToString(int score) {
        if (score == 1) {
            return "Fifteen";
        } else if (score == 2) {
            return "Thirty";
        }
        return "Love";
    }

    public void player1Scores() {
        this.player1Score++;
    }

    public void player2Scores() {
        this.player2Score++;
    }
}
