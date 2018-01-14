package org.paumard.katas.minesweeper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.StrictAssertions.assertThat;


public class MineSweeperStepDefs {

    private MineSweeper mineSweeper;
    private String hintField;

    @Given("^The following field$")
    public void the_following_field(String inputField) throws Throwable {
        this.mineSweeper = new MineSweeper();
        this.mineSweeper.init(inputField);
    }

    @When("^The resulting field is computed$")
    public void the_resulting_field_is_computed() throws Throwable {
        this.hintField = this.mineSweeper.produceHintField();
    }

    @Then("^The result is the following$")
    public void the_result_is_the_following(String expectedResult) throws Throwable {
        assertThat(this.hintField).isEqualTo(expectedResult);
    }
}
