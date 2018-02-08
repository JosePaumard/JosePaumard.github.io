import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WordWrapStepDefs {

    @Given("^a line of (\\d+) columns and the text (.*)$")
    public void a_line_of_n_columns_and_the_given_text(int numberOfColumns, String text) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^the text is broken into lines$")
    public void the_text_is_broken_into_lines() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the result is the following$")
    public void the_result_is_the_following(String result) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
