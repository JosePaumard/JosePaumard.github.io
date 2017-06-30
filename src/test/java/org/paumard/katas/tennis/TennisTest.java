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

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * Created by José
 */
public class TennisTest {

    @Test
    public void shoud_return_Love_Love_when_no_player_scored() {

        // Given
        TennisGame tennis = new TennisGame();
        String expectedScore = "Love Love";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_Fifteen_Love_when_player1_scored() {

        // Given
        TennisGame tennis = new TennisGame();
        tennis.player1Scores();
        String expectedScore = "Fifteen Love";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_Love_Fifteen_when_player2_scored() {

        // Given
        TennisGame tennis = new TennisGame();
        tennis.player2Scores();
        String expectedScore = "Love Fifteen";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_Fifteen_Fifteen_when_player1_scores_and_the_score_was_Love_Fifteen() {

        // Given
        TennisGame tennis = new TennisGame("Love Fifteen");
        tennis.player1Scores();
        String expectedScore = "Fifteen Fifteen";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_Fifteen_Fifteen_when_player2_scores_and_the_score_was_Fifteen_Love() {

        // Given
        TennisGame tennis = new TennisGame("Fifteen Love");
        tennis.player2Scores();
        String expectedScore = "Fifteen Fifteen";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_Thirty_Love_when_player1_scores_and_the_score_was_Fifteen_Love() {

        // Given
        TennisGame tennis = new TennisGame("Fifteen Love");
        tennis.player1Scores();
        String expectedScore = "Thirty Love";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_Fourty_Love_when_player1_scores_and_the_score_was_Thirty_Love() {

        // Given
        TennisGame tennis = new TennisGame("Thirty Love");
        tennis.player1Scores();
        String expectedScore = "Fourty Love";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_Love_Thirty_when_player2_scores_and_the_score_was_Love_Fifteen() {

        // Given
        TennisGame tennis = new TennisGame("Love Fifteen");
        tennis.player2Scores();
        String expectedScore = "Love Thirty";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_Love_Fourty_when_player2_scores_and_the_score_was_Love_Thirty() {

        // Given
        TennisGame tennis = new TennisGame("Love Thirty");
        tennis.player2Scores();
        String expectedScore = "Love Fourty";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_Deuce_when_player1_scores_and_the_score_was_Thirty_Fourty() {

        // Given
        TennisGame tennis = new TennisGame("Thirty Fourty");
        tennis.player2Scores();
        String expectedScore = "Deuce";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }
}
