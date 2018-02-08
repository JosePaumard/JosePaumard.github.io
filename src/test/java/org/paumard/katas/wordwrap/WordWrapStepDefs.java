package org.paumard.katas.wordwrap;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

public class WordWrapStepDefs {

    private String line;
    private int numberOfColumns;
    private String result;

    @Given("^An empty line$")
    public void an_empty_line() throws Throwable {
        this.line = "";
    }

    @Given("^The following line (.*)$")
    public void the_following_line(String line) throws Throwable {
        this.line = line;
    }

    @And("^a (\\d+) columns page$")
    public void _a_number_of_columns(int numberOfColumns) throws Throwable {
        this.numberOfColumns = numberOfColumns;
    }

    @When("^the line is wrapped$")
    public void the_line_is_wrapped() throws Throwable {
        WordWrapper wordWrapper = new WordWrapper();
        this.result = wordWrapper.wrap(numberOfColumns, line);
    }

    @Then("^the result is an empty line$")
    public void the_result_is_an_empty_line() throws Throwable {
        Assertions.assertThat(this.result).isEmpty();
    }

    @Then("^the result is: (.*)$")
    public void the_result_is_hello(String expectedResult) throws Throwable {
        Assertions.assertThat(this.result).isEqualTo(expectedResult);
    }
}
