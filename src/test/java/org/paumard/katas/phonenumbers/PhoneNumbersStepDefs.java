package org.paumard.katas.phonenumbers;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class PhoneNumbersStepDefs {

    private List<String> phoneNumbersList;
    private boolean isConsistent;

    @Given("^The following list$")
    public void the_following_list(List<String> phoneNumbersList) throws Throwable {

        this.phoneNumbersList = phoneNumbersList;
    }

    @When("^The list is checked for consistency$")
    public void the_list_is_checked_for_consistency() throws Throwable {

        PhoneNumbers phoneNumbers = new PhoneNumbers();
        isConsistent = phoneNumbers.isConsistent(phoneNumbersList);
    }

    @Then("^The list is consistent$")
    public void the_list_is_consistent() throws Throwable {

        assertThat(isConsistent).isTrue();
    }

    @Then("^The list is not consistent$")
    public void the_list_is_not_consistent() throws Throwable {

        assertThat(isConsistent).isFalse();
    }
}
