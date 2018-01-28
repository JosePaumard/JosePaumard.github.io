package org.paumard.katas.phonenumbers;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class PhoneNumbersStepDefs {

    private List<String> phoneNumbers;
    private boolean isConsistent;

    @Given("^The following list$")
    public void the_following_list(List<String> phoneNumbers) throws Throwable {
        this.phoneNumbers = phoneNumbers;
    }

    @When("^The list is analyzed$")
    public void the_list_is_analyzed() throws Throwable {
        PhoneNumbers phoneNumbers = new PhoneNumbers();
        this.isConsistent = phoneNumbers.checkForConsistency(this.phoneNumbers);
    }

    @Then("^The list is consistent$")
    public void the_list_is_consistent() throws Throwable {
        assertThat(isConsistent).isTrue();
    }
}
