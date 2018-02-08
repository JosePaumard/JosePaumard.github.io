package org.paumard.katas.wordwrap;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.paumard.katas.wordwrap.WordWrap;

public class WordWrapStepDefs {

    private WordWrap wordWrap;
    private int numberOfColumns;
    private String text;
    private String result;

    @Given("^a line of (\\d+) columns and the text (.*)$")
    public void a_line_of_n_columns_and_the_given_text(int numberOfColumns, String text) throws Throwable {

        this.wordWrap = new WordWrap();
        this.numberOfColumns = numberOfColumns;
        this.text = text;
    }

    @When("^the text is broken into lines$")
    public void the_text_is_broken_into_lines() throws Throwable {

        this.result = wordWrap.wrap(numberOfColumns, text);
    }

    @Then("^the result is the following$")
    public void the_result_is_the_following(String expectedResult) throws Throwable {

        Assertions.assertThat(this.result).isEqualTo(expectedResult);
    }
}
