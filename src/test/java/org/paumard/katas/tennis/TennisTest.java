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
}
