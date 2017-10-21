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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

/**
 * Created by José
 */
public class TennisGameStepDefs {

    private TennisGame tennisGame;

    @Given("^A Tennis game with an initial score of (.*)$")
    public void a_tennis_game_with_initial_score(String initialScore) throws Throwable {
        this.tennisGame = new TennisGame(initialScore);
    }

    @When("^Player (\\d) scores$")
    public void the_scoring_player_is(int scoringPlayer) throws Throwable {
        if (scoringPlayer == 1) {
            tennisGame.player1Scores();
        } else {
            tennisGame.player2Scores();
        }
    }

    @Then("^the score is (.*)$")
    public void the_expected_score_is(String expectedScore) throws Throwable {
        String score = tennisGame.score();
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }
}
